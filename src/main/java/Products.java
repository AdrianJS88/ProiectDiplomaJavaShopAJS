public class Products {

    private String prodGroup,prodName;
    private int prodPrice,prodQuantity,prodid;


    public Products(int producid, String producgroup, String producname, int producprice, int producquantity) {
    }

    @Override
    public String toString() {
        return " Products : " +
                " Id :" + prodid +
                " Group:" + prodGroup  +
                " Name:" + prodName  +
                " Price:" + prodPrice +
                " Quantity:" + prodQuantity + '\n';
    }

    public String getProdGroup() {
        return prodGroup;
    }

    public void setProdGroup(String prodGroup) {
        this.prodGroup = prodGroup;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public Products(String prodGroup, String prodName, int prodPrice, int prodQuantity, int prodid) {
        this.prodGroup = prodGroup;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQuantity = prodQuantity;
        this.prodid = prodid;
    }
}
