package board.component;

import exception.InvalidInputException;
import validator.InputValidator;

import java.util.HashMap;
import java.util.Map;

public class Ladder implements ILadder {
    private Map<Integer, Integer> pathMap;

    public Ladder(Integer start, Integer end) throws InvalidInputException {
        pathMap = new HashMap<>();
        pathMap.put(start, end);
        ValidateInput();
    }

    private void ValidateInput() throws InvalidInputException {
        InputValidator validator = new InputValidator();
        validator.isValidInput(pathMap, e -> e.getKey() < e.getValue(), "User input is invalid, it must be Start(Key) < End(Value).");
    }

    @Override
    public boolean isLadder(Integer currentPosition) {
        return pathMap != null && null != pathMap.get(currentPosition);
    }

    @Override
    public Integer nextPosition(Integer currentPosition) {
        Integer nextPosition = pathMap.get(currentPosition);
        return nextPosition;
    }

}
