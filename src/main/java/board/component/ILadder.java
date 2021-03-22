package board.component;

public interface ILadder {
    boolean isLadder(Integer currentPosition);

    Integer nextPosition(Integer currentPosition);
}
