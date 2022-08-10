package programming.enums;

import java.util.Arrays;
import java.util.List;

public enum Table {

    STUDENT(1, "student", Arrays.asList(Operation.FIRST, Operation.FOURTH, Operation.SEVENTH,
            Operation.TENTH, Operation.THIRTEENTH, Operation.FOURTEENTH)),
    MENTOR(2, "mentor", Arrays.asList(Operation.SECOND, Operation.FIFTH, Operation.EIGHTH,
            Operation.ELEVENTH, Operation.FIFTEENTH, Operation.SIXTEENTH, Operation.SEVENTEENTH, Operation.EIGHTEENTH)),
    PROGRAMMING_LANGUAGE(3, "programming_language", Arrays.asList(Operation.THIRD, Operation.SIXTH,
            Operation.NINTH, Operation.TWELFTH, Operation.NINETEENTH, Operation.TWENTIETH, Operation.TWENTY_FIRST));
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

    public static String buildOperationsList(Table table) {
        StringBuilder operationsList = new StringBuilder();
        for (Operation operation : table.getOperations()) {
            String s = operation.getOperationNumber() + ". " + operation.getOperationTitle() + "\n";
            operationsList.append(s);
        }
        return operationsList.toString();
    }

    public static String buildMenu() {
        StringBuilder menu = new StringBuilder();
        for (Table table : Table.values()) {
            String s = table.tableNumber + ". " + table.title + "\n";
            menu.append(s);
        }
        return menu.toString();
    }
}
