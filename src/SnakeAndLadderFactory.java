import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderFactory {


    public static Game getBasicGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of snakes");
        int snakes = sc.nextInt();
        int snakesPos[][] = new int[snakes][2];
        for(int i=0;i< snakes; i++){
            snakesPos[i][0] = sc.nextInt();
            snakesPos[i][1] = sc.nextInt();
        }

        System.out.println("Enter no. of ladders");
        int ladders = sc.nextInt();
        int laddersPos[][] = new int[ladders][2];
        for(int i=0;i< ladders; i++){
            laddersPos[i][0] = sc.nextInt();
            laddersPos[i][1] = sc.nextInt();
        }
        SnakeAndLadderBoard board = new SnakeAndLadderBoard(10, 10, snakes, ladders);
        board.setSnakesPos(snakesPos);
        board.setLaddersPos(laddersPos);

        Dice dice = new Dice(6);

        System.out.println("Enter no. of players");
        int noOfPlayers = sc.nextInt();
        List<Player> players = new ArrayList<>();
        sc.nextLine();
        for (int i=0;i<noOfPlayers; i++) {
            String name = sc.nextLine();
            players.add(new HumanPlayer(name, Arrays.asList(dice)));
        }
        return new SnakeAndLadder(board, Arrays.asList(dice), players);
    }
}
