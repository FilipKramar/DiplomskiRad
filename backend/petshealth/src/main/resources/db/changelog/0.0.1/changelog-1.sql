CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    oib CHAR(11) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL
);

INSERT INTO users (name, surname, oib, password, email) VALUES
('John', 'Doe', '12345678341', 'password', 'john.doe@example.com');

INSERT INTO users (name, surname, oib, password, email) VALUES
('Jane', 'Doe', '10987564321', 'password', 'jane.doe@example.com');