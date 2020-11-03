package calculadora;

public class Share implements Strategy {
    private static Share share;
    
    private Share() {
        
    }
    
    public static Share getInstance() {
        if (Share.share == null) {
            Share.share = new Share();
        }
        return Share.share;
    }
    
    @Override
    public float execute(String a, String b) {
        return Float.parseFloat(a) / Float.parseFloat(b);
    }
}
