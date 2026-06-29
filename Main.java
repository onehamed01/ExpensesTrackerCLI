import java.util.Scanner;
// The logic is one-to-many. Transaction's objects can implement by one Tracker to process the logic 

class Transaction{
    private double amount;
    Transaction(double amount){
        this.amount = amount;
    }

    double getAmount(){
        return this.amount;
    }
}
class Tracker{
    private double save;
    private double expenses;

    Tracker(){
        this.save = 0;
        this.expenses = 0;
    }
    void summery(){
        System.out.println("The Save amount: £"+this.save);
        System.out.println("The Expenses amount: £"+this.expenses);
    }
 // Process each Transaction object is it income or outcome. Each Tracker object has multiple Transaction. So it should save the last calculation for next Transaction's object
    void processor(Transaction transactionObject){
        double amount = transactionObject.getAmount();

        if (amount > 0){
            Scanner income = new Scanner(System.in);
            System.out.println("How much you would like to save with £"+ amount + ": ");
            double incomeInput = income.nextDouble();

            // Add new amount to the last save value 
            this.save += incomeInput;

            // deduce save from total amount to fetch expenses
            this.expenses += amount - incomeInput;
        }
        // Else the amount be expenses (negative amount)
        else{
            // check if the amount of expenses is bigger than the last amount of expenses 
            if (this.expenses < amount) {
                System.out.println("You don't have enought amount to pay!");
            }
            else if (this.expenses - amount == 0) {
                this.expenses = 0;
                System.out.println("you current expenses amount is 0. Please charge it!");
            }
            else{
                this.expenses += amount;
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
     Tracker tracker = new Tracker();
     
     // Income instance
     Transaction thisWeekIncome = new Transaction(280.00);
     Transaction thisWeekTip = new Transaction(35.00);
     Transaction liddleShopping = new Transaction(-80.00);
     tracker.processor(thisWeekIncome);
     tracker.processor(thisWeekTip);
     tracker.processor(liddleShopping);
     tracker.summery();
    }
}