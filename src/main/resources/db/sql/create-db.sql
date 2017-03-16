--DROP TABLE User IF EXISTS;

CREATE TABLE User (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50),
  passowrd VARCHAR(40), 
  phones INTEGER,
  creation VARCHAR(40),
  lastTimeModified VARCHAR(40),
  lastLogin VARCHAR(40)
);


--DROP TABLE Phone IF EXISTS;

CREATE TABLE Phone (
  id         INTEGER PRIMARY KEY,
  ddd VARCHAR(30),
  number  VARCHAR(50)
);
