package calculadora;

import java.util.ArrayList;

public class Calculator {
    private static  Calculator calculator;
    private final Context context;
    
    
    private Calculator() {
        this.context = new Context();
    }

    public static void main(String[] args) {
        // Realização de testes sem o CRUD
        Calculator calculator = Calculator.getInstance();
        String result = calculator.calculate("-30+(-67*2)+10+5*((5+8)/2+2)+2/(10+5*((5+8)/2+2)+2+(9-7*(5/3))+4+6)-232*(57/26*3)/(-123+23*(-32)+4*((455+10)+(44-(-5))))");
        //String result = calculator.calculate("-2+5");
        System.out.println(result);
    }
    
    public static Calculator getInstance() {
        if (Calculator.calculator == null) Calculator.calculator = new Calculator();
        return Calculator.calculator;
    }
    
    public String calculate(String value) {
        ArrayList<String> arr = this.getExpression(value);
        System.out.println(arr);
        
        double result = this.check(arr);
        String strResult = Double.toString(result);
        return strResult;
    }
    
    private ArrayList<String> getExpression(String value) {
        ArrayList<String> arr = new ArrayList<>();
        String str = "";
        
        for (int i = 0; i < value.length(); i++) {
            String v = value.substring(i,i+1);
            
            if (v.equals(",")) v = ".";

            if ("+-*/()".contains(v)) {
                if ((v.equals("-") && i == 0) || (i > 0 && value.substring(i-1,i+1).equals("(-"))) {
                    str += v;
                } else {
                    if (!str.equals("")) arr.add(str);
                    arr.add(v);
                    str = "";
                }
            } else {
                str += v;
            }
        }
        if (!str.equals("")) arr.add(str);
        return arr;
    }
    
    private double check(ArrayList<String> arr) {
        double total = 0;

        while (arr.indexOf("(") > -1) arr = this.parentheses(arr);
        while (arr.indexOf(")") > -1) arr = this.parentheses(arr);
        String[] operators = {"/", "*", "-", "+"};

        for (String operator : operators) {
            while (true) {
                int i = arr.indexOf(operator);
                if (i == -1) break;
                
                String previous = arr.get(i-1);
                String next = arr.get(i+1);
                
                this.context.setStrategy(Factory.action(operator));
                total = this.context.executeStrategy(previous, next);
                System.out.println(arr);
                arr.remove(i-1);
                arr.remove(i-1);
                arr.remove(i-1);
                arr.add(i-1, Double.toString(total));
            }
            total = Double.parseDouble(arr.get(0));
        }
        return total;
    }
    
    private ArrayList<String> parentheses(ArrayList<String> arr) {
        int pos = arr.indexOf("(");
        int lastPos = pos;

        while (true) {
            pos++;
            if (pos < arr.size()) {
                if (arr.get(pos).equals("(")) lastPos = pos;
                if (arr.get(pos).equals(")")) break;
            } else if (pos == 1000) {
                break;
            }
        }
        ArrayList<String> ex = new ArrayList<>();

        while (true) {
            ex.add(arr.get(lastPos));
            arr.remove(lastPos);
            if (arr.get(lastPos).equals(")")) {
                ex.add(arr.get(lastPos));
                arr.remove(lastPos);
                break;
            }
        }
        ex.remove(0);
        ex.remove(ex.size()-1);
        arr.add(lastPos, Double.toString(this.check(ex)));
        return arr;
    }
}
