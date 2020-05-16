CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users
(
    id UUID,
    first_name VARCHAR(3000),
    last_name VARCHAR(3000),
    email VARCHAR(3000),
    PRIMARY KEY (id)
);