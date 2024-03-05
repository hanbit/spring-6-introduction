create table if not exists training  (
    id varchar(100) primary key,
    title varchar(100),
    start_date_time timestamp,
    end_date_time timestamp,
    reserved integer,
    capacity integer
);

create table if not exists student_type (
    id varchar(100) primary key,
    code varchar(100) unique,
    name varchar(100)
);

create table if not exists reservation (
    id varchar(100) primary key,
    training_id varchar(100),
    student_type_id varchar(100),
    reserved_date_time timestamp,
    name varchar(100),
    phone varchar(100),
    email_address varchar(100),
    foreign key (training_id) references training(id),
    foreign key (student_type_id) references student_type(id)
);

create table audit_log (
	id varchar(100) primary key,
	function_name varchar(100),
	event_date_time timestamp,
	user_id varchar(100)
);