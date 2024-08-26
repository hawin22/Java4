package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phieu_giam_gia")
public class PhieuGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ten;
    @Column(name = "so_luong")
    private Integer soluong;
    @Column(name = "loai_giam")
    private String loaigiam;
    @Column(name = "gia_tri_toi_da")
    private String giatritoida;
    @ManyToOne
    @JoinColumn(name = "loai_phieu_id")
    private LoaiPhieu loaiPhieu;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public String getLoaigiam() {
        return loaigiam;
    }

    public void setLoaigiam(String loaigiam) {
        this.loaigiam = loaigiam;
    }

    public String getGiatritoida() {
        return giatritoida;
    }

    public void setGiatritoida(String giatritoida) {
        this.giatritoida = giatritoida;
    }

    public LoaiPhieu getLoaiPhieu() {
        return loaiPhieu;
    }

    public void setLoaiPhieu(LoaiPhieu loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }
}
