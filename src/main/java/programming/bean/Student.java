package programming.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student extends BasePersist{

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "stage")
    private Integer stage;

    @ManyToOne
    private Mentor mentor;

    public Student() {
    }

    public Student(String lastName, Integer stage) {
        this.lastName = lastName;
        this.stage = stage;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", stage=" + stage +
                ", mentor=" + mentor +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lastName, stage, mentor);
    }
}

