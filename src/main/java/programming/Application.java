package programming;

import programming.enums.Operation;
import programming.enums.Table;
import programming.service.MentorService;
import programming.service.MenuService;
import programming.service.ProgrammingLanguageService;
import programming.service.StudentService;

import java.util.Scanner;

public class Application {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        MentorService mentorService = new MentorService();
        ProgrammingLanguageService programmingLanguageService = new ProgrammingLanguageService();

        while (true) {
            MenuService.printMenu();
            System.out.println("Введите номер таблицы.");
            int tableNumber = scanner.nextInt();
            Table table = Table.findByTableNumber(tableNumber);
            if (table == null) System.out.println("Введён неверный номер таблицы");
            else {
                MenuService.printOperationsList(table);
                System.out.println("Введите номер операции.");
                int operationNumber = scanner.nextInt();
                Operation operation = Operation.findByOperationNumber(operationNumber);
                if (operation == null) System.out.println("Введён неверный номер операции");
                else {
                    switch (operation) {
                        case FIRST:
                            studentService.findById();
                            break;
                        case SECOND:
                            mentorService.findById();
                            break;
                        case THIRD:
                            programmingLanguageService.findById();
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
                            break;
                    }
                }
            }
        }
    }
}
