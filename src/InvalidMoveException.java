public class InvalidMoveException extends Throwable {
    String s;
    public InvalidMoveException(String s) {
        this.s = s;
    }
}
