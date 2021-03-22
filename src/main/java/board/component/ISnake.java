package board.component;

public interface ISnake {
    boolean isSnake(Integer currentPosition);

    Integer nextPosition(Integer currentPosition);
}
