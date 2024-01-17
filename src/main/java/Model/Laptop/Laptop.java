package Model.Laptop;

public class Laptop {
    private int ID;
    private String Name;
    private Double Price;
    private String Type;
    private String About;

    public Laptop() {
    }

    public Laptop(int ID, String name, Double price, String Type, String about) {
        this.ID = ID;
        this.Name = name;
        this.Price = price;
        this.Type = Type;
        this.About = about;
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