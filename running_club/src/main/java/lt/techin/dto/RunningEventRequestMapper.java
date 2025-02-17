package lt.techin.dto;

import jakarta.validation.Valid;
import lt.techin.model.RunningEvent;

import java.util.ArrayList;

public class RunningEventRequestMapper {


    public static RunningEvent toRunningEvent(RunningEventRequestDTO runningEventRequestDTO) {
        RunningEvent runningEvent = new RunningEvent();

        runningEvent.setName(runningEventRequestDTO.name());
        runningEvent.setCalendarDate(runningEventRequestDTO.calendarDate());
        runningEvent.setLocation(runningEventRequestDTO.location());
        runningEvent.setMaxParticipants(runningEventRequestDTO.maxParticipants());

        return runningEvent;
    }
}
