package programming.service;

import programming.enums.Table;

public class MenuService {
    public static void printMenu() {
        System.out.println(Table.buildMenu());
    }

    public static void printOperationsList(Table table) {
        System.out.println(Table.buildOperationsList(table));
    }
}
