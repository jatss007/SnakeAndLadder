import java.util.Random;

public class Dice {
    int side;
    public Dice(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public int rollDice()
    {
        int min = 1;
        int max = getSide();
        int i = (int)(Math.random()*(max-min+1)+min);
        return i;
    }
}
