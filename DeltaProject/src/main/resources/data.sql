DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS categories;
 
CREATE TABLE articles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  cost INT(250) NOT NULL
);

 CREATE TABLE categories (
  category_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
  
CREATE TABLE category_article (
	category_id INT NOT NULL,
	article_id INT NOT NULL
);

	