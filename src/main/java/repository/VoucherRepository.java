package repository;

import model.ApplicantWithData;
import model.Voucher;
import model.VoucherApplied;
import model.dto.CreateVoucherDto;
import model.filter.VoucherAppliedFilter;
import utils.DatabaseUtils;
import utils.ResultSetUtils;

import java.sql.*;
import java.util.List;

public class VoucherRepository {
  public static boolean create(CreateVoucherDto voucherData) {
    String query = "INSERT INTO voucher (title, amount, deadline, category, description) VALUES (?, ?, ?, ?, ?)";

    String title = voucherData.getTitle();
    Float amount = voucherData.getAmount();
    Date deadline = voucherData.getDeadline();
    String category = voucherData.getCategory();
    String description = voucherData.getDescription();

    return DatabaseUtils.executeUpdate(query, title, amount, deadline, category, description);
  }


  public static boolean apply(int voucherId, String studentId) {
    String query = "INSERT INTO application (voucher_id, student_id) VALUES (?, ?)";
    return DatabaseUtils.executeUpdate(query, voucherId, studentId);
  }


  public static List<Voucher> getAll() {
    String query = "SELECT * FROM voucher";
    return getVouchers(query);
  }


  public static List<VoucherApplied> getAllApplied(VoucherAppliedFilter filter) {
    String query = """
            SELECT *
            FROM voucher
            JOIN application ON voucher.voucher_id = application.voucher_id
            WHERE 1 = 1
            """;
    String filterQuery = filter.buildQuery();
    query += filterQuery;

    return DatabaseUtils.executeSelect(query, ResultSetUtils::VoucherAppliedResultSet);
  }

  
  public static List<Voucher> getAllValid(String studentId) {
    String query = """
            SELECT * FROM voucher
              WHERE voucher.voucher_id NOT IN (
                  SELECT application.voucher_id FROM application
                  WHERE application.student_id = ?
                )
            AND deadline > CURDATE();
            """;

    return getVouchers(query, studentId);
  }


  public static List<ApplicantWithData> getApplicantsFromVoucherId(int voucherId) {
    String query = """
            SELECT application.application_id, student.student_id, student.first_name, student.last_name, application.application_date, application.status 
            FROM voucher
            JOIN application ON voucher.voucher_id = application.voucher_id
            JOIN student ON application.student_id = student.student_id
            WHERE voucher.voucher_id = ?
            """;

    return getApplicants(query, voucherId);
  }


  public static List<VoucherApplied> getAppliedByStudentId(String studentId) {
    String query = """
            SELECT *
            FROM voucher
            JOIN application ON voucher.voucher_id = application.voucher_id
            WHERE application.student_id = ?
            """;

    return DatabaseUtils.executeSelect(query, ResultSetUtils::VoucherAppliedResultSet, studentId);
  }

  public static VoucherApplied getAppliedById(int id) {
    String query = """
            SELECT *
            FROM voucher
            JOIN application ON voucher.voucher_id = application.voucher_id
            WHERE application.application_id = ?
            """;

    return getAppliedVoucher(query, id);
  }


  public static Voucher getById(int id) {
    String query = "SELECT * FROM voucher WHERE voucher_id = ?";
    return DatabaseUtils.getOne(query, ResultSetUtils::VoucherResultSet, id);
  }


  private static List<Voucher> getVouchers(String query, Object... params) {
    return DatabaseUtils.executeSelect(query, ResultSetUtils::VoucherResultSet, params);
  }


  private static List<ApplicantWithData> getApplicants(String query, Object... params) {
    return DatabaseUtils.executeSelect(query, ResultSetUtils::ApplicantResultSet, params);
  }


  private static VoucherApplied getAppliedVoucher(String query, Object... params) {
    return DatabaseUtils.getOne(query, ResultSetUtils::VoucherAppliedResultSet, params);
  }


  private static ApplicantWithData getApplicant(String query, Object... params) {
    return DatabaseUtils.getOne(query, ResultSetUtils::ApplicantResultSet, params);
  }
}
