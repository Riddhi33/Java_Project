
/**
 * Write a description of class DebitCard here.
 *
 * @author (22067482 Riddhi Khanal)
 * @version (1.0.0)
 */
public class DebitCard extends BankCard
{
   //Assigning attributes
   private int pinNo;
   private int withdrawalAmount;
   private String dateofWithdrawal;
   private boolean hasWithdrawn;
   
   //Creating a constructor
   public DebitCard(double balanceAmount, int cardID, String bankAccount, String issuerBank, String clientName, int pinNo){
       super(balanceAmount, cardID,bankAccount,issuerBank); //Calling parameters of BankCard method
       super.setClientName(clientName); //Super is used for calling methods or field from parent class
       this.pinNo = pinNo;
       this.hasWithdrawn = false; 
   }
   
   //Creating accessor methods to return the value of private field.
   public int getPinNo(){
       return pinNo;
   }
   public int getWithdrawalAmount(){
       return withdrawalAmount;
   }
   public String getDateofWithdrawal(){
       return dateofWithdrawal;
   }
   public boolean getHasWithdrawn(){
       return hasWithdrawn;
   }
   //Creating mutator method
   public void setWithdrawalAmount(int withdrawalAmount){
   this.withdrawalAmount = withdrawalAmount;
   }
   
   public void Withdraw(int withdrawalAmount, String dateofWithdrawal, int pinNo){
     if(this.pinNo == pinNo){ //Checking if pinNumber passed as a parameter pinNumber equals pinNumber of current class
         if(withdrawalAmount <= super.getBalanceAmount()){ //Checking if withdrawalAmount is less than or equals to the getter method getBalanceAmount
             this.hasWithdrawn = true;
             super.setBalanceAmount(super.getBalanceAmount() - withdrawalAmount);
           this.withdrawalAmount = withdrawalAmount;
             this.dateofWithdrawal = dateofWithdrawal;
             System.out.println("You have successfully withdrawn the money. Your remaining balance is " +super.getBalanceAmount() );
         }
         else{
            System.out.println("You have insufficient balance");
         
         }
     }
     else{
        System.out.println("You have entered invalid pinNumber");
     }
    } 
    
   public void display(){
   //calling the display method of BankCard class
   super.display();
   System.out.println("Your PIN Number is: " +this.pinNo);
    
   if(hasWithdrawn == true){ //Checking if withdrawn process has been carried.
      System.out.println("Your withdrawal amount is: " + this.withdrawalAmount);
      System.out.println("Date of withdrawal: " + this.dateofWithdrawal);
   }
      else{
          System.out.println("No transaction has been carried out. Your balance: " +super.getBalanceAmount());
        }
   }
}
