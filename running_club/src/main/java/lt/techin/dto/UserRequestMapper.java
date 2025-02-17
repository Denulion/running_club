package lt.techin.dto;

import lt.techin.model.User;

public class UserRequestMapper {


    public static User toUser(UserRequestDTO userRequestDTO) {
        User user = new User();

        user.setUsername(userRequestDTO.username());
        user.setPassword(userRequestDTO.password());
        user.setRoles(RoleMapper.toRoleListFromDTO(userRequestDTO.roles()));

        return user;
    }
}
