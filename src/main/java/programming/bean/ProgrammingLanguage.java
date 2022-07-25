package programming.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "programming_language")
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "language_name")
    private String languageName;

    @OneToOne(mappedBy = "programmingLanguage")
    private Mentor mentor;

    @OneToMany(mappedBy = "programmingLanguage")
    private List<Student> students;

    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(String languageName) {
        this.languageName = languageName;
    }

    public Integer getId() {
        return id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return languageName + " mentor: " + mentor + " students: " + students;
    }
}
