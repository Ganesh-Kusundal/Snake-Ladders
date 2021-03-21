package validator;

import exception.InvalidInputException;

import java.util.Map;
import java.util.function.Predicate;

public class InputValidator {
    public void isValidInput(Map<Integer, Integer> map, Predicate<Map.Entry<Integer, Integer>> predicate) throws InvalidInputException {
        if(map != null && map.entrySet().stream().anyMatch(predicate.negate()))
            throw new InvalidInputException("User input is invalid");
    }
}
