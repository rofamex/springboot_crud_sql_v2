CREATE TABLE customer
(
    id integer IDENTITY(1,1), 
	PRIMARY KEY (id),
    name varchar(8000) not null,
    age integer not null,
	zipcode_id integer,
	CONSTRAINT FK_ZipcodeId FOREIGN KEY (zipcode_id) REFERENCES zipcode(id)
);
GO

GO
INSERT [dbo].[customer] ([name], [age]) VALUES ('Alice', 22);
INSERT [dbo].[customer] ([name], [age]) VALUES ('Emily', 25);
GO
