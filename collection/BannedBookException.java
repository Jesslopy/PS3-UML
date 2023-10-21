/*
 * --Alexander Jessop--
 */

 public class BannedBookException extends Exception {
    public BannedBookException() {
        super("This book is banned.");
    }

    public BannedBookException(String message) {
        super(message);
    }
}
