INSERT INTO t_product
(id, name, price, stock) VALUES
('p01', '지우개', 100, 10)
,('p02', '노트', 200, 20)
,('p03', 'pname03', 300, 30)
,('p04', 'pname04', 400, 40)
,('p05', 'pname05', 500, 50)
,('p06', 'pname06', 600, 60)
,('p07', 'pname07', 700, 70)
,('p08', 'pname08', 800, 80)
,('p09', 'pname09', 900, 90)
,('p10', 'pname10', 1000, 100)
,('p11', 'pname11', 1100, 110)
,('p12', 'pname12', 1200, 120)
,('p13', 'pname13', 1300, 130)
;

INSERT INTO t_order
(id, order_date_time, billing_amount, customer_name, customer_address, customer_phone, customer_email_address, payment_method) VALUES
('o01', '2023-01-01', 770, 'cname01', 'caddress01', '090-0000-0001', 'cname01@example.com', 'BANK')
,('o02', '2023-01-01', 2000, 'cname02', 'caddress02', '090-0000-0002', 'cname02@example.com', 'CONVENIENCE_STORE')
;

INSERT INTO t_order_item
(id, order_id, product_id, price_at_order, quantity) VALUES
('i01', 'o01', 'p01', 100, 3)
,('i02', 'o01', 'p02', 200, 2)
;
