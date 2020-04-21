USE eBookStore;

DELETE FROM OrderDetail WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM `Order` WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM Book WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM Category WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM Author WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM PublishCompany WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM Customer WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!

INSERT INTO Customer (Name, Address, Phone, Email, UserName, Password, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ('Nguyễn Đình Hiếu', 'Vinh, Nghệ An', '0868663315', 'DinhHieu8896@gmail.com', 'Hieu-iceTea', 'MậtKhẩu', 'Hiếu đẹp trai nhất quả đất', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Đặng Kim Thi', 'Hà Nội, Việt Nam', '0985188655', 'ThiDK@gmail.com', 'ThiDK', 'Password', 'Cô giáo lớp T1909M', 'Hieu-iceTea', null, CURRENT_TIME, null, true);

INSERT INTO PublishCompany (Name, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ('Nhà xuất bản giáo dục', 'Là một doanh nghiệp Nhà nước trực thuộc Bộ Giáo dục và Đào tạo', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Nhà xuất bản Trẻ', 'Xuất bản sách và văn hóa phẩm các loại', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Nhà xuất bản Hội Nhà văn', 'Được thành lập năm 1957', 'Hieu-iceTea', null, CURRENT_TIME, null, true);

INSERT INTO Author (Name, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ('Hồ Chí Minh', 'Cựu Chủ tịch nước Việt Nam. Tên khai sinh là Nguyễn Sinh Cung', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Nguyễn Nhật Ánh', 'Năm 2015 là một năm đại thắng của nhà văn Nguyễn Nhật Ánh (sinh năm 1955) với sự thành công của bộ phim được chuyển thể từ tác phẩm đình đám cùng tên "Tôi thấy hoa vàng trên cỏ xanh"', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Trang Hạ', 'Trang Hạ được đông đảo bạn trẻ đón nhận với lối viết phóng khoáng, giọng điệu đanh thép và mạnh mẽ của mình.', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Hamlet Trương', 'Hamlet Trương tên thật là Lê Văn Trương, sinh năm 1988, anh hoạt động trong nhiều lĩnh vực: ca sĩ, nhạc sĩ, nhà văn, MC cho Radio và Talk show trên truyền hình.', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Đỗ Nhật Nam', 'Người ta thường nói " Tuổi trẻ tài cao" là câu nói không ngoa khi dành cho cậu bé thần đồng Việt Nam Đỗ Nhật Nam.', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Gào', 'Gào tên thật là Vũ Phương Thanh, cô sinh ngày 08/07/1988, cô là một hot blogger đình đám, sở hữu hàng triệu lượt người xem.', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Tuệ Nghi', '(Quá xinh nên thêm vào, ahihi) Tuệ Nghi tên thật là Phan Thanh Bảo Ngọc (1993) là Tổng giám đốc Công ty TNHH Đầu tư Thương mại Nghi Phong', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Rosie Nguyễn', 'Tên thật là Nguyễn Hoàng Nguyên, tác giả quyển sách Tuổi Trẻ Đáng Giá Bao Nhiêu, Ta ba lô trên đất Á. Hiện cô đang làm công việc viết tự do.', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Tony Buổi Sáng', 'Tác giả được yêu thích với những tựa sách hay, được nhiều bạn đọc quan tâm.', 'Hieu-iceTea', null, CURRENT_TIME, null, true);

INSERT INTO Category (Name, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ('Tâm Lý - Kỹ Năng Sống', 'Phát triển kỹ năng của bản thân', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Kinh Tế', 'Tìm hiểu kinh tế và làm giàu cho những tác giả viết sách này', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Văn Học', 'Các tác phẩm văn học kinh điển của thế giới', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Sách Thiếu Nhi', 'Giúp con khôn lớn mỗi ngày', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Ngoại Ngữ', 'Học tiếng Anh để xem phim không cần phụ đề', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ('Giáo Khoa - Tham Khảo', 'Học, học nữa, học mãi', 'Hieu-iceTea', null, CURRENT_TIME, null, true);

INSERT INTO Book (IDAuthor, IDCategory, IDPublishCompany, Name, Price, Qty, DatePublish, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Rosie Nguyễn%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Tâm Lý - Kỹ Năng Sống%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà xuất bản Hội Nhà văn%'  AND Enabled = TRUE), 'Tuổi Trẻ Đáng Giá Bao Nhiêu', 80000, 280, '2016-10-07', 'Bạn hối tiếc vì không nắm bắt lấy một cơ hội nào đó, chẳng có ai phải mất ngủ. Bạn trải qua những ngày tháng nhạt nhẽo với công việc bạn căm ghét, người ta chẳng hề bận lòng.', 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Tony Buổi Sáng%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Tâm Lý - Kỹ Năng Sống%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà xuất bản Trẻ%'  AND Enabled = TRUE), 'Trên Đường Băng', 66000, 306, '2015-08-1', 'Khi còn trẻ, hãy ra ngoài nhiều hơn ở nhà. Hãy nhào vô xin người khác “bóc hết, lột sạch” khả năng của mình.', 'Hieu-iceTea', null, CURRENT_TIME, null, true);

INSERT INTO `Order` (IDCustomer, Status, TotalPrice, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ((SELECT IDCustomer FROM Customer WHERE Name LIKE '%Nguyễn Đình Hiếu%' AND Enabled = TRUE), 1, 146000, 'Đơn hàng thứ 1 của Hiếu. Khách yêu cầu bọc sách và giao hàng nhanh', 'Hieu-iceTea', null, CURRENT_TIME, null, true);

INSERT INTO OrderDetail (IDOrder, IDBook, Price, Qty, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 1 của Hiếu%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Tuổi Trẻ Đáng Giá Bao Nhiêu%' AND Enabled = TRUE), 80000, 1, null, 'Hieu-iceTea', null, CURRENT_TIME, null, true),
       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 1 của Hiếu%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Trên Đường Băng%' AND Enabled = TRUE), 45000, 1, 'Sách đã được giảm giá', 'Hieu-iceTea', null, CURRENT_TIME, null, true);


#
INSERT INTO `Order` (IDCustomer, Status, TotalPrice, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ((SELECT IDCustomer FROM Customer WHERE Name LIKE '%Đặng Kim Thi%' AND Enabled = TRUE), 1, 80000, 'Đơn hàng thứ 1 của Thi.', 'Hieu-iceTea', null, CURRENT_TIME, null, true);

INSERT INTO OrderDetail (IDOrder, IDBook, Price, Qty, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 1 của Thi%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Tuổi Trẻ Đáng Giá Bao Nhiêu%' AND Enabled = TRUE), 160000, 2, null, 'Hieu-iceTea', null, CURRENT_TIME, null, true);

