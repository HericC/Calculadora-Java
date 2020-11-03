package calculadora;

public class Subtract implements Strategy {
    private static Subtract subtract;
    
    private Subtract() {
        
    }
    
    public static Subtract getInstance() {
        if (Subtract.subtract == null) {
            Subtract.subtract = new Subtract();
        }
        return Subtract.subtract;
    }
    
    @Override
    public float execute(String a, String b) {
        System.out.println(a);
        return Float.parseFloat(a) - Float.parseFloat(b);
    }
}
