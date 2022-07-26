package programming.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mentor")
public class Mentor extends BasePersist{

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "mentor")
    private List<Student> students;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return lastName + " programming language: " + programmingLanguage + " students: " + students;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lastName, students, programmingLanguage);
    }
}
