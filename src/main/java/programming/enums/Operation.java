package programming.enums;

public enum Operation {

    BACK("Вернуться к выбору таблицы"),
    FIND_BY_ID("Поиск сущности \"%s\" по id"),
    INSERT("Внесение сущности \"%s\" в базу"),
    UPDATE("Обновление сущности \"%s\"."),
    DELETE("Удаление \"%s\" из базы");

    private final String operationTitle;

    Operation(String operationTitle) {
        this.operationTitle = operationTitle;
    }

    public String getOperationTitle() {
        return operationTitle;
    }

    public static Operation findByOperationNumber(int operationNumber) {
        for (Operation operation : Operation.values()) {
            if (operation.ordinal() == operationNumber) return operation;
        }
        return null;
    }
}
