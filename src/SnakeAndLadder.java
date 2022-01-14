import java.util.*;

public class SnakeAndLadder extends Game {

    private SnakeAndLadderBoard board;
    private List<Player> players;
    private List<Dice> dice;
    private int currentPlayerIndex;

    public SnakeAndLadder(SnakeAndLadderBoard board, List<Dice> dice, List<Player> players) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.currentPlayerIndex = 0;
        init();
    }

    @Override void init() {
        board.initilize();
    }

    @Override void makeMove(Move move) {
        if (!(move instanceof SnakeAndLadderMove)) {
            return;
        }
        SnakeAndLadderMove snakeAndLadderMove = (SnakeAndLadderMove) move;
        board.set(snakeAndLadderMove,  players.get(currentPlayerIndex));
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    @Override void displayGame() {
    }

    @Override protected boolean hasWinner() {
        return board.hasWinner();
    }

    @Override protected Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    @Override protected String getName() {
        return "SnakeAndLadder";
    }

    @Override protected PlayerState getPlayerState(Player currentPlayer) {
        return null;
    }

}
