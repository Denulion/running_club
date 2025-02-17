package lt.techin.controller;

import jakarta.validation.Valid;
import lt.techin.dto.*;
import lt.techin.model.Registration;
import lt.techin.model.RunningEvent;
import lt.techin.model.User;
import lt.techin.service.RegistrationService;
import lt.techin.service.RunningEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RunningEventController {

    private final RunningEventService runningEventService;
    private final RegistrationService registrationService;

    public RunningEventController(RunningEventService runningEventService, RegistrationService registrationService) {
        this.runningEventService = runningEventService;
        this.registrationService = registrationService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    @GetMapping("/events")
    public ResponseEntity<List<RunningEventResponseDTO>> getEvents() {
        return ResponseEntity.ok(RunningEventResponseMapper.toRunningEventResponseDTOList(runningEventService.findAllRunningEvents()));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/events")
    public ResponseEntity<?> addEvent(@Valid @RequestBody RunningEventRequestDTO runningEventRequestDTO) {
        RunningEvent runningEvent = RunningEventRequestMapper.toRunningEvent(runningEventRequestDTO);

        RunningEvent savedRunningEvent = runningEventService.saveRunningEvent(runningEvent);

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(savedRunningEvent.getId())
                                .toUri())
                .body(RunningEventResponseMapper.toRunningEventResponseDTO(savedRunningEvent));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/events/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable long eventId) {
        if (!runningEventService.existsById(eventId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }

        runningEventService.deleteRunningEventById(eventId);
        return ResponseEntity.status(HttpStatus.OK).body("Event successfully canceled");
    }

    @GetMapping("/events/{eventId}/participants")
    public ResponseEntity<?> getEventParticipants(@PathVariable long eventId) {
        if (!runningEventService.existsById(eventId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not Found");
        }

        List<Registration> registrations = registrationService.getRegistrationsByRunningEventId(eventId);
        List<User> users = new ArrayList<>();

        for (Registration registration : registrations) {
            users.add(registration.getUser());
        }

        return ResponseEntity.ok(EventParticipantsMapper.eventParticipantsDTOList(users));
    }
}
