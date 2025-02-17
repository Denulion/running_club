package lt.techin.dto;

import jakarta.validation.constraints.NotNull;
import lt.techin.model.User;

public record RegistrationRequestDTO(@NotNull(message = "User shouldn't be null!")
                                     User user) {


}
