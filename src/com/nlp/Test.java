package com.nlp;

import com.nlp.enums.ArithmeticOperators;
import com.nlp.enums.Number;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

/**
 * @author yahya
 */
public class Test {

    public static void main(String[] args) throws ParseException {

        Test test = new Test();
        List<String> list = test.getAllItems();

        while (list.size() > 1){
            String result = "";
            int optIndex = -1;
            String operator = "";
            if (list.contains(ArithmeticOperators.DIVIDE.name())){
                optIndex = list.indexOf(ArithmeticOperators.DIVIDE.name());
                operator = ArithmeticOperators.DIVIDE.name();
            }else if(list.contains(ArithmeticOperators.MULTIPLY.name())){
                optIndex = list.indexOf(ArithmeticOperators.MULTIPLY.name());
                operator = ArithmeticOperators.MULTIPLY.name();
            }else if(list.contains(ArithmeticOperators.ADD.name())){
                optIndex = list.indexOf(ArithmeticOperators.ADD.name());
                operator = ArithmeticOperators.ADD.name();
            }else if(list.contains(ArithmeticOperators.SUBTRACT.name())){
                optIndex = list.indexOf(ArithmeticOperators.SUBTRACT.name());
                operator = ArithmeticOperators.SUBTRACT.name();
            }
            if (optIndex == -1){
                System.out.println("Not calculated!");
                return;
            }
            result = test.calculate(operator, list.get(optIndex-1), list.get(optIndex+1) );
            list.remove(optIndex + 1);
            list.remove(optIndex);
            list.set(optIndex - 1, result );
        }
        DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
        System.out.println("Result: " + df.format(new Double(list.get(0))));

    }

    public List<String> getAllItems(){
        List<String> list = new ArrayList<>();
        System.out.println("Please enter a calculation: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().toUpperCase(Locale.ENGLISH);
        StringTokenizer st = new StringTokenizer(text, " ");
        while (st.hasMoreElements()){
            String token = st.nextToken();
            Number number = Number.findByName(token);
            if (number != null)
                list.add(number.getValue() + "");
            else{
                ArithmeticOperators operators = ArithmeticOperators.findByName(token);
                if (operators != null)
                    list.add(operators.name());
            }
        }
        return list;
    }

    public String  calculate(String operator, String number1, String number2){
        Double value1 = new Double(number1);
        Double value2 = new Double(number2);
        if (ArithmeticOperators.ADD.name().equals(operator)) {
            return (value1+value2) + "";
        }else if (ArithmeticOperators.SUBTRACT.name().equals(operator)) {
            return (value1-value2) + "";
        }else if (ArithmeticOperators.DIVIDE.name().equals(operator)) {
            return (value1/value2) + "";
        } else if (ArithmeticOperators.MULTIPLY.name().equals(operator)) {
            return (value1*value2) + "";
        }else
            return "0";
    }

}
