# 1_2 Thiết kế cơ sở dữ liệu > Tạo dữ liệu mẫu

USE eBookStore;

DELETE FROM OrderDetail WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM `Order` WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM Book WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM Category WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM Author WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM PublishCompany WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!
DELETE FROM Customer WHERE CreatedBy like '%%'; #Xóa hết dữ liệu cũ trong bảng!

INSERT INTO Customer (Name, Address, Phone, Email, UserName, Password, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ('Nguyễn Đình Hiếu', 'Vinh, Nghệ An', '0868663315', 'DinhHieu8896@gmail.com', 'Hieu-iceTea', 'MậtKhẩu', 'Hiếu đẹp trai nhất quả đất', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Đặng Kim Thi', 'Hà Nội, Việt Nam', '0985188655', 'ThiDK@gmail.com', 'ThiDK', 'Password', 'Cô giáo lớp T1909M', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Nguyễn Phương Thùy', 'Nghệ An, Việt Nam', '113', NULL, 'ThuyNP', 'Password', NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);

INSERT INTO PublishCompany (Name, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ('Nhà xuất bản giáo dục', 'Là một doanh nghiệp Nhà nước trực thuộc Bộ Giáo dục và Đào tạo', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Nhà xuất bản Trẻ', 'Xuất bản sách và văn hóa phẩm các loại', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('NXB Dân Trí', NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Nhà xuất bản Hội Nhà văn', 'Được thành lập năm 1957', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Nhà Xuất Bản Kim Đồng', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Nhà Xuất Bản Thế Giới', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('NXB Tổng Hợp TPHCM', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('NXB Lao Động Xã Hội', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Nhà Xuất Bản Văn Học', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);

INSERT INTO Author (Name, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ('Hồ Chí Minh', 'Cựu Chủ tịch nước Việt Nam. Tên khai sinh là Nguyễn Sinh Cung', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Nguyễn Nhật Ánh', 'Năm 2015 là một năm đại thắng của nhà văn Nguyễn Nhật Ánh (sinh năm 1955) với sự thành công của bộ phim được chuyển thể từ tác phẩm đình đám cùng tên "Tôi thấy hoa vàng trên cỏ xanh"', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Trang Hạ', 'Trang Hạ được đông đảo bạn trẻ đón nhận với lối viết phóng khoáng, giọng điệu đanh thép và mạnh mẽ của mình.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Hamlet Trương', 'Hamlet Trương tên thật là Lê Văn Trương, sinh năm 1988, anh hoạt động trong nhiều lĩnh vực: ca sĩ, nhạc sĩ, nhà văn, MC cho Radio và Talk show trên truyền hình.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Đỗ Nhật Nam', 'Người ta thường nói " Tuổi trẻ tài cao" là câu nói không ngoa khi dành cho cậu bé thần đồng Việt Nam Đỗ Nhật Nam.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Gào', 'Gào tên thật là Vũ Phương Thanh, cô sinh ngày 08/07/1988, cô là một hot blogger đình đám, sở hữu hàng triệu lượt người xem.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Tuệ Nghi', '(Quá xinh nên thêm vào, ahihi) Tuệ Nghi tên thật là Phan Thanh Bảo Ngọc (1993) là Tổng giám đốc Công ty TNHH Đầu tư Thương mại Nghi Phong', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Rosie Nguyễn', 'Tên thật là Nguyễn Hoàng Nguyên, tác giả quyển sách Tuổi Trẻ Đáng Giá Bao Nhiêu, Ta ba lô trên đất Á. Hiện cô đang làm công việc viết tự do.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Phạm Huy Hoàng', 'Một developer, tác giả của blog Tôi đi code dạo và youtube channel Tôi Đi Code Dạo.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Tony Buổi Sáng', 'Tác giả được yêu thích với những tựa sách hay, được nhiều bạn đọc quan tâm.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Luis Sepúlveda', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Robert T Kiyosaki', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Fujiko F Fujio', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Nguyễn Hiệp', 'Chủ biên 2 cuốn sách học ngoại ngữ bán chạy nhất TIKI 2018-2019', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Dale Carnegie', 'Dale Breckenridge Carnegie là một nhà văn và nhà thuyết trình Mỹ và là người phát triển các lớp tự giáo dục, nghệ thuật bán hàng, huấn luyện đoàn thể, nói trước công chúng và các kỹ năng giao tiếp giữa mọi người.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Jay Papasan, Gary Keller', '2 Tác giả của cuốn sách nổi tiếng "The One Thing"', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Mark Manson', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);

INSERT INTO Category (Name, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ('Tâm Lý - Kỹ Năng Sống', 'Phát triển kỹ năng của bản thân', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Kinh Tế', 'Tìm hiểu kinh tế và làm giàu cho những tác giả viết sách này', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Văn Học', 'Các tác phẩm văn học kinh điển của thế giới', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Khoa Học Kỹ Thuật', 'Các tác phẩm văn học kinh điển của thế giới', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Sách Thiếu Nhi', 'Giúp con khôn lớn mỗi ngày', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Ngoại Ngữ', 'Học tiếng Anh để xem phim không cần phụ đề', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ('Giáo Khoa - Tham Khảo', 'Học, học nữa, học mãi', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);

INSERT INTO Book (IDAuthor, IDCategory, IDPublishCompany, Name, Price, Qty, DatePublish, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Rosie Nguyễn%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Tâm Lý - Kỹ Năng Sống%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà xuất bản Hội Nhà văn%'  AND Enabled = TRUE), 'Tuổi Trẻ Đáng Giá Bao Nhiêu', 80000, 280, '2016-10-07', 'Bạn hối tiếc vì không nắm bắt lấy một cơ hội nào đó, chẳng có ai phải mất ngủ. Bạn trải qua những ngày tháng nhạt nhẽo với công việc bạn căm ghét, người ta chẳng hề bận lòng.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Phạm Huy Hoàng%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Khoa Học Kỹ Thuật%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%NXB Dân Trí%'  AND Enabled = TRUE), 'Code Dạo Kí Sự - Lập Trình Viên Đâu Phải Chỉ Biết Code', 150000, 156, '2016-08-1', 'Với mong muốn chia sẻ kinh nghiệm học lập trình và các kỹ năng mà anh đã trải qua trong suốt quá trình học và làm việc với tư cách là người đi trước cũng như là một Developer Full Stack, nên anh đã quyết định xuất bản sách “Code dạo ký sự – lập trình viên đâu phải chỉ biết code”.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Tony Buổi Sáng%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Tâm Lý - Kỹ Năng Sống%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà xuất bản Trẻ%'  AND Enabled = TRUE), 'Trên Đường Băng', 66000, 306, '2015-08-1', 'Khi còn trẻ, hãy ra ngoài nhiều hơn ở nhà. Hãy nhào vô xin người khác “bóc hết, lột sạch” khả năng của mình.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Luis Sepúlveda%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Văn Học%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà xuất bản Hội Nhà văn%'  AND Enabled = TRUE), 'Chuyện Con Mèo Dạy Hải Âu Bay', 50000, 232, '2016-12-1', 'Cô hải âu Kengah bị nhấn chìm trong váng dầu – thứ chất thải nguy hiểm mà những con người xấu xa bí mật đổ ra đại dương.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Robert T Kiyosaki%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Kinh Tế%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà xuất bản Trẻ%'  AND Enabled = TRUE), 'Dạy Con Làm Giàu - Tập 1 - Để Không Có Tiền Vẫn Tạo Ra Tiền', 99000, 560, '2017-08-1', 'Người giàu không làm việc vì tiền. Họ bắt tiền làm việc cho họ. Chấp nhận thất bại là bước đầu của thành công?', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Fujiko F Fujio%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Sách Thiếu Nhi%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà Xuất Bản Kim Đồng%'  AND Enabled = TRUE), 'Doremon Truyện Ngắn - Tập 4', 18000, 360, '2013-05-1', '', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Nguyễn Hiệp%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Ngoại Ngữ%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà Xuất Bản Thế Giới%'  AND Enabled = TRUE), 'Hack Não 1500 (phiên bản 2020)', 420000, 660, '2020-02-8', 'Sau khi hoàn thành cuốn sách tiếng Anh này, từ trình độ mất gốc bạn sẽ có đủ vốn từ vựng để giao tiếp trong cuộc sống.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Dale Carnegie%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Tâm Lý - Kỹ Năng Sống%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%NXB Tổng Hợp TPHCM%'  AND Enabled = TRUE), 'Đắc Nhân Tâm', 90000, 358, '1936-01-1', 'Đắc nhân tâm, tên tiếng Anh là How to Win Friends and Influence People là một quyển sách nhằm tự giúp bản thân bán chạy nhất từ trước đến nay.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Jay Papasan, Gary Keller%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Tâm Lý - Kỹ Năng Sống%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%NXB Lao Động Xã Hội%'  AND Enabled = TRUE), 'The One Thing - Điều Ý Nghĩa Nhất Trong Từng Khoảnh Khắc Cuộc Đời (Tái Bản 2018)', 950000, 82, '2000-01-1', 'Bạn muốn ít sự sao nhãng. Bạn muốn ít sự lựa chọn. Hàng ngày, bạn phải trả lời cả đống email, tin nhắn qua điện thoại, tin nhắn trên internet khiến bạn sao nhãng và ức chế tâm lý nặng nề.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Mark Manson%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Tâm Lý - Kỹ Năng Sống%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà Xuất Bản Văn Học%'  AND Enabled = TRUE), 'Nghệ Thuật Tinh Tế Của Việc "Đếch" Quan Tâm', 65000, 82, '2003-01-1', 'Chìa khóa của một cuộc sống tốt đẹp không phải là quan tâm nhiều hơn, mà là quan tâm ít đi, chỉ quan tâm tới điều gì là thật, gần gũi và thực sự quan trọng.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Hồ Chí Minh%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Văn Học%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà Xuất Bản Văn Học%'  AND Enabled = TRUE), 'Đường Kách Mệnh', 999999, 99, '1927-01-1', 'Đường kách mệnh là tác phẩm ghi lại những bài giảng của Nguyễn Ái Quốc cho các lớp đào tạo cán bộ tại Quảng Châu do bộ tuyên truyền của Hội Liên hiệp các dân tộc bị áp bức phát hành vào đầu năm 1927', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDAuthor FROM Author WHERE Name LIKE '%Nguyễn Nhật Ánh%' AND Enabled = TRUE), (SELECT IDCategory FROM category WHERE Name LIKE '%Văn Học%'), (SELECT IDPublishCompany FROM publishcompany WHERE Name LIKE '%Nhà Xuất Bản Trẻ%'  AND Enabled = TRUE), 'Cho Tôi Xin Một Vé Đi Tuổi Thơ', 56000, 298, '2003-01-1', 'Trong Cho tôi xin một vé đi tuổi thơ, nhà văn Nguyễn Nhật Ánh mời người đọc lên chuyến tàu quay ngược trở lại thăm tuổi thơ và tình bạn dễ thương của 4 bạn nhỏ.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);

INSERT INTO `Order` (IDCustomer, Status, TotalPrice, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ((SELECT IDCustomer FROM Customer WHERE Name LIKE '%Nguyễn Đình Hiếu%' AND Enabled = TRUE), 1, 146000, 'Đơn hàng thứ 1 của Hiếu. Khách yêu cầu bọc sách và giao hàng nhanh', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDCustomer FROM Customer WHERE Name LIKE '%Nguyễn Đình Hiếu%' AND Enabled = TRUE), 2, 656000, 'Đơn hàng thứ 2 của Hiếu.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDCustomer FROM Customer WHERE Name LIKE '%Đặng Kim Thi%' AND Enabled = TRUE), 3, 80000, 'Đơn hàng thứ 1 của ThiDK.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDCustomer FROM Customer WHERE Name LIKE '%Đặng Kim Thi%' AND Enabled = TRUE), 4, 256000, 'Đơn hàng thứ 2 của ThiDK.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDCustomer FROM Customer WHERE Name LIKE '%Nguyễn Phương Thùy%' AND Enabled = TRUE), 5, 120000, 'Đơn hàng thứ 1 của Thùy.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDCustomer FROM Customer WHERE Name LIKE '%Nguyễn Phương Thùy%' AND Enabled = TRUE), 0, 56000, 'Đơn hàng thứ 2 của Thùy.', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);

INSERT INTO OrderDetail (IDOrder, IDBook, Price, Qty, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)
VALUES ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 1 của Hiếu%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Tuổi Trẻ Đáng Giá Bao Nhiêu%' AND Enabled = TRUE), 80000, 1, NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 1 của Hiếu%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Trên Đường Băng%' AND Enabled = TRUE), 45000, 1, 'Sách đã được giảm giá', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),

       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 2 của Hiếu%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Code Dạo Kí Sự - Lập Trình Viên Đâu Phải Chỉ Biết Code%' AND Enabled = TRUE), 120000, 1, 'Sách đã được giảm giá', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 2 của Hiếu%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Hack Não 1500 (phiên bản 2020)%' AND Enabled = TRUE), 380000, 1, 'Sách đã được giảm giá', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 2 của Hiếu%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Đắc Nhân Tâm%' AND Enabled = TRUE), 80000, 1, NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),

       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 1 của ThiDK%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Tuổi Trẻ Đáng Giá Bao Nhiêu%' AND Enabled = TRUE), 160000, 2, NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),

       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 2 của ThiDK%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%The One Thing - Điều Ý Nghĩa Nhất Trong Từng Khoảnh Khắc Cuộc Đời (Tái Bản 2018)%' AND Enabled = TRUE), 98000, 1, NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),
       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 2 của ThiDK%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Nghệ Thuật Tinh Tế Của Việc "Đếch" Quan Tâm%' AND Enabled = TRUE), 88000, 1, NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),

       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 1 của Thùy%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Chuyện Con Mèo Dạy Hải Âu Bay%' AND Enabled = TRUE), 68000, 1, NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true),

       ((SELECT IDOrder FROM `Order` WHERE Description LIKE '%Đơn hàng thứ 2 của Thùy%' AND Enabled = TRUE), (SELECT IDBook FROM Book WHERE Name LIKE '%Đắc Nhân Tâm%' AND Enabled = TRUE), 89000, 3, NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);
