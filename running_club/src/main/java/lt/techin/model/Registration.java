package lt.techin.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "running_event_id")
    private RunningEvent runningEvent;

    private LocalDate registrationDate;

    public Registration(User user, RunningEvent runningEvent, LocalDate registrationDate) {
        this.user = user;
        this.runningEvent = runningEvent;
        this.registrationDate = registrationDate;
    }

    public Registration() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RunningEvent getRunningEvent() {
        return runningEvent;
    }

    public void setRunningEvent(RunningEvent runningEvent) {
        this.runningEvent = runningEvent;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
