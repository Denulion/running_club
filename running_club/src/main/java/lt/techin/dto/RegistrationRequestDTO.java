package lt.techin.dto;

import jakarta.validation.constraints.NotNull;
import lt.techin.model.User;

public record RegistrationRequestDTO(@NotNull
                                     User user) {


}
