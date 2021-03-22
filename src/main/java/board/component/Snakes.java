package board.component;

import exception.InvalidInputException;
import validator.InputValidator;

import java.util.Map;

public class Snakes implements ISnakes {
    Map<Integer, Integer> pathMap;
    InputValidator validator;

    public Snakes() {
        this.validator = new InputValidator();
    }

    @Override
    public void setSnakes(Map<Integer, Integer> pathMap) throws InvalidInputException {
        validator.isValidInput(pathMap, e -> e.getKey() > e.getValue(), "User input is invalid, Start(Key) > End(Value)");
        this.pathMap = pathMap;
    }

    @Override
    public boolean isSnake(Integer currentPosition) {
        return pathMap != null && pathMap.get(currentPosition) != null;
    }

    @Override
    public Integer nextPosition(Integer currentPosition) {
        return pathMap.get(currentPosition);
    }


}
