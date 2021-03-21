package board.square;

import org.apache.commons.lang3.StringUtils;

public class Square {
    private final SquareType squareType;
    private String currentPosition;

    public Square(String currentPosition, SquareType squareType) {
        this.currentPosition = currentPosition;
        this.squareType = squareType;
    }

    public Square(String currentPosition) {
        this(currentPosition, SquareType.VOID);
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String displayCurrentPosition() {
        return StringUtils.leftPad(currentPosition, 3, "0");
    }

    public SquareType getSquareType() {
        return squareType;
    }

}
