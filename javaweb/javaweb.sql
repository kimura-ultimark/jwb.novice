SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS client_info;
DROP TABLE IF EXISTS numbering_stamp;
DROP TABLE IF EXISTS order_info;




/* Create Tables */

CREATE TABLE client_info
(
	order_no char(8) NOT NULL,
	family_name varchar(32),
	first_name varchar(32),
	pref varchar(16),
	city varchar(128),
	address varchar(128),
	PRIMARY KEY (order_no)
);


CREATE TABLE numbering_stamp
(
	prefix char(2) NOT NULL,
	next_no decimal(8),
	digit decimal(4),
	PRIMARY KEY (prefix)
);


CREATE TABLE order_info
(
	order_no char(8) NOT NULL,
	row_no decimal(4) NOT NULL,
	product_cd char(4),
	quantity decimal(4),
	purchase_amount decimal(8),
	PRIMARY KEY (order_no, row_no)
);



