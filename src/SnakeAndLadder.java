import java.util.*;
import java.util.stream.Collectors;

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
        try {
            SnakeAndLadderMove currentMove = (SnakeAndLadderMove) move;
            Player currentPlayer = players.get(currentPlayerIndex);
            board.set(currentMove, currentPlayer);
            changeTurn(currentMove);
        }
        catch (InvalidMoveException e){
            return;
        }

    }

    @Override
    void displayGame() {

    }

    @Override
    protected boolean hasWinner() {
        return board.isWinner(players.get(currentPlayerIndex));
    }

    private long noOfPlayerCleared() {
        return board.getNoOfPlayerCleared();
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

    @Override protected boolean stopGame() {
        return (noOfPlayerCleared() == players.size() -1);
    }

    @Override
    protected void updatePlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private void changeTurn(SnakeAndLadderMove currentMove){
//        List<SnakeAndLadderMove> gameMoves = moves.stream().map(move -> (SnakeAndLadderMove) move).collect(Collectors.toList());
//        gameMoves.add(currentMove);
        if(checkUpdatePlayer(currentMove)){
            updatePlayer();
        }
    }

    private boolean checkUpdatePlayer(SnakeAndLadderMove currentMove) {
        return threeSixRules(currentMove) || singleSixNoChangeTurn(currentMove);
    }

    private boolean singleSixNoChangeTurn(SnakeAndLadderMove gameMoves) {
        return gameMoves.getRoll() != 6;
    }

    private boolean threeSixRules(SnakeAndLadderMove currentMove) {
        int getLastMovesSize = Math.min(getCurrentPlayer().getAllMoves().size() , 3);
        List<SnakeAndLadderMove> gameMoves = getCurrentPlayer().lastNMoves(getLastMovesSize).stream().map(move -> (SnakeAndLadderMove) move).collect(Collectors.toList());

        long count = gameMoves.stream().filter(gameMove -> gameMove.getRoll() == 6).count();
        if(count == 3)
            board.updatePost(getCurrentPlayer(), gameMoves.get(0).getStart());
        return count == 3;
    }

}
