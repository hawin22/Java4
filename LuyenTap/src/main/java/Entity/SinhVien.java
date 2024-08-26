package Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sinhvien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ma;
    private String ten;
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    private boolean gioitinh;
    private String nganhhoc;
    private boolean trangthai;

    public SinhVien() {
    }

    public SinhVien(int id, String ma, String ten, Date ngaysinh, boolean gioitinh, String nganhhoc, boolean trangthai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.nganhhoc = nganhhoc;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNganhhoc() {
        return nganhhoc;
    }

    public void setNganhhoc(String nganhhoc) {
        this.nganhhoc = nganhhoc;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
}

