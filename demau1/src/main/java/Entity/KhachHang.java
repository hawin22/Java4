package Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String ho;
    String tendem;
    String ten;
    String sdt;
    String diachi;
    String matkhau;
    @Temporal(TemporalType.DATE)
    Date ngaysinh;

    public KhachHang() {
    }

    public KhachHang(Integer id, String ho, String tenDem, String ten, String sdt, String diaChi, String matKhau, Date ngaySinh) {
        this.id = id;
        this.ho = ho;
        this.tendem = tendem;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.matkhau = matkhau;
        this.ngaysinh = ngaysinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTendem() {
        return tendem;
    }

    public void setTendem(String tendem) {
        this.tendem = tendem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
}
