package lt.techin.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record RunningEventRequestDTO(@NotNull
                                     @NotBlank
                                     @Length(min = 5, max = 255)
                                     String name,
                                     @NotNull
                                     @Future
                                     LocalDate calendarDate,
                                     @NotNull
                                     @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
                                     String location,
                                     @NotNull
                                     @Min(1)
                                     int maxParticipants) {


}
