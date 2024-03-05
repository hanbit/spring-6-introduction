create table if not exists t_product  (
    id varchar(100) primary key,
    name varchar(100),
    price integer,
    stock integer
);
create table if not exists t_order (
    id varchar(100) primary key,
    order_date_time timestamp,
    billing_amount integer,
    customer_name varchar(100),
    customer_address varchar(100),
    customer_phone varchar(100),
    customer_email_address varchar(100),
    payment_method varchar(100)
);
create table if not exists t_order_item (
    id varchar(100) primary key,
    order_id varchar(100),
    product_id varchar(100),
    price_at_order integer,
    quantity integer,
    foreign key (order_id) references t_order(id),
    foreign key (product_id) references t_product(id)
);