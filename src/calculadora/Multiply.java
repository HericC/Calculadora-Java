package calculadora;

public class Multiply implements Strategy {
    private static Multiply multiply;
    
    private Multiply() {
        
    }
    
    public static Multiply getInstance() {
        if (Multiply.multiply == null) {
            Multiply.multiply = new Multiply();
        }
        return Multiply.multiply;
    }
    
    @Override
    public float execute(String a, String b) {
        return Float.parseFloat(a) * Float.parseFloat(b);
    }
}
