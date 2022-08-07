package programming.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "programming_language")
public class ProgrammingLanguage extends BasePersist{

    @Column(name = "language_name")
    private String languageName;

    @OneToOne
    private Mentor mentor;

    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(String languageName) {
        this.languageName = languageName;
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

    @Override
    public String toString() {
        return "ProgrammingLanguage{" +
                "languageName='" + languageName + '\'' +
                ", mentors=" + mentor +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), languageName, mentor);
    }
}
