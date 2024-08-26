public class Room {
    private String soPhong;
    private String loaiPhong;
    private String tang;
    private Boolean trangThai;

    public Room() {
    }

    public Room(String soPhong, String loaiPhong, String tang, Boolean trangThai) {
        this.soPhong = soPhong;
        this.loaiPhong = loaiPhong;
        this.tang = tang;
        this.trangThai = trangThai;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getTang() {
        return tang;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
}
