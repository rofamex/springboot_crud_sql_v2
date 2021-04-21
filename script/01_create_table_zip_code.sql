CREATE TABLE zipcode
(
    id integer IDENTITY(1,1), 
    address varchar(8000) not null,
	PRIMARY KEY (id)
);
GO

GO
INSERT [dbo].[zipcode] ([address]) VALUES ('3132 Eglinton Ave East');
INSERT [dbo].[zipcode] ([address]) VALUES ('799 Milner Ave');
GO