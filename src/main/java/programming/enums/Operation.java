package programming.enums;

public enum Operation {

    BACK(0, "Вернуться к выбору таблицы"),

    FIND_BY_ID(1, "Поиск сущности \"%s\" по id"),
    INSERT(2, "Внесение сущности \"%s\" в базу"),
    UPDATE(3, "Обновление сущности \"%s\"."),
    DELETE(4, "Удаление \"%s\" из базы");

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
        for (Operation operation : Operation.values()) {
            if (operation.operationNumber == operationNumber) return operation;
        }
        return null;
    }
}
