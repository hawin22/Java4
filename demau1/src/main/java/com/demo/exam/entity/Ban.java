package com.demo.exam.entity;

import jakarta.persistence.*;

@Entity
@Table(name="ban")
public class Ban {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String ma;
    String ten;
    @Column(name = "so_thich")
    String sothich;
    @Column(name = "gioi_tinh")
    Boolean gioitinh;

    @ManyToOne @JoinColumn(name="id_mqh")
    MoiQuanHe moiQuanHe;
    //getters & setters

    public MoiQuanHe getMoiQuanHe() {
        return moiQuanHe;
    }

    public void setMoiQuanHe(MoiQuanHe moiQuanHe) {
        this.moiQuanHe = moiQuanHe;
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

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
}
