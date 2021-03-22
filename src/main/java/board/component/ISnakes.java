package board.component;

import exception.InvalidInputException;

import java.util.Map;

public interface ISnakes {
    void setSnakes(Map<Integer, Integer> pathMap) throws InvalidInputException;
    boolean isSnake(Integer currentPosition);
    Integer nextPosition(Integer currentPosition);
}
