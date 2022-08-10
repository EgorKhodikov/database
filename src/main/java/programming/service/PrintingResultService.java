package programming.service;

import programming.bean.Mentor;
import programming.bean.ProgrammingLanguage;
import programming.bean.Student;

import java.util.List;

public class PrintingResultService {

    public static void printStudent(Student student) {
        System.out.println("студент: " + student.getLastName() + "\n"
                + "этап: " + student.getStage() + "\n"
                + "ментор: " + student.getMentor().getLastName());
    }

    public static void printMentor(Mentor mentor) {
        System.out.println("ментор: " + mentor.getLastName() + "\n"
                + "язык: " + mentor.getProgrammingLanguage().getLanguageName());
    }

    public static void printProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        System.out.println("язык: " + programmingLanguage.getLanguageName());
    }

    public static void printStudentsNumber(Integer number) {
        System.out.println("количество студентов: " + number);
    }

    public static void printMentorNamesList(List<String> mentorNamesList) {
        System.out.println("список менторов:");
        mentorNamesList.forEach(System.out::println);
    }

    public static void printLanguageNamesList(List<String> languageNamesList) {
        System.out.println("список языков:");
        languageNamesList.forEach(System.out::println);
    }
}
