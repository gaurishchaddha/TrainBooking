import sqlite3
#conn = sqlite3.connect('example.db')

print "Hello"

conn = sqlite3.connect('Station.db')
c = conn.cursor()

c.execute('''CREATE TABLE Stations (Start_Station_ID text, Start_Station_Name text, Train_Name text, Train_DP_ID text)''')

c.execute("INSERT INTO Stations VALUES('BLR', \
                                        'Bangalore', \
                                        'Rajdhani', \
                                        '123')")
c.execute("INSERT INTO Stations VALUES('MBI', \
                                        'Mumbai', \
	                                'Gareeb Rath', \
                                        '321')")

conn.commit()
conn.close()
