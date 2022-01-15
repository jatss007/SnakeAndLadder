import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderBoard {
    int numrows, numcolumns, numsnakes, numladders;
    int snakesPos[][];
    int laddersPos[][];
    Map<Player, Integer> map = new HashMap<>();
    boolean isWinner;

    public void setSnakesPos(int[][] snakesPos) {
        this.snakesPos = snakesPos;
    }

    public void setLaddersPos(int[][] laddersPos) {
        this.laddersPos = laddersPos;
    }

    public SnakeAndLadderBoard(int row, int column, int snakes, int ladders) {
        this.numrows = row+1;
        this.numcolumns = column+1;
        this.numsnakes = snakes;
        this.numladders = ladders;
        snakesPos = new int[snakes][2];
        laddersPos = new int[ladders][2];
    }

    public void initilize() {

    }

    public boolean isWinner(Player player) {
        return map.entrySet().stream().anyMatch(e -> ((Player) e.getKey()).getName().equals(player.getName()) && e.getValue() == 100);
    }

    public void set(SnakeAndLadderMove snakeAndLadderMove, Player currentPlayer) throws InvalidMoveException {
        int currentPost = map.getOrDefault(currentPlayer, 0);
        int newPost = getNewPost(currentPost, snakeAndLadderMove.getRoll());
        System.out.println(currentPlayer.getName() + " moved from " + currentPost + " to " + newPost);
        if(newPost > 100)
            throw new InvalidMoveException("New Position can't be greater than");
        map.put(currentPlayer, newPost);
    }

    private int getNewPost(int currentPost, int roll) {
        int newPost = currentPost + roll;

        int newPostAfterSnakeChecking = checkSnakes(newPost);
        if(newPostAfterSnakeChecking != -1)
            return newPostAfterSnakeChecking;

        int newPostAfterLadderChecking = checkLadders(newPost);
        if(newPostAfterLadderChecking != -1)
            return newPostAfterLadderChecking;
        return newPost;
    }

    private int checkSnakes(int newPost) {
        for (int i=0; i< snakesPos.length; i++){
            if(snakesPos[i][0] == newPost)
                return snakesPos[i][1];
        }
        return -1;
    }

    private int checkLadders(int newPost) {
        for (int i=0; i< laddersPos.length; i++){
            if(laddersPos[i][0] == newPost)
                return laddersPos[i][1];
        }
        return -1;
    }

    public long getNoOfPlayerCleared() {
        return map.values().stream().filter(value -> value == 100).count();
    }
}
