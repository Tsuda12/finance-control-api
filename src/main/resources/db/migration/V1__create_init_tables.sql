CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY NOT NULL,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL UNIQUE,
    password VARCHAR(250) NOT NULL
);

CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    description VARCHAR(250) NOT NULL,
    type VARCHAR(20) NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    date_ocurrence DATE NOT NULL,
    user_id VARCHAR(36) NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);