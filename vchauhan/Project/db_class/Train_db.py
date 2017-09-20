import sqlite3
#conn = sqlite3.connect('example.db')

print "Hello"

conn = sqlite3.connect('Train.db')
c = conn.cursor()
c.execute('''CREATE TABLE Trains (Train_ID text, Train_Name text, Start_Station_ID text, Start_Station_Name text, Destination_Station_ID text, Destination_Station_Name text, Type_Of_Train text, Seat_Class text, Rundays text, Start_date text, End_date text,  Total_distance text)''')

c.execute("INSERT INTO Trains VALUES ('123', \
                                      'Rajdhani', \
                                      'BLR', \
                                      'Bangalore', \
                                      'MBI', \
                                      'Mumbai', \
                                      'SuperFast', \
                                      '1AC,2AC,3AC,Slepper,General', \
                                      'Monday,Friday', \
                                      '18th Sept 2017', \
                                      '20th Sept 2017', \
                                      '501Km')")
									  
c.execute("INSERT INTO Trains VALUES ('321',\
                                      'Gareeb Rath', \
                                      'MBI', \
                                      'Mumbai', \
                                      'BLR', \
                                      'Bangalore', \
                                      'SuperFast', \
                                      '1AC,2AC,3AC,Slepper,General', \
                                      'Tuesday,Sunday', \
                                      '20th Sept 2017', \
                                      '24th Sept 2017', \
                                      '501Km')")

conn.commit()
conn.close()
