package calculatorProgram;

public class Calculations {

    public Calculations() {

    }

    public String calculate(String mathsProblem){

        if(mathsProblem.equalsIgnoreCase("")){
            return "Please input maths problem here.";
        } else{
            String[] mathsOperation = mathsProblem.trim().split(" ");
            String firstValue = mathsOperation[0];
            float firstFloat = Float.parseFloat(firstValue);
            String operands = mathsOperation[1];
            String secondValue = mathsOperation[2];
            float secondFloat = Float.parseFloat(secondValue);
            float result;
            String resultInString;
            
            switch(operands){
                case "+": result = firstFloat + secondFloat;
                break;
                case "-" : result = firstFloat - secondFloat;
                break;
                case "*" : result = firstFloat * secondFloat;
                break;
                case "/" : result = firstFloat / secondFloat;
                break;
                default: result = 0;
            }  
    
            resultInString = Float.toString(result);
    
            return resultInString;
        }

    }

    
}
