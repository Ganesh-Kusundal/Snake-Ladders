package board.component;

import exception.InvalidInputException;
import validator.InputValidator;

import java.util.HashMap;
import java.util.Map;

public class GreenSnake implements ISnake {
    private Map<Integer, Integer> pathMap;

    public GreenSnake(Integer mouth, Integer tail) throws InvalidInputException {
        pathMap = new HashMap<>();
        pathMap.put(mouth, tail);
        ValidateInput();
    }

    private void ValidateInput() throws InvalidInputException {
        InputValidator validator = new InputValidator();
        validator.isValidInput(pathMap, e -> e.getKey() > e.getValue(), "User input is invalid, it must be mouth value > tail value.");
    }

    @Override
    public boolean isSnake(Integer currentPosition) {
        return pathMap != null && null != pathMap.get(currentPosition);
    }

    @Override
    public Integer nextPosition(Integer currentPosition) {
        Integer nextPosition = pathMap.get(currentPosition);
        pathMap.remove(currentPosition);
        return nextPosition;
    }
}
