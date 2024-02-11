
/**
 * Write a description of class BankGUI here.
 *
 * @author (22067482_Riddhi_Khanal)
 * @version (a version number or a date)
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BankGUI implements ActionListener
{
    //Declaring all the components here
    private JFrame frame;

    //Common components
    private JLabel clientNameLabel, issuerBankLabel, cardIDLabel, bankAccountLabel,balanceAmountLabel;
    private JTextField clientNameText, issuerBankText, cardIDText, bankAccountText, balanceAmountText;
    private JButton clearButton;

    //Debitcard components
    private JLabel pinNoLabel, dcardIDLabel, withdrawalAmountLabel, dateofWithdrawalLabel;
    private JTextField pinNoText, dcardIDText, withdrawalAmountText;
    private JButton daddButton, withdrawButton, ddisplayButton;

    private JComboBox wdaysCombo, wmonthsCombo, wyearsCombo; 
    //Creditcard components
    private JLabel cvcNoLabel, interestRateLabel, expirationDateLabel, ccardIDLabel, newcreditLimitLabel, newgracePeriodLabel ;
    private JTextField cvcNoText, interestRateText, ccardIDText, newcreditLimitText, newgracePeriodText;
    private JButton caddButton, cancelButton, setButton, cdisplayButton;

    private JComboBox edaysCombo, emonthsCombo, eyearsCombo;

    //ArrayList of BankCard
    ArrayList<BankCard> cardLists = new ArrayList<BankCard>();

    public BankGUI(){
        //Creating the code to write the GUI
        //Creating GUI for debitcard and creditcard

        frame = new JFrame();

        JLabel titleLabel = new JLabel("Bank Details");
        titleLabel.setBounds(401, 20, 150, 50);
        /** SETTING FONT SIZE FOR TITLE */
        Font font = new Font("Arial", Font.BOLD, 20);
        titleLabel.setFont(font);
        frame.add(titleLabel);

        /**COMMON PART*/

        clientNameLabel = new JLabel("Client Name:");
        clientNameText = new JTextField();
        clientNameLabel.setBounds(252, 89, 81, 20);
        clientNameText.setBounds(388, 83, 243, 32);
        frame.add(clientNameLabel);
        frame.add(clientNameText);

        issuerBankLabel = new JLabel("Issuer Bank:");
        issuerBankText = new JTextField();
        issuerBankLabel.setBounds(252, 145, 78, 20);
        issuerBankText.setBounds(388, 139, 243, 32);
        frame.add(issuerBankLabel);
        frame.add(issuerBankText);

        cardIDLabel = new JLabel("Card ID:");
        cardIDText = new JTextField();
        cardIDLabel.setBounds(252, 201, 50, 20);
        cardIDText.setBounds(388, 195, 243, 32);
        frame.add(cardIDLabel);
        frame.add(cardIDText);

        bankAccountLabel = new JLabel("Bank Account:");
        bankAccountText = new JTextField();
        bankAccountLabel.setBounds(249, 257, 93, 20);
        bankAccountText.setBounds(388, 251, 243, 32);
        frame.add(bankAccountLabel);
        frame.add(bankAccountText);

        balanceAmountLabel = new JLabel("Balance Amount:");
        balanceAmountText = new JTextField();
        balanceAmountLabel.setBounds(252, 313, 106, 20);
        balanceAmountText.setBounds(388, 307, 243, 32);
        frame.add(balanceAmountLabel);
        frame.add(balanceAmountText);

        /**DEBIT CARD DETAILS*/

        JLabel dformLabel = new JLabel("For Debit Card"); 
        dformLabel.setBounds(159, 365, 150, 50);
        Font dfont = new Font("Arial", Font.BOLD, 18);
        dformLabel.setFont(dfont);
        frame.add(dformLabel);

        pinNoLabel = new JLabel("PIN Number:");
        pinNoText = new JTextField();
        pinNoLabel.setBounds(34, 439, 81, 20);
        pinNoText.setBounds(175, 431, 243, 32);
        frame.add(pinNoLabel);
        frame.add(pinNoText);

        daddButton = new JButton("Add");
        daddButton.setBounds(298, 491, 120, 32);
        frame.add(daddButton);
        daddButton.addActionListener(this);

        dcardIDLabel = new JLabel("Card ID:");
        dcardIDText = new JTextField();
        dcardIDLabel.setBounds(34, 559, 50, 20);
        dcardIDText.setBounds(179, 555, 243, 32);
        frame.add(dcardIDLabel);
        frame.add(dcardIDText);

        withdrawalAmountLabel = new JLabel("Withdrawal Amount:");
        withdrawalAmountText = new JTextField();
        withdrawalAmountLabel.setBounds(34, 619, 125, 20);
        withdrawalAmountText.setBounds(179, 613, 243, 32);
        frame.add(withdrawalAmountLabel);
        frame.add(withdrawalAmountText);

        dateofWithdrawalLabel = new JLabel("Withdrawal Date");
        dateofWithdrawalLabel.setBounds(34, 679, 107, 20);
        frame.add(dateofWithdrawalLabel);

        String[] wdays = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        wdaysCombo = new JComboBox(wdays);
        wdaysCombo.setBounds(180, 671, 77, 32);
        frame.add(wdaysCombo);

        String[] wmonths = {"January", "February", "March", "April", "May", "June", "July","August","September", "October","November","December"};
        wmonthsCombo = new JComboBox(wmonths);
        wmonthsCombo.setBounds(262, 671, 80, 32);
        frame.add(wmonthsCombo);

        String[] wyears = {"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
        wyearsCombo = new JComboBox(wyears);
        wyearsCombo.setBounds(347, 671, 81, 32);
        frame.add(wyearsCombo);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(171, 737, 120, 32);
        frame.add(withdrawButton);
        withdrawButton.addActionListener(this);

        ddisplayButton = new JButton("Display");
        ddisplayButton.setBounds(308, 737, 120, 32);
        frame.add(ddisplayButton);
        ddisplayButton.addActionListener(this);

        /**CREDIT CARD DETAILS*/

        JLabel CformLabel = new JLabel("For Credit Card"); 
        CformLabel.setBounds(618, 365, 150, 50);
        Font cfont = new Font("Arial", Font.BOLD, 18);
        CformLabel.setFont(cfont);
        frame.add(CformLabel);

        cvcNoLabel = new JLabel("CVC Number:");
        cvcNoText = new JTextField();
        cvcNoLabel.setBounds(484, 433, 87, 26);
        cvcNoText.setBounds(626, 431, 243, 32);
        frame.add(cvcNoLabel);
        frame.add(cvcNoText);

        interestRateLabel = new JLabel("Interest Rate:");
        interestRateText = new JTextField();
        interestRateLabel.setBounds(484, 497, 84, 20);
        interestRateText.setBounds(626, 491, 243, 32);
        frame.add(interestRateLabel);
        frame.add(interestRateText);

        expirationDateLabel = new JLabel("Expiration Date");
        expirationDateLabel.setBounds(484, 555, 100, 20);
        frame.add(expirationDateLabel);

        String[] edays = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        edaysCombo = new JComboBox(edays);
        edaysCombo.setBounds(626, 551, 77, 32);
        frame.add(edaysCombo);

        String[] emonths = {"January", "February", "March", "April", "May", "June", "July","August","September", "October","November","December"};
        emonthsCombo = new JComboBox(emonths);
        emonthsCombo.setBounds(709, 551, 77, 32);
        frame.add(emonthsCombo);

        String[] eyears = {"2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035"};
        eyearsCombo = new JComboBox(eyears);
        eyearsCombo.setBounds(792, 551, 77, 32);
        frame.add(eyearsCombo);

        caddButton = new JButton("Add");
        caddButton.setBounds(749, 611, 120, 32);
        frame.add(caddButton);
        caddButton.addActionListener(this);

        ccardIDLabel = new JLabel("Card ID:");
        ccardIDText = new JTextField();
        ccardIDLabel.setBounds(484, 677, 50, 20);
        ccardIDText.setBounds(626, 671, 243, 32);
        frame.add(ccardIDLabel);
        frame.add(ccardIDText);

        newcreditLimitLabel = new JLabel("Credit Limit:");
        newcreditLimitText = new JTextField();
        newcreditLimitLabel.setBounds(484, 737, 75, 20);
        newcreditLimitText.setBounds(626, 731, 243, 32);
        frame.add(newcreditLimitLabel);
        frame.add(newcreditLimitText);

        newgracePeriodLabel = new JLabel("Grace Period:");
        newgracePeriodText = new JTextField();
        newgracePeriodLabel.setBounds(484, 797, 86, 26);
        newgracePeriodText.setBounds(626, 791, 243, 32);
        frame.add(newgracePeriodLabel);
        frame.add(newgracePeriodText);

        setButton = new JButton("Set");
        setButton.setBounds(610, 851, 120, 32);
        frame.add(setButton);
        setButton.addActionListener(this);

        cdisplayButton = new JButton("Display");
        cdisplayButton.setBounds(743, 851, 120, 32);
        frame.add(cdisplayButton);
        cdisplayButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(679, 898, 120, 32);
        cancelButton.setBackground(new Color(255, 125, 134));
        frame.add(cancelButton);
        cancelButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setBounds(34, 898, 120, 32);
        clearButton.setBackground(new Color(239, 242, 138));
        frame.add(clearButton);
        clearButton.addActionListener(this);

        frame.setSize(920, 1000);
        frame.getContentPane().setBackground(new Color(228,247,247));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }
    //Main method
    public static void main(String[] args) {
        BankGUI obj = new BankGUI();
    }
    //Implementing the method of the ActionListener
    public void actionPerformed(ActionEvent e){

        /** Functionality for ADD Button of DEBITCARD*/
        if (e.getSource() == daddButton){

            if(clientNameText.getText().isEmpty() || issuerBankText.getText().isEmpty() ||cardIDText.getText().isEmpty() || bankAccountText.getText().isEmpty() || balanceAmountText.getText().isEmpty() || pinNoText.getText().isEmpty() ){
                JOptionPane.showMessageDialog(frame, "Please don't leave any textfield empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    //Retrieving input values from text field
                    String clientName = clientNameText.getText();
                    String issuerBank = issuerBankText.getText();
                    int cardID = Integer.parseInt(cardIDText.getText());
                    String bankAccount = bankAccountText.getText();
                    double balanceAmount = Double.parseDouble(balanceAmountText.getText());
                    int pinNo = Integer.parseInt(pinNoText.getText());
                    boolean forAdd = true;
                    DebitCard dcard;

                    if(cardLists.isEmpty()){
                        //Creating Object of DebitCard
                        dcard = new DebitCard(balanceAmount,  cardID,  bankAccount,  issuerBank,  clientName,  pinNo);

                        //Adding new Debit card object to an arrayList
                        cardLists.add(dcard);
                        JOptionPane.showMessageDialog(frame, "DebitCard is added succesfully", "Alert", JOptionPane.INFORMATION_MESSAGE);

                    }
                    else{
                        for(BankCard card:cardLists){
                            if(card instanceof DebitCard){
                                dcard = (DebitCard) card;
                                if(dcard.getCardID()==cardID){
                                    JOptionPane.showMessageDialog(frame, "DebitCard cannot be added", "Input error", JOptionPane.ERROR_MESSAGE);
                                    forAdd = false;
                                    break;
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "DebitCard cannot be added", "Input error", JOptionPane.ERROR_MESSAGE);
                                forAdd = false;
                                break;
                            }
                        }
                        if (forAdd == true){
                            dcard = new DebitCard(balanceAmount,  cardID,  bankAccount,  issuerBank,  clientName,  pinNo);
                            cardLists.add(dcard);
                            JOptionPane.showMessageDialog(frame, "DebitCard is added succesfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid Format", "Input error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        /** Functionality for WITHDRAW Button of DEBITCARD*/
        if (e.getSource() == withdrawButton){
            if(pinNoText.getText().isEmpty()|| dcardIDText.getText().isEmpty()||withdrawalAmountText.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please don't leave any textfield empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    int pinNo = Integer.parseInt(pinNoText.getText());
                    int dcardID = Integer.parseInt(dcardIDText.getText());
                    int withdrawalAmount = Integer.parseInt(withdrawalAmountText.getText());
                    String wdays = (String) wdaysCombo.getSelectedItem();  
                    String wmonths = (String) wmonthsCombo.getSelectedItem();
                    String wyears = (String) wyearsCombo.getSelectedItem();
                    String dateofWithdrawal = wdays + " " + wmonths + " " + wyears;
                    boolean possible_card = false;
                    if(cardLists.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "Debit Card has not been added", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //If debit card is already present
                        //Loop through the array list
                        for(BankCard card:cardLists){
                            //Is the card debit card or not?
                            if(card instanceof DebitCard){
                                //Downcast
                                DebitCard dcard = (DebitCard) card;
                                if(dcard.getCardID()==dcardID && dcard.getPinNo()==pinNo){
                                    double originalAmount = dcard.getBalanceAmount();
                                    dcard.Withdraw(withdrawalAmount, dateofWithdrawal, pinNo);
                                    double remainingAmount = (originalAmount - withdrawalAmount);
                                    if (withdrawalAmount > 0){
                                        if( withdrawalAmount<= originalAmount ){
                                            String pop1 = "Amount has been successfully withdrawned. \n Your remaining balance is: " + remainingAmount + "\n PIN Number: " + pinNo + " \n Card ID: " + dcardID + "\n Withdrawal Amount: " + withdrawalAmount + "\n Date of withdrawal: " + dateofWithdrawal;
                                            JOptionPane.showMessageDialog(frame, pop1 , "Alert", JOptionPane.INFORMATION_MESSAGE); 
                                        }  

                                        else{
                                            JOptionPane.showMessageDialog(frame,"Insufficient Balance", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }

                                    else{
                                        JOptionPane.showMessageDialog(frame, "Please input valid number", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    possible_card = true;
                                    break;
                                }
                            }
                        }
                        if(!possible_card){
                            JOptionPane.showMessageDialog(frame, "Please enter your Card ID or PIN number correctly", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid Format", "Input error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        /** DISPLAY BUTTON OF DEBIT CARD */
        if (e.getSource() == ddisplayButton){

            //Retrieving input values from text field

            String wdays = (String) wdaysCombo.getSelectedItem();   
            String wmonths = (String) wmonthsCombo.getSelectedItem();
            String wyears = (String) wyearsCombo.getSelectedItem();
            String dateofWithdrawal = wdays + " " + wmonths + " " + wyears;

            if(cardLists.isEmpty()){
                JOptionPane.showMessageDialog(frame, "No data to display", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                //If debit card is already present
                //Loop through the array list
                for(BankCard card:cardLists){
                    //Is the card debit card or not?
                    if(card instanceof DebitCard){
                        //Downcast
                        DebitCard dcard = (DebitCard) card;
                        //Calling display method from debit card class
                        dcard.display();
                        String pop = "Client Name: " + clientNameText.getText() + "\n Issuer Bank: " + issuerBankText.getText() + "\n Card ID: " + cardIDText.getText() + "\n Bank Account: " + bankAccountText.getText() + "\n Original Amount: " + balanceAmountText.getText() + "\n PIN Number: " + pinNoText.getText()  + "\n Withdrawal Amount: " + withdrawalAmountText.getText() + "\n Date of withdrawal: " + dateofWithdrawal;
                        JOptionPane.showMessageDialog(frame, pop, "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "DebitCard not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        /** ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
        /** Functionality for ADD Button of CREDITCARD*/
        if (e.getSource() == caddButton){
            if(clientNameText.getText().isEmpty() || issuerBankText.getText().isEmpty() ||cardIDText.getText().isEmpty() || bankAccountText.getText().isEmpty() || balanceAmountText.getText().isEmpty() || cvcNoText.getText().isEmpty()|| interestRateText.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please don't leave any textfield empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    String clientName = clientNameText.getText();
                    String issuerBank = issuerBankText.getText();
                    int cardID = Integer.parseInt(cardIDText.getText());
                    String bankAccount = bankAccountText.getText();
                    double balanceAmount = Double.parseDouble(balanceAmountText.getText());
                    int cvcNo = Integer.parseInt(cvcNoText.getText());
                    double interestRate = Double.parseDouble(interestRateText.getText());
                    String edays = (String) edaysCombo.getSelectedItem();
                    String emonths = (String) emonthsCombo.getSelectedItem();
                    String eyears = (String) eyearsCombo.getSelectedItem();
                    String expirationDate = edays + " " + emonths + " " + eyears;
                    boolean forAdd = true;
                    CreditCard ccard;

                    if(cardLists.isEmpty()){
                        //Creating an object for credit card
                        ccard = new CreditCard(balanceAmount, cardID, bankAccount, issuerBank,  clientName,  cvcNo,  interestRate,  expirationDate);
                        //Adding new Credit card object to an arrayList
                        cardLists.add(ccard);
                        JOptionPane.showMessageDialog(frame, "CreditCard is added succesfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        for(BankCard card:cardLists){
                            if(card instanceof CreditCard){
                                ccard = (CreditCard) card;
                                if(ccard.getCardID()==cardID){
                                    JOptionPane.showMessageDialog(frame, "CreditCard cannot be added", "Input error", JOptionPane.ERROR_MESSAGE);
                                    forAdd = false;
                                    break;
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "CreditCard not found", "Input error", JOptionPane.ERROR_MESSAGE);
                                forAdd = false;
                                break;
                            }
                        }
                        if(forAdd == true){
                            ccard = new CreditCard(balanceAmount, cardID, bankAccount, issuerBank,  clientName,  cvcNo,  interestRate,  expirationDate);
                            cardLists.add(ccard);
                            JOptionPane.showMessageDialog(frame, "CreditCard is added succesfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid Format", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }    
        }

        /** Functionality for SET Button of CREDITCARD*/
        if (e.getSource() == setButton){
            
                try{
                    int ccardID = Integer.parseInt(ccardIDText.getText());
                    double newcreditLimit = Double.parseDouble(newcreditLimitText.getText());
                    int newgracePeriod = Integer.parseInt(newgracePeriodText.getText());
                    boolean possible_card = false;
                    if(cardLists.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "Credit Card has not been added", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //If credit card is already present
                        //Loop through the array list
                        for(BankCard card:cardLists){
                            //Is the card debit card or not?
                            if(card instanceof CreditCard){
                                //Downcast
                                CreditCard ccard = (CreditCard) card;
                                if(ccard.getCardID()==ccardID){
                                    possible_card = true;
                                    ccard.setCreditLimit( newcreditLimit, newgracePeriod);
                                    if(newcreditLimit<=2.5*ccard.getBalanceAmount()){
                                        JOptionPane.showMessageDialog(frame, "Credit Limit has been set successfully." + "\n New Credit Limit: " + newcreditLimit + "\n New Grace Period: " + newgracePeriod, "Alert", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(frame, "Credit cannot be granted ", "Error", JOptionPane.ERROR_MESSAGE);

                                    }
                                    break;
                                }
                            }
                        }
                        if (!possible_card){
                            JOptionPane.showMessageDialog(frame, "Card not found", "Error", JOptionPane.ERROR_MESSAGE); 
                        }
                        }
                    }
                    catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid Format", "Input error", JOptionPane.ERROR_MESSAGE);
                }
            }
        

        /** DISPLAY BUTTON OF CREDIT CARD*/
        if (e.getSource() == cdisplayButton){

            //Retrieving input values from text field
            String edays = (String) edaysCombo.getSelectedItem();
            String emonths = (String) emonthsCombo.getSelectedItem();
            String eyears = (String) eyearsCombo.getSelectedItem();
            String expirationDate = edays + " " + emonths + " " + eyears;

            if(cardLists.isEmpty()){
                JOptionPane.showMessageDialog(frame, "No data to display", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                //If credit card is already present
                //Loop through the array list
                for(BankCard card:cardLists){
                    //Is the card debit card or not?
                    if(card instanceof CreditCard){
                        //Downcast
                        CreditCard ccard = (CreditCard) card;
                        //Calling display method from debit card class
                        ccard.display();
                        String pop3 = "Client Name: " + clientNameText.getText() + "\n Issuer Bank: " + issuerBankText.getText() + "\n Card ID: " + cardIDText.getText() + "\n Bank Account: " + bankAccountText.getText() + "\n Original Amount: " + balanceAmountText.getText() + "\n CVC Number: " + cvcNoText.getText()  + "\n Interest Rate: " + interestRateText.getText() + "\n New Credit Limit: " + newcreditLimitText.getText() + "\n New Grace Period: " + newgracePeriodText.getText()  + "\n Expiration Date: " + expirationDate;
                        JOptionPane.showMessageDialog(frame, pop3, "Info", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "DebitCard not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        /** Functionality for CANCEL Button of CreditCard*/
        if (e.getSource() == cancelButton){
            try{
                int ccardID = Integer.parseInt(ccardIDText.getText());
                double newcreditLimit = Double.parseDouble(newcreditLimitText.getText());
                int newgracePeriod = Integer.parseInt(newgracePeriodText.getText()); 
                if(cardLists.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Card has not been added", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //If credit card is already present
                    //Loop through the array list
                    for(BankCard card:cardLists){
                        //Is the card debit card or not?
                        if(card instanceof CreditCard){
                            //Downcast
                            CreditCard ccard = (CreditCard) card;
                            if(ccard.getCardID()==ccardID){
                                ccard.cancelCreditCard();
                                ccardIDText.setText("");
                                newcreditLimitText.setText("");
                                newgracePeriodText.setText("");

                                JOptionPane.showMessageDialog(frame, "Credit Card has been cancelled successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "Please input your Card Id correctly", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(frame, "CreditCard not found", "Error", JOptionPane.ERROR_MESSAGE); 
                        }
                    }
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Invalid Format", "Input error", JOptionPane.ERROR_MESSAGE);
            }
        }

        /**-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
        /** Functionality for CLEAR Button*/
        if (e.getSource() == clearButton){
            clientNameText.setText("");
            issuerBankText.setText("");
            cardIDText.setText("");
            bankAccountText.setText("");
            balanceAmountText.setText("");
            pinNoText.setText("");
            dcardIDText.setText("");
            withdrawalAmountText.setText("");
            cvcNoText.setText("");
            interestRateText.setText("");
            ccardIDText.setText("");
            newcreditLimitText.setText("");
            newgracePeriodText.setText("");
        }    
    }
}

