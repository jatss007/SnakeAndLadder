public class SnakeAndLadderMove extends Move {
    private final int start;
    private final int end;
    private final int roll;
    public SnakeAndLadderMove(int roll, int start, int end) {
        this.roll = roll;
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getRoll() {
        return roll;
    }

}

