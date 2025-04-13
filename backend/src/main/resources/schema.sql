CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description CLOB NULL
);

CREATE TABLE IF NOT EXISTS Users (
    id INT PRIMARY KEY,
    username VARCHAR(255) NULL,
    password_hash VARCHAR(255) null
);

CREATE TABLE IF NOT EXISTS Shopping_List (
    id INT PRIMARY KEY,
    user_id INT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE IF NOT EXISTS Shopping_List_Items (
    id INT PRIMARY KEY,
    shopping_list_id INT NULL,
    product_id INT NULL,
    FOREIGN KEY (shopping_list_id) REFERENCES Shopping_List(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE IF NOT EXISTS Recipes (
    id INT PRIMARY KEY,
    name VARCHAR(255) NULL,
    description TEXT NULL,
    user_id INT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE IF NOT EXISTS Recipe_Items (
    id INT PRIMARY KEY,
    recipe_id INT NULL,
    product_id INT NULL,
    quantity INT NULL,
    FOREIGN KEY (recipe_id) REFERENCES Recipes(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);
