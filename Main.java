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

    }
}