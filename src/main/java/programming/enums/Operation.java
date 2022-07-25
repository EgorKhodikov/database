package programming.enums;

public enum Operation {

    FIRST(1, "Поиск студента по id"),
    SECOND(2, "Поиск ментора по id"),
    THIRD(3, "Поиск языка по id"),
    FOURTH(4, "Внесение студента в базу"),
    FIFTH(5, "Внесение ментора в базу"),
    SIXTH(6, "Внесение языка в базу"),
    SEVENTH(7, "Обновление студента"),
    EIGHTH(8, "Обновление ментора"),
    NINTH(9, "Обновление языка"),
    TENTH(10, "Удаление студента из базы"),
    ELEVENTH(11, "Удаление ментора из базы"),
    TWELFTH(12, "Удаление языка из базы");
    private final int operationNumber;
    private final String operationTitle;

    Operation(int operationNumber, String operationTitle) {
        this.operationNumber = operationNumber;
        this.operationTitle = operationTitle;
    }

    public int getOperationNumber() {
        return operationNumber;
    }

    public String getOperationTitle() {
        return operationTitle;
    }

    public static Operation findByOperationNumber(int operationNumber) {
        for (Operation operation : Operation.values()) {
            if (operation.operationNumber == operationNumber) return operation;
        }
        return null;
    }
}
