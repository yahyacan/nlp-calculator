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
            ArithmeticOperators operator = null;

            if (list.contains(ArithmeticOperators.DIVIDE.name())){
                optIndex = list.indexOf(ArithmeticOperators.DIVIDE.name());
                operator = ArithmeticOperators.DIVIDE;
            }else if(list.contains(ArithmeticOperators.MULTIPLY.name())){
                optIndex = list.indexOf(ArithmeticOperators.MULTIPLY.name());
                operator = ArithmeticOperators.MULTIPLY;
            }else if(list.contains(ArithmeticOperators.ADD.name())){
                optIndex = list.indexOf(ArithmeticOperators.ADD.name());
                operator = ArithmeticOperators.ADD;
            }else if(list.contains(ArithmeticOperators.SUBTRACT.name())){
                optIndex = list.indexOf(ArithmeticOperators.SUBTRACT.name());
                operator = ArithmeticOperators.SUBTRACT;
            }
            if (optIndex == -1 || operator == null){
                System.out.println("Not calculated!");
                return;
            }

            result = operator.getResult(Double.parseDouble(list.get(optIndex-1)),Double.parseDouble(list.get(optIndex+1))) + "";
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
            Optional<Number> optionalNumber =
                    Arrays.stream(Number.values())
                            .filter(op -> op.name().equalsIgnoreCase(token))
                            .findFirst();
            if (optionalNumber.isPresent()) {
                list.add(optionalNumber.get().getValue() + "");
                continue;
            }

            Optional<ArithmeticOperators> optionalArithmeticOperators =
                    Arrays.stream(ArithmeticOperators.values())
                            .filter(op -> op.getLabels().contains(token))
                            .findFirst();
            if (optionalArithmeticOperators.isPresent()) {
                list.add(optionalArithmeticOperators.get().name() + "");
                continue;
            }
        }
        return list;
    }

}
