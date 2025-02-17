package lt.techin.dto;

import lt.techin.model.RunningEvent;

import java.util.List;

public class RunningEventResponseMapper {


    public static List<RunningEventResponseDTO> toRunningEventResponseDTOList(List<RunningEvent> allRunningEvents) {
        return allRunningEvents.stream()
                .map(i -> new RunningEventResponseDTO(i.getId(),
                        i.getName(), i.getCalendarDate(), i.getLocation(), i.getMaxParticipants()))
                .toList();
    }

    public static RunningEventResponseDTO toRunningEventResponseDTO(RunningEvent runningEvent) {
        return new RunningEventResponseDTO(runningEvent.getId(), runningEvent.getName(),
                runningEvent.getCalendarDate(), runningEvent.getLocation(), runningEvent.getMaxParticipants());
    }
}
