package lt.techin.dto;

import lt.techin.model.User;

import java.util.List;

public class EventParticipantsMapper {

    public static List<EventParticipantsDTO> eventParticipantsDTOList(List<User> users) {
        return users.stream()
                .map(i -> new EventParticipantsDTO(i.getId(), i.getUsername()))
                .toList();
    }


}
