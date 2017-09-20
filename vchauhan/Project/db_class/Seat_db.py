import sqlite3
#conn = sqlite3.connect('example.db')

print "Hello"

conn = sqlite3.connect('Seat.db')
c = conn.cursor()

c.execute('''CREATE TABLE Seat(Train_ID text, Train_Name text, Type_Of_Train text, Start_Station_ID text, Start_Station_Name text, Destination_Station_ID text, Destination_Station_Name text,Start_date,Seat_Class text, Seat_Status text, Seat_Number text)''')

c.execute("INSERT INTO Seat VALUES ('123', \
                                        'Rajdhani', \
                                        'Super-Fast', \
                                        'BLR', \
                                        'Bangalore', \
                                        'MBI', \
                                        'Mumbai', \
                                        '18th Sept 2017', \
                                        'General', \
                                        'Available', \
                                        'UB-15')")
c.execute("INSERT INTO Seat VALUES ( '123', \
                                        'Rajdhani', \
                                        'Super-Fast', \
                                        'BLR', \
                                        'Bangalore', \
                                        'MBI', \
                                        'Mumbai', \
                                        '18th Sept 2017', \
                                        'Sleeper', \
                                        'Waiting', \
                                        'WL-18')")
c.execute("INSERT INTO Seat VALUES ( '123', \
                                        'Rajdhani', \
                                        'Super-Fast', \
                                        'BLR', \
                                        'Bangalore', \
                                        'MBI', \
                                        'Mumbai', \
                                        '18th Sept 2017', \
                                        '3AC', \
                                        'Waiting', \
                                        'WL-01')")
c.execute("INSERT INTO Seat VALUES ( '123', \
                                        'Rajdhani', \
                                        'Super-Fast', \
                                        'BLR', \
                                        'Bangalore', \
                                        'MBI', \
                                        'Mumbai', \
                                        '18th Sept 2017', \
                                        '2AC', \
                                        'Waiting', \
                                        'WL-05')")
c.execute("INSERT INTO Seat VALUES ( '123', \
                                        'Rajdhani', \
                                        'Super-Fast', \
                                        'BLR', \
                                        'Bangalore', \
                                        'MBI', \
                                        'Mumbai', \
                                        '18th Sept 2017', \
                                        '1AC', \
                                        'Waiting', \
                                        'WL-07')")

conn.commit()
conn.close()
