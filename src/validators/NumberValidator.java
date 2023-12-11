package validators;

public class NumberValidator {

    public boolean isNumber(String numberStr) {
        try{
            Integer.parseInt(numberStr);
            return true;
        }
        catch(NumberFormatException ignoring){
            return false;
        }
    }
}
