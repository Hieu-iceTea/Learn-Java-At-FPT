# 3. Xây dựng tính năng Xem Đơn Hàng

USE ebookStore;

#Sau khi xem sách xong thì người ta sẽ mua sách. Phần mua sách chúng ta sẽ thực hiện ở Step2.
# Trong step1, giả dụ như trong cơ sở dữ liệu của bạn đã sẵn có các đơn hàng,
# bây giờ bạn cần phá triển tính năng sau để xem thông tin về đơn hàng:

#Hiển thị 30 đơn hàng mới tiếp nhận (set theo status = 1)
SELECT *
FROM `Order`
WHERE Status = 1
    AND Enabled = TRUE
ORDER BY CreatedDate DESC
LIMIT 30;

#Hiển thị đơn hàng theo mã khách hàng
SELECT *
FROM `Order`
    JOIN OrderDetail on `order`.IDOrder = OrderDetail.IDOrder
    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer
WHERE Customer.IDCustomer = 1
    AND `Order`.Enabled = TRUE
    AND OrderDetail.Enabled = TRUE
    AND Customer.Enabled = TRUE
ORDER BY `Order`.CreatedDate DESC, `Order`.IDOrder DESC ;

#Hiển thị trạng thái đơn hàng theo mã đơn hàng
SELECT
CASE Status
    WHEN 1 THEN 'Mới tiếp nhận'
    WHEN 2 THEN 'Đang chờ xử lý'
    WHEN 3 THEN 'Đã đóng gói'
    WHEN 4 THEN 'Đã gửi vận chuyển'
    WHEN 5 THEN 'Giao hàng thành công'
    WHEN 0 THEN 'Khách hàng hủy'
    ELSE '[] Không hợp lệ'
END StatusString,
`Order`.*
FROM `Order`
WHERE IDOrder = 1
    AND `Order`.Enabled = TRUE;

#Hiển thị thông tin chi tiết của một đơn hàng theo mã đơn được nhập vào
SELECT *
FROM `Order`
    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder
    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer
WHERE `Order`.IDOrder = 1
    AND `Order`.Enabled = TRUE
    AND OrderDetail.Enabled = TRUE
    AND Customer.Enabled = TRUE;

#Hiển thị những đơn hàng đang chờ xử lý (set theo status = 2)
SELECT *
FROM `Order`
    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder
    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer
WHERE `Order`.Status = 2
    AND `Order`.Enabled = TRUE
    AND OrderDetail.Enabled = TRUE
    AND Customer.Enabled = TRUE;

#Hiển thị những đơn hàng đã đóng gói (set theo status = 3)
SELECT *
FROM `Order`
    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder
    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer
WHERE `Order`.Status = 3
    AND `Order`.Enabled = TRUE
    AND OrderDetail.Enabled = TRUE
    AND Customer.Enabled = TRUE;

#Hiển thị những đơn hàng đã gửi vận chuyển (set theo status = 4)
SELECT *
FROM `Order`
    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder
    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer
WHERE `Order`.Status = 4
    AND `Order`.Enabled = TRUE
    AND OrderDetail.Enabled = TRUE
    AND Customer.Enabled = TRUE;

#Hiển thị những đơn hàng đã giao hàng thành công (set theo status = 5)
SELECT *
FROM `Order`
    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder
    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer
WHERE `Order`.Status = 5
    AND `Order`.Enabled = TRUE
    AND OrderDetail.Enabled = TRUE
    AND Customer.Enabled = TRUE;

#Hiển thị những đơn hàng bị khách hàng huỷ (set theo status = 0).
SELECT *
FROM `Order`
    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder
    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer
WHERE `Order`.Status = 0
    AND `Order`.Enabled = TRUE
    AND OrderDetail.Enabled = TRUE
    AND Customer.Enabled = TRUE;