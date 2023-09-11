CREATE TABLE product(
	prodCode VARCHAR(6) NOT NULL PRIMARY KEY,
	description VARCHAR(20),
	unit VARCHAR(3)
);

CALL SYSPROC.ADMIN_CMD('DESCRIBE TABLE product');

SELECT * FROM product;

ALTER TABLE product ADD CONSTRAINT unit_ck CHECK (unit IN ('pc', 'ea', 'pkg', 'mtr', 'Ltr'));

INSERT INTO product VALUES ('PS0003', 'Cisco Virt Hardware', 'pcs');
INSERT INTO product VALUES ('PC0002', 'Dell 745 Opti Desk', 'pg');
INSERT INTO product VALUES ('PA0001', 'MS Ofc Business 2013', 'pk');
INSERT INTO product VALUES ('AM0001', 'MS Wireless Mouse', 'pcs');
INSERT INTO product VALUES ('AD0001', 'Toshiba Canvio 1 TB', 'eac');

CREATE TABLE pricehist(
	effDate DATE NOT NULL,
	prodCode VARCHAR(6) NOT NULL,
	unitPrice DECIMAL(10, 2) CONSTRAINT unitp_ck CHECK (unitPrice > 0),
	
	PRIMARY KEY(effDate, prodCode),
	FOREIGN KEY(prodCode) REFERENCES product(prodCode)
);

CALL SYSPROC.ADMIN_CMD('DESCRIBE TABLE pricehist');

INSERT INTO pricehist VALUES ('2010-05-15', 'NB0003', '199');
INSERT INTO pricehist VALUES ('2010-05-15', 'NB0004', '279');
INSERT INTO pricehist VALUES ('2010-05-15', 'NB0005', '350');

SELECT * FROM pricehist;

INSERT INTO pricehist VALUES ('2011-02-01', 'PS0003', '123.55');
INSERT INTO pricehist VALUES ('2011-02-01', 'NB0005', '-1.85');