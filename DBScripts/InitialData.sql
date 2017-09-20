insert into Train 
(trainId,trainName,startTime,endTime,scheduleId,traintype)
values ( 1, 'Bangalore Express', datetime('now'),datetime('now','+3 HOURS'), null, 'Express');

insert into Train 
(trainId,trainName,startTime,endTime,scheduleId,traintype)
values (2,'Chennai Express', datetime('now'),datetime('now','+5 HOURS'), null, 'Shatabdi');

insert into Train 
(trainId,trainName,startTime,endTime,scheduleId,traintype)
values (3,'Hyderabad Express', datetime('now'),datetime('now','+7 HOURS'), null, 'Passenger');


insert into Station ( stationId, stationName)
values ( 1, 'Bangalore');

insert into Station ( stationId, stationName)
values ( 2, 'Chennai');

insert into Station ( stationId, stationName)
values ( 3, 'Hyderabad');