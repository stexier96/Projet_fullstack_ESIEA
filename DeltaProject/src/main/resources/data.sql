DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS categories;
 
CREATE TABLE articles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  content VARCHAR(MAX) NOT NULL,
  date DATE NOT NULL
);

 CREATE TABLE categories (
  category_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
  
INSERT INTO categories (name)VALUES
('Divertissement'),
('Politique'),
('Sport');