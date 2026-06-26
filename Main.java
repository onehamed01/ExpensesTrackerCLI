import java.util.Scanner;

class Transaction{
    private double amount;

    Transaction(double amount){
        this.amount = amount;
    }
    double getterAmount(){
        return this.amount;
    }
}
class Tracking{
    private double save;
    private double expenses;
    Transaction tObj;

    Tracking(Transaction tObj) {
        this.save = 0;
        this.expenses = 0;
        this.tObj = tObj;
    }
    void showing(){
        System.out.println("Current Save: £"+ this.save);
        System.out.println("Current Expenses: £"+ this.expenses);

    }
    // when the parameter of Transaction is plus, the spliteIcome just separate amount to the expenses and saving 
    private void spliteIncome(double saveAmount){
        double objAmount = tObj.getterAmount();

        this.save += saveAmount;
        this.expenses += objAmount - saveAmount;
        showing();
        
    }
    // check is it negative or positive amount and call each method dependes to the process 
    void process(){
        double currentAmount = tObj.getterAmount();

        if (currentAmount > 0){
            Scanner saveInput = new Scanner(System.in);

            System.out.println("How much you want save: ");
            double saveAmount = saveInput.nextDouble();

            spliteIncome(saveAmount);
        }
        else if (tObj.getterAmount() < 0) {
            currentAmount += this.expenses; 

            showing();
        } 
        else {
            System.out.println("Invalid amount!");
            showing();
        }
    }

}
class Main{
    public static void main(String[] args) {
        Transaction thisWeekIncome = new Transaction(350.00);
        Tracking thisWeekIncomeTracking = new Tracking(thisWeekIncome);
        thisWeekIncomeTracking.process();
    }
}