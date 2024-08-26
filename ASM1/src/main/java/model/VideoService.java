package model;

import java.util.ArrayList;

public class VideoService {
    ArrayList<Video> lstVideo = new ArrayList<>();

    public VideoService() {
        lstVideo.add(new Video("wAEu15wpAno", "Chiều 17/7 Báo số 1 tiên đăng vào vinh Bắc Bộ, hoàn lĩnh bảo báo trung gian hết Bắc Bộ đến Nghệ An", "Theo Trung tâm Dự báo khí tượng thủy văn quốc gia chỗ chí, hôi 13 giờ ngày 17-7, vị trí bảo số 1 (bảo Taluy) ở vào khoáng 20.6 độ Vĩ Bắc; 112.1 độ Kinh Đông, cách Móng Cái (Quảng Ninh) khoảng 480 km về phía Đông Đông Nam. Sức gió mạnh nhất vùng gần tâm bảo mạnh cấp 12 (118-133 km/giờ), gió cấp 15.", true, "https://bom.so/GGCxAg"));
        lstVideo.add(new Video("XcLKQ78814c", "CHUYỂN ĐỘNG KINH TẾ ngày 17/7: Anh chính thức vào CPTPP / Xe điện lại sập thiếu chip.", "Bản tin CHUYỂN ĐỘNG KINH TẾ ngày 17/7/2023 của Bảo Thanh Niên có những thông tin đang chú ý sau.", true, "https://bom.so/Pj0L8L"));
        lstVideo.add(new Video("ZKx8dLNoEvs", "Điểm tin: Tại bản tin Thời sự trong lưu đến trào lưu flex đang nổ to VTVT24.", "Khoe không xấu, thề nhưng việc khoe mẽ qua mức khiến người khác cho điều đó. Khoe không khiến người khác bật cười cùng là một nghệ thuật - Cụm \"Anh dã dân\" đóng điểm nhặt chuyện nông trường nào bằng món ăn thì báo viên nổ cung thị vị.", false, "https://bom.so/MxgpI8"));
    }

    public ArrayList<Video> getAll() {
        return lstVideo;
    }

    public Video findVideo(String id) {
        for (Video v : lstVideo) {
            if (v.getId().equalsIgnoreCase(id)) {
                return v;
            }
        }
        return null;
    }

    public void add(Video v) {
        lstVideo.add(v);
    }

    public void update(Video v) {
        for (Video vd : lstVideo) {
            if (vd.getId().equalsIgnoreCase(v.getId())) {
                lstVideo.set(lstVideo.indexOf(vd), v);
            }
        }
    }

    public void delete(String id) {
        for (int i = 0; i < lstVideo.size(); i++) {
            if (lstVideo.get(i).getId().equalsIgnoreCase(id)) {
                lstVideo.remove(i);
            }
        }
    }
}
