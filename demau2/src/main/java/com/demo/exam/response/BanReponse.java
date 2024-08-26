package com.demo.exam.response;

import com.demo.exam.entity.Ban;

public class BanReponse {
    Integer id;
    String ma;
    String ten;
    String sothich;
    String gioitinh;
    String maMQH;
    String tenMQH;

    public BanReponse(Ban ban){
        id = ban.getId();
        ma = ban.getMa();
        ten = ban.getTen();
        sothich = ban.getSothich();
        if(ban.getGioitinh() != null) {
            gioitinh = ban.getGioitinh() ? "Nam" : "Nữ";
        }
        if(ban.getMoiQuanHe() != null){
            maMQH = ban.getMoiQuanHe().getMa();
            tenMQH = ban.getMoiQuanHe().getTen();
        }
    }

    // getters

    public Integer getId() {
        return id;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getSothich() {
        return sothich;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getMaMQH() {
        return maMQH;
    }

    public String getTenMQH() {
        return tenMQH;
    }
}
