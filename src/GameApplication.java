public class GameApplication {

    public static void main(String[] args) {
        System.out.println("Starting the Game");
        Game game = SnakeAndLadderFactory.getBasicGame();
        game.play();
    }

}
