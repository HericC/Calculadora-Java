package calculadora;

public class Sum implements Strategy {
    private static Sum sum;
    
    private Sum() {
        
    }
    
    public static Sum getInstance() {
        if (Sum.sum == null) {
            Sum.sum = new Sum();
        }
        return Sum.sum;
    }
    
    @Override
    public float execute(String a, String b) {
        return Float.parseFloat(a) + Float.parseFloat(b);
    }
}
