package programming.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "programming_language")
public class ProgrammingLanguage extends BasePersist{

    @Column(name = "language_name")
    private String languageName;

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

    @Override
    public String toString() {
        return "ProgrammingLanguage{" +
                "languageName='" + languageName + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProgrammingLanguage that = (ProgrammingLanguage) o;
        return Objects.equals(languageName, that.languageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), languageName);
    }
}
