package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int nambh;
    private int soluongton;
    private double gianhap;
    private String mota;

//    public SanPham() {
//    }
//
//    public SanPham(int id, int nambh, int soluongton, double gianhap, String mota) {
//        this.id = id;
//        this.nambh = nambh;
//        this.soluongton = soluongton;
//        this.gianhap = gianhap;
//        this.mota = mota;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNambh() {
        return nambh;
    }

    public void setNambh(int nambh) {
        this.nambh = nambh;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public double getGianhap() {
        return gianhap;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
