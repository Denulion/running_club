package lt.techin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lt.techin.validation.Lowercase;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record UserRequestDTO(@NotNull(message = "Name can't be null!")
                             @NotBlank(message = "Name can't be null!")
                             @Lowercase(message = "Username should be written in lowercase letters!")
                             @Length(min = 4, max = 100, message = "Allowed length is 4-100")
                             String username,
                             @NotNull(message = "Password can't be null!")
                             @NotBlank(message = "Password can't be null!")
                             @Length(min = 6, max = 150, message = "Allowed length is 6-150")
                             String password,
                             @NotEmpty(message = "Roles can't be empty!")
                             @NotNull(message = "Roles can't be null!")
                             List<RoleDTO> roles) {


}
