import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanPlayer implements Player {
    private String name;
    private List<Dice> dice;
    private DiceRollingStrategy strategy;
    private List<Move> playersMove;
    public HumanPlayer(String name, List<Dice> dice, DiceRollingStrategy strategy) {
        this.name = name;
        this.dice = dice;
        this.strategy = strategy;
        playersMove = new ArrayList<>();
    }

    @Override public String getName() {
        return name;
    }

    @Override
    public Move makeMove(PlayerState state) {
        try {
            int rolledValue = strategy.getRolledValue(dice);
            System.out.print(name + " rolled a "+ dice.size()+ " dices and got " + rolledValue );
            int start = moveSize() == 0 ? 0 : ((SnakeAndLadderMove) lastMove()).getEnd();
            int end = start + rolledValue;
            SnakeAndLadderMove snakeAndLadderMove = new SnakeAndLadderMove(rolledValue, start , end);
            playersMove.add(snakeAndLadderMove);
            return snakeAndLadderMove;
        } catch (Exception ignored) {

        }
        return null;
    }

    @Override
    public List<Move> lastNMoves(int n) {
        return playersMove.subList(moveSize()-n, moveSize()) ;
    }

    @Override
    public List<Move> getAllMoves() {
        return  playersMove;
    }

    public int moveSize(){
        return playersMove.size();
    }

    public Move lastMove() {
        return playersMove.get(playersMove.size()-1);
    }
}
