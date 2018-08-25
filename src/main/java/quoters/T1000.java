package quoters;

import annotations.PostProxy;

public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println(T1000.class.getName() + " says: I'm liquid");
    }
}
