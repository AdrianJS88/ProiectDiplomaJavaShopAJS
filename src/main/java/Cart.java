public class Cart {
    private String prodgroup,prodname;
    private int prodprice,prodid;
    private int prodquantity,iduser;

    public Cart(int prodid, String prodgroup, String prodname, int prodprice, int prodquantity) {
    }

    public Cart() {

    }

    @Override
    public String toString() {
        return " Cart items : " +
                " group:" + prodgroup  +
                " name:" + prodname  +
                " price:" + prodprice +
                " id:" + prodid +
                " quantity:" + prodquantity + '\n';
    }

    public String getProdgroup() {
        return prodgroup;
    }

    public void setProdgroup(String prodgroup) {
        this.prodgroup = prodgroup;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public int getProdprice() {
        return prodprice;
    }

    public void setProdprice(int prodprice) {
        this.prodprice = prodprice;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public int getProdquantity() {
        return prodquantity;
    }

    public void setProdquantity(int prodquantity) {
        this.prodquantity = prodquantity;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Cart(String prodgroup, String prodname, int prodprice, int prodid, int prodquantity, int iduser) {
        this.prodgroup = prodgroup;
        this.prodname = prodname;
        this.prodprice = prodprice;
        this.prodid = prodid;
        this.prodquantity = prodquantity;
        this.iduser = iduser;
    }

    public void removeFromCart(int rem) {
    }

    public void addToCart(int pId, String pName, String pType, int qPur, float pPrice) {
    }
    //cart version 2

}