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

  public static boolean isEmpty(Object... fields) {
    for (Object field : fields) {
      if (field == null) {
        return true;
      }
    }
    return false;
  }

  public static String clearSpaces(String str) {
    return str.trim();
  }
}
