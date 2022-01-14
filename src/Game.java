public abstract class Game {

    abstract void init();
    abstract void makeMove(Move move);
    abstract void displayGame();
    protected abstract boolean hasWinner();
    protected abstract Player getCurrentPlayer();
    protected abstract String getName();
    protected abstract PlayerState getPlayerState(Player currentPlayer);

    void play(){
        System.out.println("Starting game + "+ getName());
        init();

        do {
            displayGame();
            Player currentPlayer = getCurrentPlayer();
            PlayerState playerState = getPlayerState(currentPlayer);
            Move move = currentPlayer.makeMove(playerState);
            makeMove(move);
        }
        while(!hasWinner());

        System.out.println(getCurrentPlayer().getName() +": has won \n Boom ");


    }


}
