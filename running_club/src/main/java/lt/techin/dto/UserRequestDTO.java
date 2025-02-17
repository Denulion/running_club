package lt.techin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lt.techin.validation.Lowercase;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record UserRequestDTO(@NotNull
                             @NotBlank
                             @Lowercase
                             @Length(min = 4, max = 100)
                             String username,
                             @NotNull
                             @NotBlank
                             @Length(min = 6, max = 150)
                             String password,
                             @NotEmpty
                             @NotNull
                             List<RoleDTO> roles) {


}
