# 2. Xây dựng tính năng Xem Sách

USE ebookStore;

#Để mua sách, thì trước tiên người dùng cần xem được sách. Bạn hãy phát triển phần nghiệp vụ để người dùng có thể xem sách theo các tiêu chí sau

#Xem toàn bộ 10 cuốn sách mới nhất
SELECT *
FROM Book
WHERE Enabled = TRUE
ORDER BY DatePublish DESC
LIMIT 10;

#Xem 100 cuốn sách bán chạy nhất
SELECT Book.IDBook, Book.Name, SUM(OrderDetail.Qty) AS coutBook
FROM `Order`
    JOIN Orderdetail ON `Order`.IDOrder = OrderDetail.IDOrder
    JOIN Book ON OrderDetail.IDBook = Book.IDBook
WHERE `Order`.CreatedDate > DATE_ADD(CURRENT_DATE, INTERVAL -30 DAY)
    AND `Order`.Status IN (1, 2, 3, 4, 5)
    AND `Order`.Enabled = TRUE
    AND Orderdetail.Enabled = TRUE
    AND Book.Enabled = TRUE
GROUP BY Book.IDBook
ORDER BY coutBook DESC
LIMIT 100;


#Tìm sách theo thể loại (người dùng nhập thể loại, sau đó sẽ hiển thị sách theo thể loại đó)
SELECT Book.*
FROM Category
    JOIN Book on Category.IDCategory = Book.IDCategory
WHERE Category.Name LIKE '%Ky Nang%'
    AND Category.Enabled = TRUE;

#Tìm sách theo tên tác giả (người dùng nhập tên tác giả, sau đó sẽ hiển thị toàn bộ sách của tác giả đó)
SELECT Book.*
FROM Book
    JOIN Author on Book.IDAuthor = Author.IDAuthor
WHERE Author.Name LIKE '%Rosie%'
    AND Book.Enabled = TRUE
    AND Author.Enabled = TRUE;

#Xem chi tiết về cuốn sách (người dùng nhập id của sách, hiển thị chi tiết toàn bộ thông tin về sách).
SELECT Author.Name, Category.Name, PublishCompany.Name, Book.*
FROM Book
    JOIN Author on book.IDAuthor = Author.IDAuthor
    JOIN Category on book.IDCategory = Category.IDCategory
    JOIN PublishCompany on book.IDPublishCompany = PublishCompany.IDPublishCompany
WHERE Book.IDBook = 1
    AND Book.Enabled = TRUE;