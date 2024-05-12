package service;

import model.Voucher;
import model.dto.CreateVoucherDto;
import repository.VoucherRepository;

import java.sql.Date;
import java.util.List;

public class VoucherService {
  public static boolean createVoucher(String title, String amount, String deadline, String category, String description) {
    Float amountFloat;
    Date deadLineDate;

    try {
      amountFloat = Float.parseFloat(amount);
      deadLineDate = Date.valueOf(deadline);
    } catch (Exception e) {
      return false;
    }

    if (amountFloat <= 0) {
      return false;
    }

    CreateVoucherDto validatedVoucherData = new CreateVoucherDto(
      Validator.clearSpaces(title),
      amountFloat,
      deadLineDate,
      Validator.clearSpaces(category),
      Validator.clearSpaces(description)
    );

    return VoucherRepository.create(validatedVoucherData);
  }

  public static List<Voucher> getAllVouchers() {
    return VoucherRepository.getAll();
  }

  public static List<Voucher> getAllValidVouchers() {
    String studentId = UserSession.getInstance(null).getId();
    return VoucherRepository.getAllValid(studentId);
  }

  public static Voucher getVoucherById(int id) {
    return VoucherRepository.getById(id);
  }

  public static boolean apply(int voucherId, String id) {
    return VoucherRepository.apply(voucherId, id);
  }
}
