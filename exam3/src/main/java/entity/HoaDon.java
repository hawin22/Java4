package entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ma;
    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_tao")
    private Date ngaytao;
    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_thanh_toan")
    private Date ngaythanhtoan;
    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_ship")
    private Date ngayship;
    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_nhan")
    private Date ngaynhan;
    @Column(name = "tinh_trang")
    private Integer tinhtrang;
    @ManyToOne
    @JoinColumn(name = "id_nv")
    private NhanVien nhanVien;

    public HoaDon() {
    }

    public HoaDon(Integer id, String ma, Date ngaytao, Date ngaythanhtoan, Date ngayship, Date ngaynhan, Integer tinhtrang, NhanVien nhanVien) {
        this.id = id;
        this.ma = ma;
        this.ngaytao = ngaytao;
        this.ngaythanhtoan = ngaythanhtoan;
        this.ngayship = ngayship;
        this.ngaynhan = ngaynhan;
        this.tinhtrang = tinhtrang;
        this.nhanVien = nhanVien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(Date ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public Date getNgayship() {
        return ngayship;
    }

    public void setNgayship(Date ngayship) {
        this.ngayship = ngayship;
    }

    public Date getNgaynhan() {
        return ngaynhan;
    }

    public void setNgaynhan(Date ngaynhan) {
        this.ngaynhan = ngaynhan;
    }

    public Integer getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Integer tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
