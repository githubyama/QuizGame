CREATE TABLE QUESTION(
  ID BIGINT PRIMARY KEY NOT NULL IDENTITY,
  PROMPT VARCHAR(50) NOT NULL,
  OPTIONA VARCHAR(50) NOT NULL,
  OPTIONB VARCHAR(50) NOT NULL,
  OPTIONC VARCHAR(50) NOT NULL,
  CORRECT_ANSWER INT NOT NULL
);