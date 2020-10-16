USE [Tasks_Management]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[Menu_id] [nvarchar](50) NOT NULL,
	[Menu_name] [nvarchar](50) NULL,
	[Menu_description] [nvarchar](250) NULL,
 CONSTRAINT [PK__Category__69E62710F081D9A7] PRIMARY KEY CLUSTERED 
(
	[Menu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Project]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Project](
	[project_id] [int] IDENTITY(1,1) NOT NULL,
	[project_name] [nvarchar](250) NULL,
	[project_description] [nvarchar](250) NULL,
	[due_date] [date] NULL,
 CONSTRAINT [PK_Project] PRIMARY KEY CLUSTERED 
(
	[project_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Revenue]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Revenue](
	[from_date] [date] NULL,
	[to_date] [date] NULL,
	[userid] [int] NULL,
	[finished_task_number] [numeric](18, 0) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role_id] [nvarchar](50) NOT NULL,
	[role_name] [nvarchar](50) NULL,
 CONSTRAINT [PK__Role__760965CC43F296A3] PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role_Author]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Author](
	[userid] [int] NOT NULL,
	[role_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__Role_Aut__1CC1240BD6E5B3CB] PRIMARY KEY CLUSTERED 
(
	[userid] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role_Menu]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Menu](
	[Menu_id] [nvarchar](50) NOT NULL,
	[Role_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__Role_Men__44669C1960E0C8AD] PRIMARY KEY CLUSTERED 
(
	[Menu_id] ASC,
	[Role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Task_Assigned]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Task_Assigned](
	[task_id] [int] NOT NULL,
	[userid] [int] NOT NULL,
	[phase_id] [int] NOT NULL,
	[deadline] [date] NULL,
	[finished_date] [date] NULL,
	[description] [text] NULL,
	[status] [int] NULL,
 CONSTRAINT [PK_Task_Assigned] PRIMARY KEY CLUSTERED 
(
	[task_id] ASC,
	[userid] ASC,
	[phase_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tasks]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tasks](
	[task_id] [int] IDENTITY(1,1) NOT NULL,
	[status] [nvarchar](50) NULL,
	[due_date] [date] NULL,
	[task_name] [nvarchar](520) NULL,
	[task_description] [ntext] NULL,
	[project_id] [int] NOT NULL,
	[leader_id] [int] NOT NULL,
 CONSTRAINT [PK__Tasks__0492148DDA537F48] PRIMARY KEY CLUSTERED 
(
	[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user]    Script Date: 10/9/2020 8:54:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[userid] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK__user__CBA1B2575F8368AD] PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Category] ([Menu_id], [Menu_name], [Menu_description]) VALUES (N'menu1     ', N'Detail of Tasks', NULL)
INSERT [dbo].[Category] ([Menu_id], [Menu_name], [Menu_description]) VALUES (N'menu2     ', N'Register User  ', NULL)
INSERT [dbo].[Category] ([Menu_id], [Menu_name], [Menu_description]) VALUES (N'menu3     ', N'Create a Project', NULL)
INSERT [dbo].[Category] ([Menu_id], [Menu_name], [Menu_description]) VALUES (N'menu4     ', N'Statiscial Analysis', N'statistical analysis for tasks of a project: hiển thị 1 biểu đồ theo thời gian và members hiển thị mức độ hoàn thành dự án')
SET IDENTITY_INSERT [dbo].[Project] ON 

INSERT [dbo].[Project] ([project_id], [project_name], [project_description], [due_date]) VALUES (1, N'Banking Management System ', N'...', CAST(N'2021-01-30' AS Date))
INSERT [dbo].[Project] ([project_id], [project_name], [project_description], [due_date]) VALUES (2, N'Library Management System', N'...', CAST(N'2020-12-18' AS Date))
INSERT [dbo].[Project] ([project_id], [project_name], [project_description], [due_date]) VALUES (3, N'Personal Management System', N'...', CAST(N'2020-11-20' AS Date))
INSERT [dbo].[Project] ([project_id], [project_name], [project_description], [due_date]) VALUES (5, N'Chain of Hospital Management System', N'', CAST(N'2021-01-28' AS Date))
SET IDENTITY_INSERT [dbo].[Project] OFF
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R1        ', N'administrator')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R10       ', N'customer')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R2        ', N'project manager')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R3        ', N'product owner')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R4        ', N'team lead')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R5        ', N'tech lead')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R6        ', N'full-stack developer')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R7        ', N'front-end developer')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R8        ', N'back-end developer')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (N'R9        ', N'tester')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (1, N'R1        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (2, N'R3        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (2, N'R9        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (3, N'R2        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (3, N'R6        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (4, N'R10       ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (5, N'R4        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (6, N'R5        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (7, N'R4        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (8, N'R5        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (9, N'R6        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (10, N'R7        ')
INSERT [dbo].[Role_Author] ([userid], [role_id]) VALUES (11, N'R8        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R1        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R10       ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R2        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R3        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R4        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R5        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R6        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R7        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R8        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu1     ', N'R9        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu2     ', N'R1        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu3     ', N'R1        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu3     ', N'R3        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu4     ', N'R1        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu4     ', N'R2        ')
INSERT [dbo].[Role_Menu] ([Menu_id], [Role_id]) VALUES (N'menu4     ', N'R3        ')
INSERT [dbo].[Task_Assigned] ([task_id], [userid], [phase_id], [deadline], [finished_date], [description], [status]) VALUES (7, 3, 1, CAST(N'2020-10-09' AS Date), CAST(N'2020-10-08' AS Date), N'design UI ', 3)
INSERT [dbo].[Task_Assigned] ([task_id], [userid], [phase_id], [deadline], [finished_date], [description], [status]) VALUES (7, 4, 3, CAST(N'2020-10-24' AS Date), NULL, N'coding', 2)
INSERT [dbo].[Task_Assigned] ([task_id], [userid], [phase_id], [deadline], [finished_date], [description], [status]) VALUES (7, 5, 2, CAST(N'2020-10-14' AS Date), CAST(N'2020-10-14' AS Date), N'write query', 3)
INSERT [dbo].[Task_Assigned] ([task_id], [userid], [phase_id], [deadline], [finished_date], [description], [status]) VALUES (7, 7, 4, CAST(N'2020-10-29' AS Date), NULL, N'testing', 1)
INSERT [dbo].[Task_Assigned] ([task_id], [userid], [phase_id], [deadline], [finished_date], [description], [status]) VALUES (9, 3, 2, CAST(N'2020-08-30' AS Date), CAST(N'2020-08-30' AS Date), N'write insert users query', 3)
INSERT [dbo].[Task_Assigned] ([task_id], [userid], [phase_id], [deadline], [finished_date], [description], [status]) VALUES (9, 4, 1, CAST(N'2020-08-23' AS Date), CAST(N'2020-08-22' AS Date), N'design insert user form', 3)
INSERT [dbo].[Task_Assigned] ([task_id], [userid], [phase_id], [deadline], [finished_date], [description], [status]) VALUES (9, 12, 3, CAST(N'2020-09-24' AS Date), CAST(N'2020-09-20' AS Date), N'coding and testing', 3)
SET IDENTITY_INSERT [dbo].[Tasks] ON 

INSERT [dbo].[Tasks] ([task_id], [status], [due_date], [task_name], [task_description], [project_id], [leader_id]) VALUES (1, N'not started', CAST(N'2020-10-30' AS Date), N'add new books to the system', N'...', 2, 2)
INSERT [dbo].[Tasks] ([task_id], [status], [due_date], [task_name], [task_description], [project_id], [leader_id]) VALUES (7, N'in progress', CAST(N'2020-10-30' AS Date), N'edit existing books in the system', N'...', 2, 1)
INSERT [dbo].[Tasks] ([task_id], [status], [due_date], [task_name], [task_description], [project_id], [leader_id]) VALUES (8, N'not started', CAST(N'2020-11-20' AS Date), N'add employees to the system', NULL, 1, 2)
INSERT [dbo].[Tasks] ([task_id], [status], [due_date], [task_name], [task_description], [project_id], [leader_id]) VALUES (9, N'completed', CAST(N'2020-09-30' AS Date), N'create users to the system', NULL, 3, 3)
SET IDENTITY_INSERT [dbo].[Tasks] OFF
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([userid], [username], [password]) VALUES (1, N'hiep', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (2, N'nhan', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (3, N'tung', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (4, N'toan', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (5, N'nguyen', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (6, N'dat', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (7, N'khai', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (8, N'son', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (9, N'giang', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (10, N'mai', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (11, N'tinh', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (12, N'nhat', N'12345')
INSERT [dbo].[user] ([userid], [username], [password]) VALUES (13, N'huyen', N'12345')
SET IDENTITY_INSERT [dbo].[user] OFF
ALTER TABLE [dbo].[Revenue]  WITH CHECK ADD  CONSTRAINT [FK__revenue__userid__22AA2996] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Revenue] CHECK CONSTRAINT [FK__revenue__userid__22AA2996]
GO
ALTER TABLE [dbo].[Role_Author]  WITH CHECK ADD  CONSTRAINT [FK__Role_Auth__role___1B0907CE] FOREIGN KEY([role_id])
REFERENCES [dbo].[Role] ([role_id])
GO
ALTER TABLE [dbo].[Role_Author] CHECK CONSTRAINT [FK__Role_Auth__role___1B0907CE]
GO
ALTER TABLE [dbo].[Role_Author]  WITH CHECK ADD  CONSTRAINT [FK__Role_Auth__useri__1A14E395] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Role_Author] CHECK CONSTRAINT [FK__Role_Auth__useri__1A14E395]
GO
ALTER TABLE [dbo].[Role_Menu]  WITH CHECK ADD  CONSTRAINT [FK__Role_Menu__Menu___145C0A3F] FOREIGN KEY([Menu_id])
REFERENCES [dbo].[Category] ([Menu_id])
GO
ALTER TABLE [dbo].[Role_Menu] CHECK CONSTRAINT [FK__Role_Menu__Menu___145C0A3F]
GO
ALTER TABLE [dbo].[Role_Menu]  WITH CHECK ADD  CONSTRAINT [FK__Role_Menu__Role___15502E78] FOREIGN KEY([Role_id])
REFERENCES [dbo].[Role] ([role_id])
GO
ALTER TABLE [dbo].[Role_Menu] CHECK CONSTRAINT [FK__Role_Menu__Role___15502E78]
GO
ALTER TABLE [dbo].[Task_Assigned]  WITH CHECK ADD  CONSTRAINT [FK__Task_Assi__task___656C112C] FOREIGN KEY([task_id])
REFERENCES [dbo].[Tasks] ([task_id])
GO
ALTER TABLE [dbo].[Task_Assigned] CHECK CONSTRAINT [FK__Task_Assi__task___656C112C]
GO
ALTER TABLE [dbo].[Task_Assigned]  WITH CHECK ADD  CONSTRAINT [FK__Task_Assi__useri__1FCDBCE] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Task_Assigned] CHECK CONSTRAINT [FK__Task_Assi__useri__1FCDBCE]
GO
ALTER TABLE [dbo].[Tasks]  WITH CHECK ADD FOREIGN KEY([leader_id])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Tasks]  WITH CHECK ADD  CONSTRAINT [FK__Tasks__project_i__403A8C7D] FOREIGN KEY([project_id])
REFERENCES [dbo].[Project] ([project_id])
GO
ALTER TABLE [dbo].[Tasks] CHECK CONSTRAINT [FK__Tasks__project_i__403A8C7D]
GO


  CREATE PROCEDURE submitAssignedTask(@taskId int, @phaseId int)
  AS
 Begin
 UPDATE [Tasks_Management].[dbo].[Task_Assigned] SET status = 3, finished_date = GETDATE() WHERE task_id = @taskId and phase_id = @phaseId;
 Declare @temp Int = @phaseId;
 SET @temp = @temp + 1;
 if 0 < (select count(*) from [Tasks_Management].[dbo].[Task_Assigned] where task_id = @taskId and phase_id = @temp)
 begin
    SET @phaseId = @phaseId + 1;
    UPDATE [Tasks_Management].[dbo].[Task_Assigned] SET status = 2, finished_date = NULL WHERE task_id = @taskId and phase_id = @phaseId;
 end
 else
 begin
    UPDATE [Tasks_Management].[dbo].[Tasks] SET status = 'completed' WHERE task_id in (select task_id from [Tasks_Management].[dbo].[Task_Assigned] where task_id = @taskId and phase_id = @phaseId)
 end
End;
GO
