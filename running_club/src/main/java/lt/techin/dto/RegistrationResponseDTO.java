package lt.techin.dto;

import java.time.LocalDate;

public record RegistrationResponseDTO(long id,
                                      long user_id,
                                      String eventName,
                                      LocalDate registrationDate) {

}
