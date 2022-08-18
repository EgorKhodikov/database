package programming;

import programming.enums.Operation;
import programming.enums.Table;
import programming.service.*;
import programming.util.HibernateSessionFactoryUtil;

import java.util.Scanner;

public class Application {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HibernateSessionFactoryUtil.getSessionFactory();
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
                PrintingResultService printingResultService = new PrintingResultService();
                PrintingMenuService.printOperationsList(table);
                System.out.println("Введите номер операции.");
                int operationNumber = scanner.nextInt();
                Operation operation = Operation.findByOperationNumber(operationNumber);
                if (operation == null) System.out.println("Введён неверный номер операции");
                else {
                    switch (operation) {
                        case FIND_BY_ID:
                            switch (table) {
                                case STUDENT:
                                    printingResultService.printStudent(studentService.findById());
                                    break;
                                case MENTOR:
                                    printingResultService.printMentor(mentorService.findById());
                                    break;
                                case PROGRAMMING_LANGUAGE:
                                    printingResultService.printProgrammingLanguage(programmingLanguageService.findById());
                                    break;
                            }
                            break;
                        case INSERT:
                            switch (table) {
                                case STUDENT:
                                    studentService.save();
                                    break;
                                case MENTOR:
                                    mentorService.save();
                                    break;
                                case PROGRAMMING_LANGUAGE:
                                    programmingLanguageService.save();
                                    break;
                            }
                            break;
                        case UPDATE:
                            switch (table) {
                                case STUDENT:
                                    studentService.update();
                                    break;
                                case MENTOR:
                                    mentorService.update();
                                    break;
                                case PROGRAMMING_LANGUAGE:
                                    programmingLanguageService.update();
                                    break;
                            }
                            break;
                        case DELETE:
                            switch (table) {
                                case STUDENT:
                                    studentService.delete();
                                    break;
                                case MENTOR:
                                    mentorService.delete();
                                    break;
                                case PROGRAMMING_LANGUAGE:
                                    programmingLanguageService.delete();
                                    break;
                            }
                            break;
                        case BACK:
                            break;
                    }
                }
            }
        }
    }
}
