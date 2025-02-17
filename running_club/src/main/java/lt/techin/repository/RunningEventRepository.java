package lt.techin.repository;

import lt.techin.model.RunningEvent;
import lt.techin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunningEventRepository extends JpaRepository<RunningEvent, Long> {


//    List<User> findByRunningEvent_Id(long id);
}
