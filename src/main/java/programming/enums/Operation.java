package programming.enums;

public enum Operation {

    FIRST(1, "Поиск студента по id."),
    SECOND(2, "Поиск ментора по id."),
    THIRD(3, "Поиск языка по id."),
    FOURTH(4, "Внесение студента в базу."),
    FIFTH(1, "Внесение ментора в базу."),
    SIXTH(2, "Внесение языка в базу."),
    SEVENTH(3, "Обновление студента."),
    EIGHTH(4, "Обновление ментора."),
    NINTH(1, "Обновление языка."),
    TENTH(2, "Удаление студента из базы."),
    ELEVENTH(3, "Удаление ментора из базы."),
    TWELFTH(4, "Удаление языка из базы."),
    THIRTEENTH(5, "Вернуться к выбору таблицы.");
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
