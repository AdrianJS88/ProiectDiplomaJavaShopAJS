public class Payment {
    private String deliverAddress;
    private String fName;
    private String lName;

    private int idCard;
    private int dateOfExpCard;

    private int cardCvv;

    @Override
    public String toString() {
        return " Payment details :" +
                " Deliver Address :" + deliverAddress +
                " Frist name: " + fName  +
                " Last name:" + lName +
                " Card id :" + idCard +
                " Date Of Exp Card:" + dateOfExpCard +
                " Card Cvv=" + cardCvv ;
    }

    public Payment(String deliverAddress, String fName, String lName, int idCard, int dateOfExpCard, int cardCvv) {
        this.deliverAddress = deliverAddress;
        this.fName = fName;
        this.lName = lName;
        this.idCard = idCard;
        this.dateOfExpCard = dateOfExpCard;
        this.cardCvv = cardCvv;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getDateOfExpCard() {
        return dateOfExpCard;
    }

    public void setDateOfExpCard(int dateOfExpCard) {
        this.dateOfExpCard = dateOfExpCard;
    }

    public int getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(int cardCvv) {
        this.cardCvv = cardCvv;
    }
}
