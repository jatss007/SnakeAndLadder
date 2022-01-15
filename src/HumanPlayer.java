import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanPlayer implements Player {
    String name;
    List<Dice> dice;
    public HumanPlayer(String name, List<Dice> dice) {
        this.name = name;
        this.dice = dice;
    }

    @Override public String getName() {
        return name;
    }

    @Override
    public Move makeMove(PlayerState state) {
        try {
            Integer finalRolledValue = dice.stream().map(dice -> dice.rollDice()).reduce(0, Integer::sum);


            System.out.println(name + ": Rolled a "+ dice.size()+ " dice and got " + finalRolledValue );
            return new SnakeAndLadderMove(finalRolledValue);
        } catch (Exception ignored) {

        }
        return null;
    }
}
