package service;

public class Validator {
  public static boolean isEmpty(String... fields) {
    for (String field : fields) {
      if (field.isEmpty()) {
        return true;
      }
    }
    return false;
  }
}
