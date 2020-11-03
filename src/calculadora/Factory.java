package calculadora;

public class Factory {
    
    public static Strategy action(String action) {
        switch (action) {
            case "+":
                return Sum.getInstance();
            case "-":
                return Subtract.getInstance();
            case "*":
                return Multiply.getInstance();
            case "/":
                return Share.getInstance();
            default: 
                return null;
        }
    }
}

