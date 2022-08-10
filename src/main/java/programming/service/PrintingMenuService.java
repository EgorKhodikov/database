package programming.service;

import programming.enums.Table;

public class PrintingMenuService {
    public static void printMenu() {
        System.out.println(Table.buildMenu());
    }

    public static void printOperationsList(Table table) {
        System.out.println(Table.buildOperationsList(table));
    }
}
