package Model.Laptop;

public class Laptop {
    private int ID;
    private String Name;
    private Double Price;
    private Double Cprice;
    private String Type;
    private String About;
    private int Quantity;
    private String Picture;

    public Laptop() {
    }

    public Laptop(int ID, String name, Double price, Double cprice, String Type, String about, int quantity, String picture) {
        this.ID = ID;
        this.Name = name;
        this.Price = price;
        this.Cprice = cprice;
        this.Type = Type;
        this.About = about;
        this.Quantity = quantity;
        this.Picture = picture;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Double getCprice() {
        return Cprice;
    }

    public void setCprice(Double cprice) {
        Cprice = cprice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Type='" + Type + '\'' +
                ", About='" + About + '\'' +
                '}';
    }
}