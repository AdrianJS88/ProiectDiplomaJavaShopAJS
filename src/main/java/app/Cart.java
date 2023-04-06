package app;



public class Cart {

    private int  idProd,quantity;


    private String prodGroup, prodName;


    private float prodPrice ;


    public Cart(int idProd, int quantity, String prodGroup, String prodName, float prodPrice) {
        this.idProd = idProd;
        this.quantity = quantity;
        this.prodGroup = prodGroup;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
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

    @Override
    public String toString() {
        return "Cart{" +
                "idProd=" + idProd +
                ", quantity=" + quantity +
                ", prodGroup='" + prodGroup + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }
}
