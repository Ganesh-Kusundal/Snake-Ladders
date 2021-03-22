package board.component;

import exception.InvalidInputException;

import java.util.Map;

public interface ILadders {
    void setLadders(Map<Integer, Integer> pathMap) throws InvalidInputException;
    boolean isLadder(Integer currentPosition);
    Integer nextPosition(Integer currentPosition);
}
