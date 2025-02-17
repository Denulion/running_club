package lt.techin.controller;

import jakarta.validation.Valid;
import lt.techin.dto.*;
import lt.techin.model.Registration;
import lt.techin.model.RunningEvent;
import lt.techin.model.User;
import lt.techin.service.RegistrationService;
import lt.techin.service.RunningEventService;
import lt.techin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final RunningEventService runningEventService;
    private final UserService userService;

    public RegistrationController(RegistrationService registrationService, RunningEventService runningEventService, UserService userService) {
        this.registrationService = registrationService;
        this.runningEventService = runningEventService;
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/events/{eventId}/register")
    public ResponseEntity<?> addRegistration(@Valid @RequestBody RegistrationRequestDTO registrationRequestDTO, @PathVariable Long eventId,
                                             Authentication authentication) {
        if (!runningEventService.existsById(eventId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not Found");
        }
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //User user = userService.findUserById(registrationRequestDTO.user()).get();
        RunningEvent runningEvent = runningEventService.findRunningEventById(eventId).get();

        Registration registration = RegistrationRequestMapper.toRegistration(registrationRequestDTO, runningEvent);

        Registration savedRegistration = registrationService.saveRegistration(registration);

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(savedRegistration.getId())
                                .toUri())
                .body(RegistrationResponseMapper.toRegistrationResponseDTO(savedRegistration));
    }
}
