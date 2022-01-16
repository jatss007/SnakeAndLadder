public abstract class Game {

    abstract void init();
    abstract void makeMove(Move move);
    abstract void displayGame();
    protected abstract boolean hasWinner();
    protected abstract Player getCurrentPlayer();
    protected abstract String getName();
    protected abstract PlayerState getPlayerState(Player currentPlayer);
    protected abstract boolean stopGame();
    protected abstract void updatePlayer();

    void play(){
        System.out.println("Starting game + "+ getName());
        init();

        do {
            displayGame();
            Player currentPlayer = getCurrentPlayer();
            if(hasWinner() && !stopGame()) {
                System.out.println(getCurrentPlayer().getName() +": Already cleared ");
                updatePlayer();
                continue;
            }
            PlayerState playerState = getPlayerState(currentPlayer);
            Move move = currentPlayer.makeMove(playerState);
            makeMove(move);
            if(hasWinner())
                System.out.println(getCurrentPlayer().getName() +": wins the game \n Boom ");
        }
        while(!stopGame());
        System.out.println(getCurrentPlayer().getName() +": wins the game ");





    }


}
