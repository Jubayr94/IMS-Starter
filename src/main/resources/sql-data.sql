Create Database If Not Exists ims;

Use ims;

CREATE TABLE IF NOT EXISTS customers (
id INT(11) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(45) DEFAULT NULL,
    surname VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS items (
    item_id INT(11) NOT NULL AUTO_INCREMENT,
    item_name VARCHAR(40) DEFAULT NULL,
    price DECIMAL(8,2) DEFAULT NULL,
    PRIMARY KEY (item_id)
);

CREATE TABLE IF NOT EXISTS orders (
	order_id INT NOT NULL AUTO_INCREMENT, 
    fk_id INT NOT NULL,
	PRIMARY KEY (order_id),
	FOREIGN KEY (fk_id) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS orders_items (
	orders_items_id INT NOT NULL AUTO_INCREMENT,
    fk_order_id INT NOT NULL,
	fk_item_id INT NOT NULL, 
    quantity INT DEFAULT 1, 
    total_cost DECIMAL(8,2),
	PRIMARY KEY (orders_items_id),
	FOREIGN KEY (fk_order_id) REFERENCES orders(order_id),
	FOREIGN KEY (fk_item_id) REFERENCES items(item_id)
);
