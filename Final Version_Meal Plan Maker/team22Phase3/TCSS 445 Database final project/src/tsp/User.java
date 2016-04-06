package tsp;

public class User {
    String Account_Name, Account_PW, Account_CreateOn, Account_LastSignOn, Account_SbName, Account_SbAddress, Account_SbPhone, Account_SbEmail;

    public User(String Account_Name, String Account_PW, String Account_CreateOn, String Account_LastSignOn, String Account_SbName, String Account_SbAddress, String Account_SbPhone, String Account_SbEmail) {
            this.Account_Name = Account_Name;
            this.Account_PW = Account_PW;
            this.Account_CreateOn = Account_CreateOn;
            this.Account_LastSignOn = Account_LastSignOn;
            this.Account_SbName = Account_SbName;
            this.Account_SbAddress = Account_SbAddress;
            this.Account_SbPhone = Account_SbPhone;
            this.Account_SbEmail = Account_SbEmail;
    }
    
    public void setAccount_PW(String theAccount_PW) {
        this.Account_PW = theAccount_PW;
    }
    
    public void setAccountD_Name(String theDashboardName) {
        this.Account_SbName = theDashboardName;
    }
    
    public void setAccountD_Email(String theDashboardEmail) {
        this.Account_SbEmail = theDashboardEmail;
    }
    
    public void setAccountD_Phone(String theDashboardPhone) {
        this.Account_SbPhone = theDashboardPhone;
    }
    
    public void setAccount_Address(String theAccount_Address) {
        
    }
    
    public String getAccount_Name() {
            return this.Account_Name;
    }
    public String getAccount_PW() {
            return this.Account_PW;
    }
    public String getAccount_CreateOn() {
            return this.Account_CreateOn;
    }
    public String getAccount_LastSignOn() {
            return this.Account_LastSignOn;
    }
    public String getAccount_SbName() {
            return this.Account_SbName;
    }
    public String getAccount_SbAddress() {
            return this.Account_SbAddress;
    }
    public String getAccount_SbPhone() {
            return this.Account_SbPhone;
    }
    public String getAccount_SbEmail() {
            return this.Account_SbEmail;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Account Name : " + getAccount_Name() + "\n"
        + "Account created on : " +  getAccount_CreateOn() + "\n"
        + "Account last signed on : " +  getAccount_LastSignOn() + "\n"
        + "Account Dashboard Name :" + getAccount_SbName() + "\n"
        + "Account address :" + getAccount_SbAddress() + "\n"
        + "Account Phone number  :" + getAccount_SbPhone() + "\n"
        + "Account email :" + getAccount_SbEmail() + "\n");
        
        return sb.toString();
    }
}   
