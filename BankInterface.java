package javaapplication71;
// Step 1: Define ADT (Interface)
interface BankService {
    void performService();
}
// Step 2: Implement Concrete Classes

// Class for Receiving Bill Payments
class BillPaymentService implements BankService {
    @Override
    public void performService() {
        System.out.println("Processing bill payment...");
    }
}

// Class for Opening New Accounts
class AccountOpeningService implements BankService {
    @Override
    public void performService() {
        System.out.println("Opening a new account...");
    }
}

// Class for Contacting Loan Takers
class LoanContactService implements BankService {
    @Override
    public void performService() {
        System.out.println("Contacting loan taker about expired limits...");
    }
}

// Step 3: Main class to test the scenario
public class BankInterface {
    public static void main(String[] args) {
        BankService billPayment = new BillPaymentService();
        BankService accountOpening = new AccountOpeningService();
        BankService loanContact = new LoanContactService();
        
        billPayment.performService();
        accountOpening.performService();
        loanContact.performService();
    }
}
