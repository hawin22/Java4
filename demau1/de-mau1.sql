USE
master;
CREATE
DATABASE demau1;
GO
USE demau1;

CREATE TABLE KhachHang
(
    [
    Id] [
    int]
    IDENTITY
(
    1,
    1
) NOT NULL PRIMARY KEY, [Ma] [varchar](20) NULL, [Ten] [nvarchar](30) NULL, [TenDem] [nvarchar](30) NULL, [Ho] [nvarchar](30) NULL, [NgaySinh] [date] NULL, [Sdt] [varchar](30) NULL, [DiaChi] [nvarchar](100) NULL, [ThanhPho] [nvarchar](50) NULL, [QuocGia] [nvarchar](50) NULL, [MatKhau] [varchar](max) NULL
);

INSERT INTO KhachHang(Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau)
VALUES ('KH1', N'Hằng', N'Thúy', N'Nguyễn', '2004-01-11', '0924566666', N'Hà Nội', N'Hà Nội', N'Việt Nam', '12345'),
       ('KH2', N'Nguyên', N'Vũ', N'Văn', '2005-01-11', '0924566667', N'Vĩnh Phúc', N'Vĩnh Phúc', N'Việt Nam', '12346'),
       ('KH3', N'Phong', N'Trần', N'Tuấn', '2006-02-11', '0924566668', N'Thái Bình', N'Thái Bình', N'Việt Nam',
        '12347');