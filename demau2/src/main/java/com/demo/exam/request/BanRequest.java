package com.demo.exam.request;

import com.demo.exam.entity.Ban;

public class BanRequest {
    String ma;
    String ten;
    String sothich;
    Boolean gioitinh;

    public Ban copyToEntity(Ban ban){
        ban.setMa(ma);
        ban.setTen(ten);
        ban.setSothich(sothich);
        ban.setGioitinh(gioitinh);
        return ban;
    }

    // getters& setters

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
