package app;

public class Customer {


    private int custId;
    private String custEmail ,custpass;

    private boolean isadmin;

    public Customer(int custId, String custEmail, String custpass, boolean isadmin) {
        this.custId = custId;
        this.custEmail = custEmail;
        this.custpass = custpass;
        this.isadmin = isadmin;
    }


    public Customer(String email, String pwd, Boolean isadmin) {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custEmail='" + custEmail + '\'' +
                ", custpass='" + custpass + '\'' +
                ", isadmin=" + isadmin +
                '}';
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustpass() {
        return custpass;
    }

    public void setCustpass(String custpass) {
        this.custpass = custpass;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
}