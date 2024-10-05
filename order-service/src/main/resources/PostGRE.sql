DROP TABLE commerce.users;

DROP TABLE commerce.order_items;

DROP TABLE commerce.orders;

DROP TABLE commerce.addresses;

DROP TABLE commerce.stocks;

DROP TABLE commerce.prices;

DROP TABLE commerce.products;

CREATE TABLE commerce.users
(
    user_id    SERIAL PRIMARY KEY,
    username   VARCHAR(50)  NOT NULL,
    email      VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO commerce.users (username, email)
VALUES ('user1', 'user1@example.com'),
       ('user2', 'user2@example.com'),
       ('user3', 'user3@example.com'),
       ('user4', 'user4@example.com'),
       ('user5', 'user5@example.com'),
       ('user6', 'user6@example.com'),
       ('user7', 'user7@example.com'),
       ('user8', 'user8@example.com'),
       ('user9', 'user9@example.com'),
       ('user10', 'user10@example.com');


CREATE TABLE commerce.products
(
    product_id   SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    description  TEXT,
    category     VARCHAR(50),
    brand        VARCHAR(50),
    sku          VARCHAR(50) UNIQUE,
    release_date DATE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO commerce.products (name, description, category, brand, sku, release_date)
VALUES ('Canon EOS R5', 'High-resolution full-frame mirrorless camera', 'Camera', 'Canon', 'CANON-R5', '2023-01-01'),
       ('Nikon Z7 II', 'Advanced mirrorless camera with excellent image quality', 'Camera', 'Nikon', 'NIKON-Z7II', '2023-02-01'),
       ('Sony Alpha a7R IV', 'High-resolution full-frame mirrorless camera', 'Camera', 'Sony', 'SONY-A7RIV', '2023-03-01'),
       ('Fujifilm X-T4', 'Versatile mirrorless camera with in-body stabilization', 'Camera', 'Fujifilm', 'FUJI-XT4',
        '2023-04-01'),
       ('Panasonic Lumix S1R', 'Full-frame mirrorless camera with high resolution', 'Camera', 'Panasonic', 'PANASONIC-S1R',
        '2023-05-01'),
       ('Olympus OM-D E-M1 Mark III', 'Compact and rugged mirrorless camera', 'Camera', 'Olympus', 'OLYMPUS-EM1III',
        '2023-06-01'),
       ('Canon EOS M50 Mark II', 'Compact and lightweight mirrorless camera', 'Camera', 'Canon', 'CANON-M50II', '2023-07-01'),
       ('Nikon D850', 'High-resolution DSLR camera with excellent image quality', 'Camera', 'Nikon', 'NIKON-D850', '2023-08-01'),
       ('Sony Alpha a6600', 'APS-C mirrorless camera with fast autofocus', 'Camera', 'Sony', 'SONY-A6600', '2023-09-01'),
       ('Fujifilm GFX 100S', 'Medium format mirrorless camera with high resolution', 'Camera', 'Fujifilm', 'FUJI-GFX100S',
        '2023-10-01');

-- Create the stocks table
CREATE TABLE commerce.stocks (
                                 stock_id SERIAL PRIMARY KEY,
                                 product_id INT REFERENCES commerce.products(product_id) ON DELETE CASCADE,
                                 quantity INT NOT NULL,
                                 last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO commerce.stocks (product_id, quantity)
VALUES
    (1, 100), -- Assuming product_id 1 represents Canon EOS R5
    (2, 150), -- Assuming product_id 2 represents Nikon Z7 II
    (3, 200), -- Assuming product_id 3 represents Sony Alpha a7R IV
    (4, 120), -- Assuming product_id 4 represents Fujifilm X-T4
    (5, 80),  -- Assuming product_id 5 represents Panasonic Lumix S1R
    (6, 50),  -- Assuming product_id 6 represents Olympus OM-D E-M1 Mark III
    (7, 180), -- Assuming product_id 7 represents Canon EOS M50 Mark II
    (8, 90),  -- Assuming product_id 8 represents Nikon D850
    (9, 60),  -- Assuming product_id 9 represents Sony Alpha a6600
    (10, 30); -- Assuming product_id 10 represents Fujifilm GFX 100S

-- Create the prices table
CREATE TABLE commerce.prices (
                                 price_id SERIAL PRIMARY KEY,
                                 product_id INT REFERENCES commerce.products(product_id) ON DELETE CASCADE,
                                 price NUMERIC(10, 2) NOT NULL,
                                 currency VARCHAR(3) DEFAULT 'USD',
                                 start_date DATE NOT NULL,
                                 end_date DATE,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample price data
INSERT INTO commerce.prices (product_id, price, start_date, end_date)
VALUES
    (1, 2999.99, '2023-01-01', NULL), -- Assuming product_id 1 represents Canon EOS R5
    (2, 2499.99, '2023-01-01', NULL), -- Assuming product_id 2 represents Nikon Z7 II
    (3, 3499.99, '2023-01-01', NULL), -- Assuming product_id 3 represents Sony Alpha a7R IV
    (4, 1999.99, '2023-01-01', NULL), -- Assuming product_id 4 represents Fujifilm X-T4
    (5, 2499.99, '2023-01-01', NULL), -- Assuming product_id 5 represents Panasonic Lumix S1R
    (6, 1799.99, '2023-01-01', NULL), -- Assuming product_id 6 represents Olympus OM-D E-M1 Mark III
    (7, 799.99, '2023-01-01', NULL),  -- Assuming product_id 7 represents Canon EOS M50 Mark II
    (8, 3499.99, '2023-01-01', NULL), -- Assuming product_id 8 represents Nikon D850
    (9, 1199.99, '2023-01-01', NULL), -- Assuming product_id 9 represents Sony Alpha a6600
    (10, 5999.99, '2023-01-01', NULL);-- Assuming product_id 10 represents Fujifilm GFX 100S

CREATE TABLE commerce.addresses (
                                    address_id SERIAL PRIMARY KEY,
                                    street TEXT NOT NULL,
                                    city VARCHAR(100) NOT NULL,
                                    state VARCHAR(100) NOT NULL,
                                    zip_code VARCHAR(20) NOT NULL,
                                    country VARCHAR(100) NOT NULL,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO commerce.addresses (street, city, state, zip_code, country)
VALUES
    ('123 Main St', 'Springfield', 'IL', '62701', 'USA'),
    ('456 Elm St', 'Shelbyville', 'IL', '62565', 'USA'),
    ('789 Oak St', 'Capital City', 'IL', '62703', 'USA'),
    ('101 Maple St', 'Springfield', 'IL', '62704', 'USA'),
    ('202 Birch St', 'Shelbyville', 'IL', '62565', 'USA'),
    ('303 Pine St', 'Springfield', 'MO', '65806', 'USA'),
    ('404 Cedar St', 'Jefferson City', 'MO', '65101', 'USA'),
    ('505 Walnut St', 'Columbia', 'MO', '65201', 'USA'),
    ('606 Ash St', 'Kansas City', 'MO', '64108', 'USA'),
    ('707 Cherry St', 'St. Louis', 'MO', '63101', 'USA');


CREATE TABLE commerce.orders (
                                 order_id SERIAL PRIMARY KEY,
                                 order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 customer_id INT REFERENCES commerce.users(user_id),
                                 total_amount NUMERIC(10, 2) NOT NULL,
                                 status VARCHAR(50) NOT NULL,
                                 address_id INT REFERENCES commerce.addresses(address_id),
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE commerce.order_items (
                                      order_item_id SERIAL PRIMARY KEY,
                                      order_id INT REFERENCES commerce.orders(order_id) ON DELETE CASCADE,
                                      product_id INT REFERENCES commerce.products(product_id),  -- Foreign key to product table
                                      quantity INT NOT NULL,
                                      total_price NUMERIC(10, 2) NOT NULL,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);