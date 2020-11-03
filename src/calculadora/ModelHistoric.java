package calculadora;

public class ModelHistoric {
    private final int id;
    private final String expression;
    private final String result;
    
    public ModelHistoric(int id, String expression, String result) {
        this.id = id;
        this.expression = expression;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }
}
