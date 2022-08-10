package programming.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mentor")
public class Mentor extends BasePersist{

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    private ProgrammingLanguage programmingLanguage;

    public Mentor() {
    }

    public Mentor(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "lastName='" + lastName + '\'' +
                ", programmingLanguage=" + programmingLanguage +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mentor mentor = (Mentor) o;
        return Objects.equals(lastName, mentor.lastName) && Objects.equals(programmingLanguage, mentor.programmingLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lastName, programmingLanguage);
    }
}
