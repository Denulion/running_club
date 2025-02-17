package lt.techin.repository;

import lt.techin.model.RunningEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunningEventRepository extends JpaRepository<RunningEvent, Long> {


}
