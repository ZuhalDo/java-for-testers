package com.serenitydojo.calculator;

public class Calculator {

    public int evaluate(String expression) throws IllegalMathsOperatorException {


        expression =expression.trim();
        //char operator = findOperator(expression);


        if(expression.isEmpty()) {
            return 0;
        }

        String[] tokens = expression.split(" ");
        int result = parseInteger(tokens[0]);

        for(int i=1;i<tokens.length; i+=2){
           String operator=tokens[i];
           int nextOp= parseInteger(tokens[i+1]);

           switch (operator){
               case "+":
                   result +=nextOp;
                   break;
               case "-":
                   result -= nextOp;
                   break;
               case "/":
                   result /= nextOp;
                   break;
               case "*":
                   result *= nextOp;
                   break;
               default:
                   throw new IllegalMathsOperatorException("Operator " +operator + "is not legal");
           }
        }

        return result;
    }

    public int parseInteger(String token){
        return Integer.parseInt(token);
    }

}
