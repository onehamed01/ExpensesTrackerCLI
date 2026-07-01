import java.util.ArrayList;
import java.util.Scanner;
// The logic is one-to-many. Transaction's objects can implement by one Tracker to process the logic

class Transaction {
    private double amount;
    private String category;

    Transaction(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    double getAmount() {
        return this.amount;
    }
    String getCategory(){
        return this.category;
    }
}

class Tracker {
    private double save;
    private double expenses;
    private ArrayList<Transaction> transactionDB;


    Tracker() {
        this.save = 0;
        this.expenses = 0;
        this.transactionDB = new ArrayList<Transaction>();
    }

    void currentBalance() {
        System.out.println("The Save amount: £" + this.save);
        System.out.println("The Expenses amount: £" + this.expenses);
    }

    // Process each Transaction object is it income or outcome. Each Tracker object has multiple Transaction. So it should save the last calculation for next Transaction's object
    void processor(Transaction transactionObject) {
        double amount = transactionObject.getAmount();

        // save each transaction in  Array List
        transactionDB.add(transactionObject);

        if (amount > 0) {
            Scanner income = new Scanner(System.in);
            System.out.println(
                "How much you would like to save with £" + amount + ": "
            );
            double incomeInput = income.nextDouble();

            // Add new amount to the last save value
            this.save += incomeInput;

            // deduce save from total amount to fetch expenses
            this.expenses += amount - incomeInput;
        }
        // Else the amount be expenses (negative amount)
        else {
            double positiveAmount = Math.abs(amount);
            // check if the amount of expenses is bigger than the last amount of expenses
            if (this.expenses < positiveAmount) {
                System.out.println("You don't have enought amount to pay!");
            } else if (this.expenses - positiveAmount == 0) {
                this.expenses = 0;
                System.out.println(
                    "you current expenses amount is 0. Please charge it!"
                );
            } else {
                this.expenses += amount;
            }
        }

    }
    void searchByCategory(String categoryName){
        for (Transaction cat: transactionDB){
            String categoryNameObject;
            categoryNameObject = cat.getCategory().toLowerCase();
 // maybe the arguments is camel case. avoiding error make them lowercase
            if(categoryNameObject.equals(categoryName.toLowerCase())){
                System.out.println(categoryName);
                System.out.println(cat.getAmount());
            }
        }
    } 
    void searchByExpenses(){
        for(Transaction ex: transactionDB){
            if (ex.getAmount() < 0){
                System.out.println(ex.getAmount());
            }
        }
    }
    void searchByIncome(){
        for(Transaction ex: transactionDB){
            if (ex.getAmount() > 0){
                System.out.println(ex.getAmount());
            }
        }
    }
}

class Main {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();

        Transaction augustIncome = new Transaction(920.00, "Income");
        tracker.processor(augustIncome);

        Transaction freelancePayment = new Transaction(180.00, "Income");
        tracker.processor(freelancePayment);

        Transaction birthdayGift = new Transaction(50.00, "Income");
        tracker.processor(birthdayGift);
        
        Transaction tescoShopping = new Transaction(-42.80, "Shopping");
        tracker.processor(tescoShopping);

        Transaction asdaShopping = new Transaction(-27.45, "Shopping");
        tracker.processor(asdaShopping);

        Transaction aldiShopping = new Transaction(-19.90, "Shopping");
        tracker.processor(aldiShopping);
        
        Transaction gymMembership = new Transaction(-29.99, "Gym");
        tracker.processor(gymMembership);

        Transaction proteinPowder = new Transaction(-34.50, "Gym");
        tracker.processor(proteinPowder);
        
        Transaction busTicket = new Transaction(-2.50, "Transport");
        tracker.processor(busTicket);

        Transaction trainTicket = new Transaction(-18.60, "Transport");
        tracker.processor(trainTicket);

        Transaction fuel = new Transaction(-55.00, "Transport");
        tracker.processor(fuel);



        // testing
        tracker.searchByCategory("Transport");
    }
}
