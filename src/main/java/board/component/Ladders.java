package board.component;

import exception.InvalidInputException;
import validator.InputValidator;

import java.util.Map;

public class Ladders implements ILadders {
    Map<Integer, Integer> pathMap;
    InputValidator validator;

    public Ladders() {
        this.validator = new InputValidator();
    }

    @Override
    public void setLadders(Map<Integer, Integer> pathMap) throws InvalidInputException {
        validator.isValidInput(pathMap, e -> e.getKey() < e.getValue(), "User input is invalid, Start(Key) < End(Value)");
        this.pathMap = pathMap;
    }

    @Override
    public boolean isLadder(Integer currentPosition) {
        return pathMap != null && pathMap.get(currentPosition) != null;
    }

    @Override
    public Integer nextPosition(Integer currentPosition) {
        return pathMap.get(currentPosition);
    }

}
