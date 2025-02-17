package lt.techin.dto;

import lt.techin.model.Registration;

public class RegistrationResponseMapper {


    public static RegistrationResponseDTO toRegistrationResponseDTO(Registration registration) {
        return new RegistrationResponseDTO(registration.getId(), registration.getUser().getId(),
                registration.getRunningEvent().getName(), registration.getRegistrationDate());
    }
}
