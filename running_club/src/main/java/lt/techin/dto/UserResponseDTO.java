package lt.techin.dto;

import java.util.List;

public record UserResponseDTO(long id,
                              String username,
                              List<RoleDTO> roles) {
}
