USE [Tasks_Management]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 10/4/2020 3:56:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[Menu_id] [nchar](10) NOT NULL,
	[Menu_name] [nvarchar](50) NULL,
	[Menu_description] [nvarchar](250) NULL,
 CONSTRAINT [PK__Category__69E62710F081D9A7] PRIMARY KEY CLUSTERED 
(
	[Menu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[revenue]    Script Date: 10/4/2020 3:56:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[revenue](
	[from_date] [date] NULL,
	[to_date] [date] NULL,
	[userid] [int] NULL,
	[finished_task_number] [numeric](18, 0) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 10/4/2020 3:56:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role_id] [nchar](10) NOT NULL,
	[role_name] [nvarchar](50) NULL,
 CONSTRAINT [PK__Role__760965CC43F296A3] PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role_Author]    Script Date: 10/4/2020 3:56:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Author](
	[userid] [int] NOT NULL,
	[role_id] [nchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[userid] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role_Menu]    Script Date: 10/4/2020 3:56:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Menu](
	[Menu_id] [nchar](10) NOT NULL,
	[Role_id] [nchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Menu_id] ASC,
	[Role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Task_Assigned]    Script Date: 10/4/2020 3:56:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Task_Assigned](
	[task_id] [varchar](50) NOT NULL,
	[userid] [int] NOT NULL,
	[phase_id] [nchar](10) NULL,
	[deadline] [date] NULL,
	[phase_status] [nchar](10) NULL,
	[home_flag] [nchar](10) NULL,
	[finished_date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[task_id] ASC,
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tasks]    Script Date: 10/4/2020 3:56:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tasks](
	[task_id] [varchar](50) NOT NULL,
	[status] [nchar](10) NULL,
	[due_date] [date] NULL,
	[task_name] [nchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user]    Script Date: 10/4/2020 3:56:05 PM ******/
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
INSERT [dbo].[Category] ([Menu_id], [Menu_name], [Menu_description]) VALUES (N'menu3     ', N'Create A Project', NULL)
INSERT [dbo].[Category] ([Menu_id], [Menu_name], [Menu_description]) VALUES (N'menu4     ', N'statiscial analysis', N'statistical analysis for tasks of a project: hiển thị 1 biểu đồ theo thời gian và members hiển thị mức độ hoàn thành dự án')
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
ALTER TABLE [dbo].[revenue]  WITH CHECK ADD  CONSTRAINT [FK__revenue__userid__22AA2996] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[revenue] CHECK CONSTRAINT [FK__revenue__userid__22AA2996]
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
ALTER TABLE [dbo].[Task_Assigned]  WITH CHECK ADD FOREIGN KEY([task_id])
REFERENCES [dbo].[Tasks] ([task_id])
GO
ALTER TABLE [dbo].[Task_Assigned]  WITH CHECK ADD  CONSTRAINT [FK__Task_Assi__useri__1FCDBCEB] FOREIGN KEY([userid])
REFERENCES [dbo].[user] ([userid])
GO
ALTER TABLE [dbo].[Task_Assigned] CHECK CONSTRAINT [FK__Task_Assi__useri__1FCDBCEB]
GO
