package Model.Personn;

public class Customers extends Person{
    private int cusId;

    public Customers(int id) {
        this.cusId = id;
    }

    public Customers(int cusId, String name, String gender, String address, String phone) {
        super(name, gender, address,phone);
        this.cusId = cusId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "cusId=" + cusId +super.toString();
    }
}
