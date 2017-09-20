CREATE TABLE Train (
	[trainId] [nvarchar](50) PRIMARY KEY NOT NULL,
	[trainName] [nvarchar](100) NOT NULL,
	[startTime] [datetime] NOT NULL,
	[endTime] [datetime] NOT NULL,
	[scheduleId] [int] NULL,
	[traintype] [nvarchar](50) NOT NULL
);


CREATE TABLE [Station](
	[stationId] [int] PRIMARY KEY NOT NULL,
	[stationName] [nvarchar](50) NOT NULL
);
