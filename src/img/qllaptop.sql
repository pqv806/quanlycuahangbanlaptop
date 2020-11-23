CREATE DATABASE qllaptop4
GO
USE qllaptop4
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
      mahd INT IDENTITY(1, 1)
               NOT NULL ,
      manv NVARCHAR(15) NOT NULL ,
      makh NVARCHAR(15) NOT NULL ,
      ngaylap DATE NOT NULL ,
      tongtien FLOAT NOT NULL ,
      CONSTRAINT pk_hoadon PRIMARY KEY ( mahd ) ,
      CONSTRAINT fk_hoadon_nhanvien FOREIGN KEY ( manv ) REFERENCES nhanvien ( manv ) ,
      CONSTRAINT fk_hoadon_khachhang FOREIGN KEY ( makh ) REFERENCES khachhang ( makh )
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
      mapn INT IDENTITY(1, 1)
               NOT NULL ,
      mancc NVARCHAR(15) NOT NULL ,
      manv NVARCHAR(15) NOT NULL ,
      ngaynhap DATETIME NOT NULL ,
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
      dongia FLOAT NOT NULL ,
      soluong INT NOT NULL ,
      hinhanh NVARCHAR(50) NOT NULL ,
      mota NVARCHAR(50) NOT NULL ,
      CONSTRAINT pk_sanpham PRIMARY KEY ( masp ) ,
      CONSTRAINT fk_sanpham_loaisanpham FOREIGN KEY ( malsp ) REFERENCES loaisanpham ( malsp )
    )
GO
CREATE TABLE hoadonchitiet
    (
      mahd INT NOT NULL ,
      masp NVARCHAR(15) NOT NULL ,
      soluong INT NOT NULL ,
      dongia FLOAT NOT NULL ,
      CONSTRAINT pk_hoadonchitiet PRIMARY KEY ( mahd, masp ) ,
      CONSTRAINT fk_hoadonchitiet_sanpham FOREIGN KEY ( masp ) REFERENCES sanpham ( masp ) ,
      CONSTRAINT fk_hoadonchitiet_hoadon FOREIGN KEY ( mahd ) REFERENCES hoadon ( mahd )
    )
GO
CREATE TABLE chitietphieunhap
    (
      mapn INT NOT NULL ,
      masp NVARCHAR(15) NOT NULL ,
      soluong INT NOT NULL ,
      dongia FLOAT NOT NULL ,
      CONSTRAINT pk_chitietphieunhap PRIMARY KEY ( mapn, masp ) ,
      CONSTRAINT fk_chitietphieunhap_sanpham FOREIGN KEY ( masp ) REFERENCES sanpham ( masp ) ,
      CONSTRAINT fk_chitietphieunhap_phieunhap FOREIGN KEY ( mapn ) REFERENCES phieunhap ( mapn )
    )
GO
CREATE TABLE baohanh
    (
      mabh NVARCHAR(15) NOT NULL ,
      masp NVARCHAR(15) NOT NULL ,
      makh NVARCHAR(15) NOT NULL ,
      ngaybh DATE NOT NULL ,
      hetbh DATE NOT NULL ,
      ghichu NVARCHAR(50) ,
      CONSTRAINT pk_baohanh PRIMARY KEY ( mabh ) ,
      CONSTRAINT fk_baohanh_khachhang FOREIGN KEY ( makh ) REFERENCES khachhang ( makh ) ,
      CONSTRAINT fk_baohanh_sanpham FOREIGN KEY ( masp ) REFERENCES sanpham ( masp )
    )

INSERT INTO dbo.nhanvien
        ( manv ,
          tennv ,
          ngaysinh ,
          diachi ,
          sdt ,
          trangthai
        )
VALUES  ( N'nv01', -- manv - nvarchar(15)
          N'phạm quang vinh', -- tennv - nvarchar(30)
         '02/02/2001', -- ngaysinh - date
          N'hà nam', -- diachi - nvarchar(50)
          N'09876543', -- sdt - nvarchar(12)
          N'hiện'  -- trangthai - nvarchar(30)
          ),
        ( N'nv02', -- manv - nvarchar(15)
          N'trần đức thắng', -- tennv - nvarchar(30)
         '02/09/2001', -- ngaysinh - date
          N'thái bình', -- diachi - nvarchar(50)
          N'09876543', -- sdt - nvarchar(12)
          N'hiện'  -- trangthai - nvarchar(30)
          ),
        ( N'nv03', -- manv - nvarchar(15)
          N'phạm văn tùng', -- tennv - nvarchar(30)
         '02/05/2001', -- ngaysinh - date
          N'nam định', -- diachi - nvarchar(50)
          N'09876547', -- sdt - nvarchar(12)
          N'hiện'  -- trangthai - nvarchar(30)
          )

INSERT  INTO dbo.loaisanpham
        ( malsp, tenlsp, mota )
VALUES  ( N'ml01', -- malsp - nvarchar(15)
          N'Acer', -- tenlsp - nvarchar(30)
          N'các sản phẩm của Acer' -- mota - nvarchar(50)
          ),
        ( N'ml02', -- malsp - nvarchar(15)
          N'ASUS ', -- tenlsp - nvarchar(30)
          N'các sản phẩm của ASUS ' -- mota - nvarchar(50)
          ),
        ( N'ml03', -- malsp - nvarchar(15)
          N'MSI ', -- tenlsp - nvarchar(30)
          N'các sản phẩm của MSI ' -- mota - nvarchar(50)
          )
INSERT  INTO dbo.sanpham
        ( masp, tensp, malsp, dongia, soluong, hinhanh, mota )
VALUES  ( N'sp01', -- masp - nvarchar(15)
          N'MSI Alpha A3DDK 212VN', -- tensp - nvarchar(30)
          N'ml03', -- malsp - nvarchar(15)
          199, -- dongia - float
          5, -- soluong - int
          N'msi.jpg', -- hinhanh - nvarchar(50)
          N'AMD Ryzen 7 3750H 2.3GHz up to 4.0GHz 4MB'  -- mota - nvarchar(50)
          ),
        ( N'sp02', -- masp - nvarchar(15)
          N'ASUS TUF FX505DT', -- tensp - nvarchar(30)
          N'ml02', -- malsp - nvarchar(15)
          200, -- dongia - float
          6, -- soluong - int
          N'ASUS TUF FX505DT.jpg', -- hinhanh - nvarchar(50)
          N'AMD Ryzen 7 3750H 2.3GHz up to 4.0GHz 4MB'  -- mota - nvarchar(50)
          ),
        ( N'sp03', -- masp - nvarchar(15)
          N'Acer Aspire 7 A715', -- tensp - nvarchar(30)
          N'ml01', -- malsp - nvarchar(15)
          179, -- dongia - float
          2, -- soluong - int
          N'Acer Aspire 7 A715 .jpg', -- hinhanh - nvarchar(50)
          N'AMD Ryzen 7 3750H 2.3GHz up to 4.0GHz 4MB'  -- mota - nvarchar(50)
          )

INSERT  INTO dbo.phanquyen
        ( maquyen, tenquyen, chitietquyen )
VALUES  ( N'Q01', -- maquyen - nvarchar(15)
          N'quản lý', -- tenquyen - nvarchar(30)
          N'sử dụng đầy đủ chức năng'  -- chitietquyen - nvarchar(100)
          ),
        ( N'Q02', -- maquyen - nvarchar(15)
          N'nhân viên', -- tenquyen - nvarchar(30)
          N'1 số chức năng bị hạn chế'  -- chitietquyen - nvarchar(100)
          )

INSERT  INTO dbo.taikhoan
        ( tentaikhoan, matkhau, manv, maquyen )
VALUES  ( N'vinh', -- tentaikhoan - nvarchar(30)
          N'admin', -- matkhau - nvarchar(30)
          N'nv01', -- manv - nvarchar(15)
          N'Q01'  -- maquyen - nvarchar(15)
          ),
        ( N'thang', -- tentaikhoan - nvarchar(30)
          N'thang', -- matkhau - nvarchar(30)
          N'nv02', -- manv - nvarchar(15)
          N'Q02'  -- maquyen - nvarchar(15)
          )

INSERT  INTO dbo.khachhang
        ( makh, tenkh, diachi, sdt, trangthai )
VALUES  ( N'kh01', -- makh - nvarchar(15)
          N'trần văn giang', -- tenkh - nvarchar(30)
          N'hà nam', -- diachi - nvarchar(50)
          N'09876543', -- sdt - nvarchar(12)
          N'hiện'  -- trangthai - nvarchar(30)
          ),
        ( N'kh02', -- makh - nvarchar(15)
          N'đào đình khải', -- tenkh - nvarchar(30)
          N'hà nam', -- diachi - nvarchar(50)
          N'09876543', -- sdt - nvarchar(12)
          N'hiện'  -- trangthai - nvarchar(30)
          ),
        ( N'kh03', -- makh - nvarchar(15)
          N'lê thị phuong', -- tenkh - nvarchar(30)
          N'hà nam', -- diachi - nvarchar(50)
          N'09876546', -- sdt - nvarchar(12)
          N'hiện'  -- trangthai - nvarchar(30)
          ),
        ( N'kh04', -- makh - nvarchar(15)
          N'trịnh khánh ly', -- tenkh - nvarchar(30)
          N'hà nội', -- diachi - nvarchar(50)
          N'09876546', -- sdt - nvarchar(12)
          N'hiện'  -- trangthai - nvarchar(30)
          )

INSERT  INTO dbo.nhacungcap
        ( mancc, tenncc, diachi, sdt, fax )
VALUES  ( N'mncc1', -- mancc - nvarchar(15)
          N'kim long center', -- tenncc - nvarchar(30)
          N'TPHCM', -- diachi - nvarchar(50)
          N'09876543', -- sdt - nvarchar(12)
          N'67898765'  -- fax - nvarchar(30)
          ),
        ( N'mncc2', -- mancc - nvarchar(15)
          N'FPT', -- tenncc - nvarchar(30)
          N'hà nội', -- diachi - nvarchar(50)
          N'07654321', -- sdt - nvarchar(12)
          N'45654345'  -- fax - nvarchar(30)
          )
