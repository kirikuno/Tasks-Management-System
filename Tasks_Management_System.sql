CREATE TABLE [dbo].[Category](
	[Menu_id] [nchar](10),
	[Menu_name] [nchar](10) NULL,
	[Menu_description] [nchar](10) NULL,
	PRIMARY KEY(Menu_id)
)

CREATE TABLE [dbo].[Role](
	[role_id] [nchar](10),
	[role_name] [nchar](10) NULL,
	PRIMARY KEY(role_id)
)

CREATE TABLE [dbo].[Role_Menu](
	[Menu_id] [nchar](10) ,
	[Role_id] [nchar](10) ,
	PRIMARY KEY(Menu_id,Role_id),
  	FOREIGN KEY (Menu_id) REFERENCES Category(Menu_id),
	FOREIGN KEY (Role_id) REFERENCES [dbo].[Role](Role_id)
)

CREATE TABLE [dbo].[user](
	[userid] int,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	PRIMARY KEY(userid)
)

CREATE TABLE [dbo].[Role_Author](
	[userid] int,
	[role_id] [nchar](10),
	PRIMARY KEY(userid,role_id),
	FOREIGN KEY (userid) REFERENCES [dbo].[user](userid),
	FOREIGN KEY (Role_id) REFERENCES [dbo].[Role](Role_id)
) 


CREATE TABLE [dbo].[Tasks](
	[task_id] [varchar](50),
	[status] [nchar](10) NULL,
	[due_date] [date] NULL,
	[task_name] [nchar](10) NULL,
	PRIMARY KEY(task_id)
)

CREATE TABLE [dbo].[Task_Assigned](
	[task_id] [varchar](50),
	[userid] int,
	[phase_id] [nchar](10) NULL,
	[deadline] [date] NULL,
	[phase_status] [nchar](10) NULL,
	[home_flag] [nchar](10) NULL,
	[finished_date] [date] NULL,
	PRIMARY KEY(task_id,userid),
	FOREIGN KEY (userid) REFERENCES [dbo].[user](userid),
	FOREIGN KEY (task_id) REFERENCES Tasks(task_id)
)

CREATE TABLE [dbo].[revenue](
	[from_date] [date] NULL,
	[to_date] [date] NULL,
	[userid] int,
	[finished_task_number] [numeric](18, 0) NULL,
	FOREIGN KEY (userid) REFERENCES [dbo].[user](userid)
) 









