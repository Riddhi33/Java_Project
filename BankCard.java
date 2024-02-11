
/**
 * Write a description of class BankCard here.
 *
 * @author (22067482 Riddhi Khanal)
 * @version (1.0.0)
 */
public class BankCard
{    //declaring attributes
     private int cardID;
     private String clientName;
     private String issuerBank;
     private String bankAccount;
     private double balanceAmount;
     
     public BankCard (double balanceAmount, int cardID, String bankAccount, String issuerBank){
         this.clientName = "";  //setting clientName as empty string
         this.balanceAmount = balanceAmount;
         this.cardID = cardID;
         this.bankAccount = bankAccount;
         this.issuerBank = issuerBank;
     }
     public int getCardID(){
          return cardID ;
     }
     public String getClientName(){
          return clientName;
     }
     public void setClientName(String clientName){
         this.clientName = clientName;
     }
     public double getBalanceAmount(){
         return balanceAmount;
     }
     public void setBalanceAmount(double balanceAmount){
         this.balanceAmount = balanceAmount;
     }
     public void display(){
         System.out.println("Card ID:" +this.cardID);
         System.out.println("Issuer Bank:" +this.issuerBank);
         System.out.println("Bank Account:" +this.bankAccount);
         System.out.println("Balance Amount:" +this.balanceAmount);
         if (clientName ==  "") {   //verifying if clientName is empty then display error message
            System.out.println("Client Name must not be empty!!!");
         }
         else{
            System.out.println("Client Name:" +this.clientName);
         }
     }
}
