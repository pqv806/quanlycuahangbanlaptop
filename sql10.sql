CREATE DATABASE qllaptop10
GO
USE qllaptop10
GO
CREATE TABLE phanquyen
    (
      maquyen NVARCHAR(15) NOT NULL ,
      tenquyen NVARCHAR(30) NOT NULL ,
      chitietquyen NVARCHAR(100) NOT NULL ,
      CONSTRAINT pk_phanquen PRIMARY KEY ( maquyen )
    )
GO
CREATE TABLE taikhoan
    (
      tentaikhoan NVARCHAR(30) NOT NULL ,
      matkhau NVARCHAR(30) NOT NULL ,
      manv NVARCHAR(15) NOT NULL ,
      maquyen NVARCHAR(15) NOT NULL ,
      CONSTRAINT pk_taikhoan PRIMARY KEY ( tentaikhoan ) ,
      CONSTRAINT fk_taikhoan_phanquyen FOREIGN KEY ( maquyen ) REFERENCES phanquyen ( maquyen )
    )
GO

CREATE TABLE nhanvien
    (
      manv NVARCHAR(15) NOT NULL ,
      tennv NVARCHAR(30) NOT NULL ,
      ngaysinh DATE NOT NULL ,
      diachi NVARCHAR(50) NOT NULL ,
      sdt NVARCHAR(12) NOT NULL ,
      trangthai NVARCHAR(30) NOT NULL ,
      CONSTRAINT pk_nhanvien PRIMARY KEY ( manv )
    )
GO
CREATE TABLE khachhang
    (
      makh NVARCHAR(15) NOT NULL ,
      tenkh NVARCHAR(30) NOT NULL ,
      diachi NVARCHAR(50) NOT NULL ,
      sdt NVARCHAR(12) NOT NULL ,
      trangthai NVARCHAR(30) NOT NULL ,
      CONSTRAINT pk_khachhang PRIMARY KEY ( makh )
    )
GO  
CREATE TABLE hoadon
    (
      mahd NVARCHAR(15) NOT NULL ,
      manv NVARCHAR(15) NOT NULL ,
      makh NVARCHAR(15) NOT NULL ,
      ngaylap NVARCHAR(20) NOT NULL,
      tongtien FLOAT NOT NULL ,
      CONSTRAINT pk_hoadon PRIMARY KEY ( mahd ) ,
      CONSTRAINT fk_hoadon_nhanvien FOREIGN KEY ( manv ) REFERENCES nhanvien ( manv ) ,
      CONSTRAINT fk_hoadon_khachhang FOREIGN KEY ( makh ) REFERENCES khachhang ( makh ),
    )
GO
CREATE TABLE nhacungcap
    (
      mancc NVARCHAR(15) NOT NULL ,
      tenncc NVARCHAR(30) NOT NULL ,
      diachi NVARCHAR(50) NOT NULL ,
      sdt NVARCHAR(12) NOT NULL ,
      fax NVARCHAR(30) NOT NULL ,
      CONSTRAINT pk_nhacungcap PRIMARY KEY ( mancc )
    )
GO
CREATE TABLE phieunhap
    (
      mapn NVARCHAR(15),
      mancc NVARCHAR(15) NOT NULL ,
      manv NVARCHAR(15) NOT NULL ,
      ngaynhap NVARCHAR(15) NOT NULL ,
      tongtien FLOAT NOT NULL ,
      CONSTRAINT pk_phieunhap PRIMARY KEY ( mapn ) ,
      CONSTRAINT fk_phieunhap_nhacungcap FOREIGN KEY ( mancc ) REFERENCES nhacungcap ( mancc ) ,
      CONSTRAINT fk_phieunhap_nhanvien FOREIGN KEY ( manv ) REFERENCES nhanvien ( manv )
    )
GO
CREATE TABLE loaisanpham
    (
      malsp NVARCHAR(15) NOT NULL ,
      tenlsp NVARCHAR(30) NOT NULL ,
      mota NVARCHAR(50) NOT NULL ,
      CONSTRAINT pk_loaisanpham PRIMARY KEY ( malsp )
    )
GO
CREATE TABLE sanpham
    (
      masp NVARCHAR(15) NOT NULL ,
      tensp NVARCHAR(30) NOT NULL ,
      malsp NVARCHAR(15) NOT NULL ,
      giaban FLOAT NOT NULL ,
	  gianhap FLOAT NOT NULL ,
      soluong INT NOT NULL ,
      hinhanh NVARCHAR(50) NOT NULL ,
      mota NVARCHAR(50) NOT NULL ,
      CONSTRAINT pk_sanpham PRIMARY KEY ( masp ) ,
      CONSTRAINT fk_sanpham_loaisanpham FOREIGN KEY ( malsp ) REFERENCES loaisanpham ( malsp )
    )
GO
CREATE TABLE hoadonchitiet
    (
      mahd NVARCHAR(15) NOT NULL ,
      masp NVARCHAR(15) NOT NULL ,
	  tensp NVARCHAR(20) NOT NULL,
      soluong INT NOT NULL ,
      dongia FLOAT NOT NULL ,
      CONSTRAINT pk_hoadonchitiet PRIMARY KEY ( mahd, masp ) ,
      CONSTRAINT fk_hoadonchitiet_sanpham FOREIGN KEY ( masp ) REFERENCES sanpham ( masp ) ,
      CONSTRAINT fk_hoadonchitiet_hoadon FOREIGN KEY ( mahd ) REFERENCES hoadon ( mahd )
    )
GO
CREATE TABLE chitietphieunhap
    (
      mapn NVARCHAR(15) NOT NULL ,
      masp NVARCHAR(15) NOT NULL ,
	  tensp NVARCHAR(15) NOT NULL,
      soluong INT NOT NULL ,
      dongia FLOAT NOT NULL ,
      CONSTRAINT pk_chitietphieunhap PRIMARY KEY ( mapn, masp ) ,
      CONSTRAINT fk_chitietphieunhap_sanpham FOREIGN KEY ( masp ) REFERENCES sanpham ( masp ) ,
      CONSTRAINT fk_chitietphieunhap_phieunhap FOREIGN KEY ( mapn ) REFERENCES phieunhap ( mapn )
    )
GO
CREATE TABLE trahang1
   (
     matrahang NVARCHAR(15) NOT NULL ,
     masp NVARCHAR(15) NOT NULL ,
	 mahd NVARCHAR(15) NOT NULL ,
     makh NVARCHAR(15) NOT NULL ,
     phuongthuctra NVARCHAR(20) ,
     ngay DATE NOT NULL ,
	 lydodoitra NVARCHAR(50),
	 trangthai NVARCHAR(50),
     ghichu NVARCHAR(50) ,
     CONSTRAINT trahang PRIMARY KEY ( matrahang ) ,
     CONSTRAINT fk_trahang_khachhang FOREIGN KEY ( makh ) REFERENCES khachhang ( makh ) ,
     CONSTRAINT fk_trahang_sanpham FOREIGN KEY ( masp ) REFERENCES sanpham ( masp ),
	 CONSTRAINT fk_trahang_hoadon FOREIGN KEY ( mahd ) REFERENCES dbo.hoadon ( mahd )
   )
GO
CREATE TABLE chitietsanpham
   (
     masp NVARCHAR(15) NOT NULL ,
     ram NVARCHAR(100),
	 bonho NVARCHAR(100),
	 camera NVARCHAR(100),
	 manhinh NVARCHAR(100),
	 pin NVARCHAR(100),
	 cpu NVARCHAR(100),
	 vo NVARCHAR(100),
	 khac NVARCHAR(100),
	 CONSTRAINT pk_chitietsanpham PRIMARY KEY (  masp ) ,
     CONSTRAINT fk_chitietsanpham_sanpham FOREIGN KEY ( masp ) REFERENCES sanpham ( masp ) 
	)
GO	
CREATE SEQUENCE manext
START WITH 50
INCREMENT BY 1;

SELECT NEXT VALUE FOR manext;

INSERT INTO dbo.nhanvien
        ( manv ,
          tennv ,
          ngaysinh ,
          diachi ,
          sdt ,
          trangthai
        )
VALUES  ( N'NV01' , -- manv - nvarchar(15)
          N'Phạm Văn Tùng' , -- tennv - nvarchar(30)
          GETDATE() , -- ngaysinh - date
          N'Nam Định' , -- diachi - nvarchar(50)
          N'0347007591' , -- sdt - nvarchar(12)
          N'Hiện'  -- trangthai - nvarchar(30)
        )

INSERT INTO dbo.phanquyen
        ( maquyen, tenquyen, chitietquyen )
VALUES  ( N'Q01', -- maquyen - nvarchar(15)
          N'ADMIN', -- tenquyen - nvarchar(30)
          N'Toàn Hệ Thống'  -- chitietquyen - nvarchar(100)
          )

INSERT INTO dbo.taikhoan
        ( tentaikhoan, matkhau, manv, maquyen )
VALUES  ( N'anhtung', -- tentaikhoan - nvarchar(30)
          N'anhtung', -- matkhau - nvarchar(30)
          N'NV01', -- manv - nvarchar(15)
          N'Q01'  -- maquyen - nvarchar(15)
          )