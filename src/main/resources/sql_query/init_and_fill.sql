CREATE DATABASE fifth_task_db;
USE fifth_task_db;

CREATE TABLE store
(
    id   INT          NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL
);

CREATE TABLE item
(
    id                INT          NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
    name              VARCHAR(120) NOT NULL,
    modification_date DATETIME     NOT NULL,
    store_id          INT          NOT NULL,
    FOREIGN KEY (store_id) REFERENCES store (id) ON DELETE CASCADE
);

INSERT INTO store (name)
VALUES ('store1');
INSERT INTO store (name)
VALUES ('store2');
INSERT INTO store (name)
VALUES ('store3');


INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name1',NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2',NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name3',NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name4',NOW(), (SELECT id FROM store WHERE name = 'store2'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name5',NOW(), (SELECT id FROM store WHERE name = 'store2'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name6',NOW(), (SELECT id FROM store WHERE name = 'store2'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name7',NOW(), (SELECT id FROM store WHERE name = 'store3'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name8',NOW(), (SELECT id FROM store WHERE name = 'store3'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name9',NOW(), (SELECT id FROM store WHERE name = 'store3'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name10', NOW(), (SELECT id FROM store WHERE name = 'store3'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name11', NOW(), (SELECT id FROM store WHERE name = 'store3'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));
INSERT INTO item (name, modification_date, store_id)
VALUES ('item_name2', NOW(), (SELECT id FROM store WHERE name = 'store1'));