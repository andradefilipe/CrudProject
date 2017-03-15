--DROP TABLE User IF EXISTS;

CREATE TABLE User (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50),
  passowrd VARCHAR(40)
);
