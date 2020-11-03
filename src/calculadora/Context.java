package calculadora;


public class Context {
    private Strategy strategy;
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public double executeStrategy(String a, String b) {
        return this.strategy.execute(a, b);
    }
}
