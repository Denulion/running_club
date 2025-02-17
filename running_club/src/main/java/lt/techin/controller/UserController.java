package lt.techin.controller;

import jakarta.validation.Valid;
import lt.techin.dto.UserRequestDTO;
import lt.techin.dto.UserRequestMapper;
import lt.techin.dto.UserResponseMapper;
import lt.techin.model.User;
import lt.techin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO, Authentication authentication) {

        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are already registered!");
        }

        if (userService.existsUserByUsername(userRequestDTO.username())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this username already exists!");
        }

        User user = UserRequestMapper.toUser(userRequestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userService.saveUser(user);

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(savedUser.getId())
                                .toUri())
                .body(UserResponseMapper.toUserResponseDTO(savedUser));
    }

}
