package Model.Laptop;

public class Bill {
    private int ID;
    private int CusID;
    private int LapID;
    private String Status;

    public Bill(int ID) {
        this.ID = ID;
    }

    public Bill(int cusID, int lapID, String status) {
        Status =status;
        CusID = cusID;
        LapID = lapID;
    }

    public Bill(int ID, int cusID, int lapID) {
        this.ID = ID;
        CusID = cusID;
        LapID = lapID;
    }

    public Bill(int ID, int cusID, int lapID, String status) {
        this.ID = ID;
        CusID = cusID;
        LapID = lapID;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCusID() {
        return CusID;
    }

    public void setCusID(int cusID) {
        CusID = cusID;
    }

    public int getLapID() {
        return LapID;
    }

    public void setLapID(int lapID) {
        LapID = lapID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
