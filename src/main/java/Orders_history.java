import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders_history {





    public Orders_history(int orderId, int billid, int prodid, String prodgroup, String prodname, String fName, String lName, int prodprice, String deliveraddress, int idCard, int expCardDate, int cardCvv, int prodquantity) {
    }

    @Override
    public String toString() {
        return "Orders history : " +
                " Product id : " + prodid +
                " Order id : " + orderid +
                " Product price :" + prodprice +
                " Product quantity :" + prodquantity +
                " Bill id : " + billid +
                " Id_card :" + id_card +
                " Exp_card_date : " + exp_card_date +
                " Card_cvv : " + card_cvv +
                " Product group : " + prodgroup  +
                " Product name : " + prodname +
                " Deliver address : " + deliveraddress  +
                " First name : " + f_name  +
                " Last name : " + l_name + "\n";
    }

    private int prodid,orderid, prodprice,prodquantity, billid,id_card,exp_card_date,card_cvv;

 private String prodgroup,prodname,deliveraddress,f_name,l_name;

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public int getExp_card_date() {
        return exp_card_date;
    }

    public void setExp_card_date(int exp_card_date) {
        this.exp_card_date = exp_card_date;
    }

    public int getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(int card_cvv) {
        this.card_cvv = card_cvv;
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

    public String getDeliveraddress() {
        return deliveraddress;
    }

    public void setDeliveraddress(String deliveraddress) {
        this.deliveraddress = deliveraddress;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public Orders_history(int prodid, int orderid, int prodprice, int prodquantity, int billid, String prodgroup, String prodname, String f_name, String l_name) {
        this.prodid = prodid;
        this.orderid = orderid;
        this.prodprice = prodprice;
        this.prodquantity = prodquantity;
        this.billid = billid;
        this.prodgroup = prodgroup;
        this.prodname = prodname;
        this.f_name = f_name;
        this.l_name = l_name;
    }
}
