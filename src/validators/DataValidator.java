package validators;

public class DataValidator {

    public boolean validate(String comandStr, Enum[] commandsData){

        for (Enum command: commandsData){
            if(command.name().equals(comandStr))
                return true;
        }

        return false;
    }
}
