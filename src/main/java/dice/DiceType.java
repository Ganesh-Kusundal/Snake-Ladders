package dice;

public enum DiceType {
    NORMAL_DICE(1), CROOCKED_DICE(2);

    private Integer rank;

    DiceType(Integer rank) {
        this.rank = rank;
    }

    public DiceType getDiceTypeFromRank(Integer rank) {
        if (rank == 2)
            return CROOCKED_DICE;
        return NORMAL_DICE;
    }
}
