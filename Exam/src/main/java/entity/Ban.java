package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ban")
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "so_thich")
    private String sothich;
    @Column(name = "gioi_tinh")
    private Integer gioitinh;
    @ManyToOne
    @JoinColumn(name = "id_mqh",referencedColumnName = "id")
    private MQH mqh;

    public Ban() {
    }

    public Ban(Integer id, String ma, String ten, String sothich, Integer gioitinh, entity.MQH mqh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.sothich = sothich;
        this.gioitinh = gioitinh;
        this.mqh = mqh;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSothich() {
        return sothich;
    }

    public void setSothich(String sothich) {
        this.sothich = sothich;
    }

    public Integer getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Integer gioitinh) {
        this.gioitinh = gioitinh;
    }

    public entity.MQH getMqh() {
        return mqh;
    }

    public void setMqh(entity.MQH mqh) {
        this.mqh = mqh;
    }

}
