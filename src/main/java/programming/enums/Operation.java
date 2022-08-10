package programming.enums;

public enum Operation {

    FIRST(1, "Поиск студента по id."),
    SECOND(1, "Поиск ментора по id."),
    THIRD(1, "Поиск языка по id."),
    FOURTH(2, "Внесение студента в базу."),
    FIFTH(2, "Внесение ментора в базу."),
    SIXTH(2, "Внесение языка в базу."),
    SEVENTH(3, "Обновление студента."),
    EIGHTH(3, "Обновление ментора."),
    NINTH(3, "Обновление языка."),
    TENTH(4, "Удаление студента из базы."),
    ELEVENTH(4, "Удаление ментора из базы."),
    TWELFTH(4, "Удаление языка из базы."),
    THIRTEENTH(5, "Количество студентов, изучающих конкретный язык."),
    FOURTEENTH(6, "Вернуться к выбору таблицы."),
    FIFTEENTH(5, "Поиск ментора по id(HQL)."),
    SIXTEENTH(6, "Вывести список фамилий менторов, обучающих студентов на конкретном stage."),
    SEVENTEENTH(7, "Поиск ментора по id языка."),
    EIGHTEENTH(8, "Вернуться к выбору таблицы."),
    NINETEENTH(5, "Вывести список названий языков среди менторов."),
    TWENTIETH(6, "Поиск языка по id ментора."),
    TWENTY_FIRST(7, "Вернуться к выбору таблицы.");
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

    public static Operation findByOperationNumber(int operationNumber, Table table) {
        for (Operation operation : table.getOperations()) {
            if (operation.operationNumber == operationNumber) return operation;
        }
        return null;
    }
}
