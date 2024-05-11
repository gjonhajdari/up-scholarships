package service;

import model.dto.CreateVoucherDto;
import repository.VoucherRepository;

import java.sql.Date;

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
}
