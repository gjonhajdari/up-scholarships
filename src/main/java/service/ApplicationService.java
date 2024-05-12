package service;

import repository.ApplicationRepository;

public class ApplicationService {
  public static boolean updateStatus(int applicationId, String status) {
    return ApplicationRepository.updateStatus(applicationId, status);
  }
}
