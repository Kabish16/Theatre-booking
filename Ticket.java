public class Ticket extends Person{
    private String row;
    private String seat;
    private String price;

    private String totalPrice;

    public Ticket(String name, String surName, String mail, String row, String seat, String price, String totalPrice) {
        super(name, surName, mail);
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setsurName(String surName){
        this.surName = surName;
    }

    public String getsurName(){
        return this.surName;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public String getMail(){
        return this.mail;
    }

    public void setRow(String row){
        this.row = row;
    }

    public String getRow(){
        return this.row;
    }

    public void setSeat(String seat){
        this.seat = seat;
    }

    public String getSeat(){
        return this.seat;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public String getPrice(){
        return this.price;
    }

    public void setTotalPricePrice(String totalPrice){
        this.totalPrice = totalPrice;
    }

    public String getTotalPrice(){
        return this.totalPrice;
    }





}
