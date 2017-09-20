import sqlite3
#conn = sqlite3.connect('example.db')
## BLR --> YSP --> GOA --> LON --> PNE --> MBI

print "Hello"

conn = sqlite3.connect('Route.db')
c = conn.cursor()

c.execute('''CREATE TABLE Route(Train_ID text, Train_Name text, Stop_Index integer,Day integer,Current_Station_ID text,Current_Station_Name text,Arival_Date text,Arival_Time text,Previous_Station_ID text,Previous_Station_Name text,Next_Station_ID text,Next_Station_Name text,Departure_Date text,Departure_Time text,Distance_from_Start integer)''')


c.execute("INSERT INTO Route VALUES ('123', \
                                        'Rajdhani', \
                                        '1', \
                                        '1', \
                                        'YSP', \
                                        'Yaswanthpur', \
                                        '18th Sept 2017', \
                                        '8:00 PM', \
                                        'BLR', \
                                        'Bangalore', \
                                        'GOA', \
                                        'Goa', \
                                        '18th Sept 2017', \
                                        '8:30 PM', \
                                        '70 Km')")

c.execute("INSERT INTO Route VALUES ('123', \
                                        'Rajdhani', \
                                        '2', \
                                        '2', \
                                        'GOA', \
                                        'Goa', \
                                        '19th Sept 2017', \
                                        '8:00 PM', \
                                        'YSP', \
                                        'Yaswanthpur', \
                                        'LON', \
                                        'Lonawla', \
                                        '20th Sept 2017', \
                                        '8:30 AM', \
                                        '270 Km')")

c.execute("INSERT INTO Route VALUES ('123', \
                                        'Rajdhani', \
                                        '3', \
                                        '3', \
                                        'LON', \
                                        'Lonawla', \
                                        '20th Sept 2017', \
                                        '8:00 PM', \
                                        'GOA', \
                                        'Goa', \
                                        'PNE', \
                                        'Pune', \
                                        '20th Sept 2017', \
                                        '8:30 PM', \
                                        '370 Km')")

c.execute("INSERT INTO Route VALUES ('123', \
                                        'Rajdhani', \
                                        '4', \
                                        '3', \
                                        'PNE', \
                                        'Pune', \
                                        '20th Sept 2017', \
                                        '11:00 PM', \
                                        'LON', \
                                        'Lonawla', \
                                        'MBI', \
                                        'Mumbai', \
                                        '20th Sept 2017', \
                                        '8:30 PM', \
                                        '470 Km')")

conn.commit()
conn.close()
