select @@version;

CREATE TABLE Person (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255) 
);

CREATE INDEX idx_lastname
ON Person (LastName);

INSERT INTO Person (PersonID, LastName, FirstName, Address, City)
VALUES ('123', 'Perez', 'Jennifer', 'B123', 'Medellin');

INSERT INTO Person (PersonID, LastName, FirstName, Address, City)
VALUES ('345', 'Beltran', 'Johan', 'B123', 'Lima');