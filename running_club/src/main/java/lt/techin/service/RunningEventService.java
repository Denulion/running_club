package lt.techin.service;

import lt.techin.model.RunningEvent;
import lt.techin.model.User;
import lt.techin.repository.RunningEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RunningEventService {

    private final RunningEventRepository runningEventRepository;

    @Autowired
    public RunningEventService(RunningEventRepository runningEventRepository) {
        this.runningEventRepository = runningEventRepository;
    }

    public boolean existsById(Long id) {
        return runningEventRepository.existsById(id);
    }

    public RunningEvent saveRunningEvent(RunningEvent runningEvent) {
        return runningEventRepository.save(runningEvent);
    }

    public List<RunningEvent> findAllRunningEvents() {
        return runningEventRepository.findAll();
    }

    public void deleteRunningEventById(long id) {
        runningEventRepository.deleteById(id);
    }

    public Optional<RunningEvent> findRunningEventById(Long eventId) {
        return runningEventRepository.findById(eventId);
    }

//    public List<User> findUsersByEventId(long id) {
//        return runningEventRepository.findByRunningEvent_Id(id);
//    }
}
