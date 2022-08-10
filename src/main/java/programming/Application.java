package programming;

import programming.enums.Operation;
import programming.enums.Table;
import programming.service.*;

import java.util.Scanner;

public class Application {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        MentorService mentorService = new MentorService();
        ProgrammingLanguageService programmingLanguageService = new ProgrammingLanguageService();

        while (true) {
            PrintingMenuService.printMenu();
            System.out.println("Введите номер таблицы.");
            int tableNumber = scanner.nextInt();
            Table table = Table.findByTableNumber(tableNumber);
            if (table == null) System.out.println("Введён неверный номер таблицы");
            else {
                PrintingMenuService.printOperationsList(table);
                System.out.println("Введите номер операции.");
                int operationNumber = scanner.nextInt();
                Operation operation = Operation.findByOperationNumber(operationNumber, table);
                if (operation == null) System.out.println("Введён неверный номер операции");
                else {
                    switch (operation) {
                        case FIRST:
                            PrintingResultService.printStudent(studentService.findById());
                            break;
                        case SECOND:
                            PrintingResultService.printMentor(mentorService.findById());
                            break;
                        case THIRD:
                            PrintingResultService.printProgrammingLanguage(programmingLanguageService.findById());
                            break;
                        case FOURTH:
                            studentService.save();
                            break;
                        case FIFTH:
                            mentorService.save();
                            break;
                        case SIXTH:
                            programmingLanguageService.save();
                            break;
                        case SEVENTH:
                            studentService.update();
                            break;
                        case EIGHTH:
                            mentorService.update();
                            break;
                        case NINTH:
                            programmingLanguageService.update();
                            break;
                        case TENTH:
                            studentService.delete();
                            break;
                        case ELEVENTH:
                            mentorService.delete();
                            break;
                        case TWELFTH:
                            programmingLanguageService.delete();
                            break;
                        case THIRTEENTH:
                            PrintingResultService.printStudentsNumber(studentService
                                    .countStudentsNumberByLanguageName());
                            break;
                        case FOURTEENTH:
                        case EIGHTEENTH:
                        case TWENTY_FIRST:
                            break;
                        case FIFTEENTH:
                            PrintingResultService.printMentor(mentorService.findByIdHql());
                            break;
                        case SIXTEENTH:
                            PrintingResultService.printMentorNamesList(mentorService
                                    .findMentorNamesListByStudentStages());
                            break;
                        case SEVENTEENTH:
                            PrintingResultService.printMentor(mentorService.findMentorByLanguageId());
                            break;
                        case NINETEENTH:
                            PrintingResultService.printLanguageNamesList(programmingLanguageService
                                    .findLanguageNamesListFromMentors());
                            break;
                        case TWENTIETH:
                            PrintingResultService.printProgrammingLanguage(programmingLanguageService
                                    .findLanguageByMentorId());
                            break;
                    }
                }
            }
        }
    }
}
