package programming.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Table {

    STUDENT(1, "student", "Студент"),

    MENTOR(2, "mentor", "Ментор"),

    PROGRAMMING_LANGUAGE(3, "programming_language", "Язык");

    private final int tableNumber;
    private final String title;
    private final String rusTitle;

    Table(int tableNumber, String title, String rusTitle) {
        this.tableNumber = tableNumber;
        this.title = title;
        this.rusTitle = rusTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getRusTitle() {
        return rusTitle;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public static Table findByTableNumber(int tableNumber) {
        for (Table table : Table.values()) {
            if (table.tableNumber == tableNumber) return table;
        }
        return null;
    }

    public static String buildOperationsList(Table table) {
        return Arrays.stream(Operation.values())
                .map(operation -> {
                    StringBuilder result = new StringBuilder(operation.getOperationNumber() + ". ");
                    if (Operation.BACK.equals(operation)) return  result.append(operation.getOperationTitle()).toString();
                    else return result.append(String.format(operation.getOperationTitle(), table.getRusTitle())).toString();
                })
                .collect(Collectors.joining("\n"));
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
