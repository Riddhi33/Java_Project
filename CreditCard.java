
/**
 * Write a description of class CreditCard here.
 *
 * @author (22067482 Riddhi Khanal)
 * @version (1.0.0)
 */
public class CreditCard extends BankCard
{
   //Assigning attributes
   private int cvcNumber;
   private double creditLimit;
   private double interestRate;
   private String expirationDate;
   private int gracePeriod;
   private boolean isGranted;
   
   //Creating a constructor
   public CreditCard (double balanceAmount, int cardID, String bankAccount,String issuerBank, String clientName, int cvcNumber, double interestRate, String expirationDate){
    super(balanceAmount, cardID,bankAccount, issuerBank);
    super.setClientName(clientName);
    this.cvcNumber = cvcNumber;
    this.interestRate = interestRate;
    this.expirationDate = expirationDate;
    this.isGranted = false;
   }
   //Creating accessor method
   public int getCVCNumber(){
       return cvcNumber;
   }
   public double getCreditLimit(){
       return creditLimit;
   }
   public double getInterestRate(){
       return interestRate;
   }
   public String getExpirationDate(){
       return expirationDate;
   }
   public int getGracePeriod(){
       return gracePeriod; 
   }
   public boolean getIsGranted(){
       return isGranted;
   }
   
   
   public void setCreditLimit(double newcreditLimit,int newgracePeriod){
     if (newcreditLimit<=(2.5 * super.getBalanceAmount())){   //Checking if newcreditLimit is less than or equal to 2.5 times the BalanceAmount of parent class 
       this.creditLimit = newcreditLimit;
       this.gracePeriod = newgracePeriod;
       this.isGranted = true;
       System.out.println("The credit granted is:"+newcreditLimit); 
      }  
     else{
       System.out.println("The credit is not granted");
     }  
   }

  
   public void cancelCreditCard(){
      this.cvcNumber = 0;
      this.creditLimit = 0;
      this.gracePeriod = 0;
      this.isGranted = false;
   }
   
   public void display(){
      super.display();
      if(isGranted == true){  
        System.out.println("Credit Limit: "+this.creditLimit);
        System.out.println("Grace period: "+this.gracePeriod);
        System.out.println("Expiration date: "+this.expirationDate);  
        System.out.println("Interest Rate: " + this.interestRate);
        System.out.println("CVCNumber: " + this.cvcNumber);
      } 
      else{
        System.out.println("Credit is not granted so Credit Limit and Grace period cannot be displayed");
      }
   }
}
