public class Food {
        private String foodname;
        private int iduser;
        private int id;

        private int prodprice;
        private int prodquantity;

    @Override
    public String toString() {
        return "Food{" +
                "foodname='" + foodname +
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

    public Food(String foodname, int iduser, int id, int prodprice, int prodquantity) {
        this.foodname = foodname;
        this.iduser = iduser;
        this.id = id;
        this.prodprice = prodprice;
        this.prodquantity = prodquantity;
    }

    public Food(String foodname, int iduser, int id) {
            this.foodname = foodname;
            this.iduser=iduser;
            this.id = id;
        }

        public int getIduser() {
            return iduser;
        }

        public void setIduser(int iduser) {
            this.iduser = iduser;
        }

        public String getFoodname() {
            return foodname;
        }

        public void setFoodname(String foodname) {
            this.foodname = foodname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

}
