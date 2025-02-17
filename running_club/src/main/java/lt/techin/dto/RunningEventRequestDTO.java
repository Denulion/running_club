package lt.techin.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record RunningEventRequestDTO(@NotNull(message = "Name shouldn't be null!")
                                     @NotBlank(message = "Name can't be empty!")
                                     @Length(min = 5, max = 255, message = "Name is too long or too short! Minimum length is 5")
                                     String name,
                                     @NotNull(message = "Calendar date shouldn't be null!")
                                     @Future(message = "Should be in the future!")
                                     LocalDate calendarDate,
                                     @NotNull(message = "Location shouldn't be null!")
                                     @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Disallowed symbols! Only letters," +
                                             " numbers and whitespaces allowed!")
                                     String location,
                                     @NotNull(message = "Max number of participants shouldn't be null!")
                                     @Min(value = 1, message = "Minimum one participant!")
                                     int maxParticipants) {


}
