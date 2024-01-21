package Model.Laptop;

public class Statistical {
    private int ID;
    private int Soluongspdaban;
    private Double Tienkiemduoc;
    private Double Tongtien;

    public Statistical(int ID,int soluongspdaban, Double tienkiemduoc, Double tongtien) {
        this.ID = ID;
        Soluongspdaban = soluongspdaban;
        Tienkiemduoc = tienkiemduoc;
        Tongtien = tongtien;
    }

    public int getSoluongspdaban() {
        return Soluongspdaban;
    }

    public void setSoluongspdaban(int soluongspdaban) {
        Soluongspdaban = soluongspdaban;
    }

    public Double getTienkiemduoc() {
        return Tienkiemduoc;
    }

    public void setTienkiemduoc(Double tienkiemduoc) {
        Tienkiemduoc = tienkiemduoc;
    }

    public Double getTongtien() {
        return Tongtien;
    }

    public void setTongtien(Double tongtien) {
        Tongtien = tongtien;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
