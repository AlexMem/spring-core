package quoters;

public class TerminatorQuoter implements Quoter {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println(TerminatorQuoter.class.toString() + " says: " + message);
    }
}
