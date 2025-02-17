package lt.techin.repository;

import lt.techin.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {


    List<Registration> findByUser_Id(long id);

    List<Registration> findByRunningEvent_Id(long id);
}
