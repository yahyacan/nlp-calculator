package com.nlp;

import com.nlp.enums.ArithmeticOperators;
import com.nlp.enums.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        System.out.println(list);

        while (list.size() > 1){
            String result = "";
            int optIndex = -1;
            if (list.contains(ArithmeticOperators.DIVIDE.name())){
                optIndex = list.indexOf(ArithmeticOperators.DIVIDE.name());
                result = test.calculate(ArithmeticOperators.DIVIDE.name(), list.get(optIndex-1), list.get(optIndex+1) );
            }else if(list.contains(ArithmeticOperators.MULTIPLY.name())){
                optIndex = list.indexOf(ArithmeticOperators.MULTIPLY.name());
                result = test.calculate(ArithmeticOperators.MULTIPLY.name(), list.get(optIndex-1), list.get(optIndex+1) );
            }else if(list.contains(ArithmeticOperators.ADD.name())){
                optIndex = list.indexOf(ArithmeticOperators.ADD.name());
                result = test.calculate(ArithmeticOperators.ADD.name(), list.get(optIndex-1), list.get(optIndex+1) );
            }else if(list.contains(ArithmeticOperators.SUBTRACT.name())){
                optIndex = list.indexOf(ArithmeticOperators.SUBTRACT.name());
                result = test.calculate(ArithmeticOperators.SUBTRACT.name(), list.get(optIndex-1), list.get(optIndex+1) );
            }
            list.remove(optIndex + 1);
            list.remove(optIndex);
            list.set(optIndex - 1, result );
        }
        DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
        System.out.println("Sonuç : " + df.format(new Double(list.get(0))));

    }

    public List<String> getAllItems(){
        List<String> list = new ArrayList<>();
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
