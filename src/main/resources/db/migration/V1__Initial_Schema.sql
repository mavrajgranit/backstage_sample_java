CREATE TABLE IF NOT EXISTS notes(
    id  BIGINT  PRIMARY KEY,
    content    VARCHAR(2000) NOT NULL UNIQUE
);

INSERT INTO notes VALUES
(0, "Alexa. Remind me to define a proper Schema.");