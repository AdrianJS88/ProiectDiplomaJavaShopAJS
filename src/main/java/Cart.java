public class Cart {
        private String productname;

        private int iduser;
        private int id;
        private int prodprice;
        private int prodquantity;



    @Override
    public String toString() {
        return "Food{" +
                "foodname='" + productname +
                ", iduser=" + iduser +
                ", idproduct=" + id +
                ", prodprice=" + prodprice +
                ", prodquantity=" + prodquantity +  '\n' +
                '}';
    }

    public int getProdprice() {
        return prodprice;
    }

    public void setProdprice(int prodprice) {
        this.prodprice = prodprice;
    }

    public int getProdquantity() {
        return prodquantity;
    }

    public void setProdquantity(int prodquantity) {
        this.prodquantity = prodquantity;
    }

    public Cart(String foodname, int iduser, int id, int prodprice, int prodquantity) {
        this.productname = foodname;
        this.iduser = iduser;
        this.id = id;
        this.prodprice = prodprice;
        this.prodquantity = prodquantity;
    }

    public Cart(String foodname, int iduser, int id) {
            this.productname = foodname;
            this.iduser=iduser;
            this.id = id;
        }

        public int getIduser() {
            return iduser;
        }

        public void setIduser(int iduser) {
            this.iduser = iduser;
        }

        public String getProductname() {
            return productname;
        }

        public void setProductname(String productname) {
            this.productname = productname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

}
