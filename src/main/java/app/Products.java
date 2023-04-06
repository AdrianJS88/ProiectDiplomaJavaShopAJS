package app;

public class Products {

    private int prodid,quantity;
    private String prodGroup, prodName ;
    private float prodPrice;

    @Override
    public String toString() {
        return "Products{" +
                "prodid=" + prodid +
                ", quantity=" + quantity +
                ", prodGroup='" + prodGroup + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public float getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(float prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Products(int prodid, int quantity, String prodGroup, String prodName, float prodPrice) {
        this.prodid = prodid;
        this.quantity = quantity;
        this.prodGroup = prodGroup;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }
}
