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

    void process(){
        double currentAmount = tObj.getterAmount();

        if (currentAmount > 0){
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