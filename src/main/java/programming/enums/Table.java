package programming.enums;

import java.util.Arrays;
import java.util.List;

public enum Table {

    STUDENT(1, "student", Arrays.asList(Operation.FIRST, Operation.SECOND, Operation.THIRD,
            Operation.FOURTH)),
    MENTOR(2, "mentor", Arrays.asList(Operation.FIFTH, Operation.SIXTH, Operation.SEVENTH,
            Operation.EIGHTH)),
    PROGRAMMING_LANGUAGE(3, "programming_language", Arrays.asList(Operation.NINTH, Operation.TENTH,
            Operation.ELEVENTH, Operation.TWELFTH));
    private final int tableNumber;
    private final String title;
    private final List<Operation> operations;

    Table(int tableNumber, String title, List<Operation> operations) {
        this.tableNumber = tableNumber;
        this.title = title;
        this.operations = operations;
    }

    public String getTitle() {
        return title;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public static Table findByTableNumber(int tableNumber) {
        for (Table table : Table.values()) {
            if (table.tableNumber == tableNumber) return table;
        }
        return null;
    }

    public static void showOperations(Table table) {
        for (Operation operation : table.getOperations()) {
            System.out.println(operation.getOperationNumber() + ". " + operation.getOperationTitle());
        }
    }

    public static void buildMenu() {
        System.out.println(STUDENT.tableNumber + ". " + STUDENT.title + "\n" +
                MENTOR.tableNumber + ". " + MENTOR.title + "\n" +
                PROGRAMMING_LANGUAGE.tableNumber + ". " + PROGRAMMING_LANGUAGE.title + "\n");
    }
}
