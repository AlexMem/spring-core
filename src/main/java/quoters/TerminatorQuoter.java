package quoters;

import annotations.DeprecatedClass;
import annotations.InjectRandomInt;
import annotations.PostProxy;
import annotations.Profiling;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    @PostConstruct
    public void init() {
        System.out.print("Phase 2");
        System.out.println(": repeat = " + repeat);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3: ");
        for (int i = 0; i < repeat; i++) {
            System.out.println(TerminatorQuoter.class.getName() + " says: " + message);
        }
    }
}
