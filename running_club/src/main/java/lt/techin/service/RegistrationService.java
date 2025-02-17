package lt.techin.service;

import lt.techin.model.Registration;
import lt.techin.model.User;
import lt.techin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public List<Registration> getRegistrationsByUserId(long id) {
        return registrationRepository.findByUser_Id(id);
    }

    public List<Registration> getRegistrationsByRunningEventId(long id) {
        return registrationRepository.findByRunningEvent_Id(id);
    }
}
