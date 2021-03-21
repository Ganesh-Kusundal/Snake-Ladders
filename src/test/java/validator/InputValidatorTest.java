package validator;

import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    void testInputValidator() {
        InputValidator validator = new InputValidator();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        assertThrows(InvalidInputException.class, () -> validator.isValidInput(map, e -> e.getKey() > e.getValue()));
    }
}