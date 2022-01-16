import java.util.List;

public interface Player {
    public String getName();
    Move makeMove(PlayerState playerState);
    public List<Move> lastNMoves(int n);
    public List<Move> getAllMoves();
}
