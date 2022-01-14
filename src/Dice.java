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
        Random random = new Random();
        int i = random.nextInt(side);
        System.out.println("Rolled and got "+ i);
        return i;
    }
}
