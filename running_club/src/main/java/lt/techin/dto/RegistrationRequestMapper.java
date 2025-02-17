package lt.techin.dto;

import lt.techin.model.Registration;
import lt.techin.model.RunningEvent;

import java.time.LocalDate;

public class RegistrationRequestMapper {


    public static Registration toRegistration(RegistrationRequestDTO registrationRequestDTO, RunningEvent runningEvent) {
        Registration registration = new Registration();

        registration.setUser(registrationRequestDTO.user());
        registration.setRunningEvent(runningEvent);
        registration.setRegistrationDate(LocalDate.now());

        return registration;
    }
}
