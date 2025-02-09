https://chatgpt.com/c/6759fbdb-1acc-8007-9c5a-e7d5868d3149

1- facotry pattern 

// Factory Class
class InterestStrategyFactory {
    public static InterestStrategy getStrategy(String bankName) {
        switch (bankName.toLowerCase()) {
            case "sbi":
                return new SBIBank();
            case "bob":
                return new BOBBank();
            case "idfc":
                return new IDFCBank();
            default:
                throw new IllegalArgumentException("Unknown bank: " + bankName);
        }
    }
}

enum based facotry 

import java.util.function.Supplier;

enum BankStrategy {
    SBI("SBI", SBIBank::new),
    BOB("BOB", BOBBank::new),
    IDFC("IDFC", IDFCBank::new);

    private final String bankName;
    private final Supplier<InterestStrategy> strategySupplier;

    BankStrategy(String bankName, Supplier<InterestStrategy> strategySupplier) {
        this.bankName = bankName;
        this.strategySupplier = strategySupplier;
    }

    public InterestStrategy getStrategy() {
        return strategySupplier.get();
    }
}

// Usage
InterestStrategy strategy = BankStrategy.valueOf("SBI").getStrategy();
BankAccount account = new BankAccount(strategy);



2- strategy pattern 

interface InterestStrategy {
    double calculateInterest(double amount);
}

class SBIBank implements InterestStrategy {
    public double calculateInterest(double amount) {
        return amount * 0.06; // SBI interest rate
    }
}

class BOBBank implements InterestStrategy {
    public double calculateInterest(double amount) {
        return amount * 0.07; // BOB interest rate
    }
}

class BankAccount {
    private InterestStrategy interestStrategy;

    public BankAccount(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public double getInterest(double amount) {
        return interestStrategy.calculateInterest(amount);
    }
}

BankAccount sbiAccount = new BankAccount(new SBIBank());
System.out.println(sbiAccount.getInterest(1000)); // SBI interest calculation

BankAccount bobAccount = new BankAccount(new BOBBank());
System.out.println(bobAccount.getInterest(1000)); // BOB interest calculation



3-> MIX of strategy and factory 

// Strategy Interface
interface InterestStrategy {
    double calculateInterest(double amount);
}

// Concrete Strategy Classes
class SBIBank implements InterestStrategy {
    public double calculateInterest(double amount) {
        return amount * 0.06; // SBI rate
    }
}

class BOBBank implements InterestStrategy {
    public double calculateInterest(double amount) {
        return amount * 0.07; // BOB rate
    }
}

class IDFCBank implements InterestStrategy {
    public double calculateInterest(double amount) {
        return amount * 0.08; // IDFC rate
    }
}

// Factory Class
class InterestStrategyFactory {
    public static InterestStrategy getStrategy(String bankName) {
        switch (bankName.toLowerCase()) {
            case "sbi":
                return new SBIBank();
            case "bob":
                return new BOBBank();
            case "idfc":
                return new IDFCBank();
            default:
                throw new IllegalArgumentException("Unknown bank: " + bankName);
        }
    }
}

// Context Class
class BankAccount {
    private InterestStrategy interestStrategy;

    public BankAccount(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public double getInterest(double amount) {
        return interestStrategy.calculateInterest(amount);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Using Factory to create Strategy
        InterestStrategy strategy = InterestStrategyFactory.getStrategy("SBI");
        BankAccount account = new BankAccount(strategy);
        System.out.println("SBI Interest: " + account.getInterest(1000));

        strategy = InterestStrategyFactory.getStrategy("BOB");
        account = new BankAccount(strategy);
        System.out.println("BOB Interest: " + account.getInterest(1000));
    }
}


4- singleton -> manage single instance in whole application and prevent creating other ones 

class Logger {
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {}

    // Public method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        // Access the logger instance
        Logger logger = Logger.getInstance();

        // Log messages
        logger.log("Application started");
        logger.log("An error occurred");

        // Ensure the same instance is used everywhere
        Logger anotherLogger = Logger.getInstance();
        System.out.println(logger == anotherLogger); // true
    }
}


4- observer pattern

5- builder pattern 

