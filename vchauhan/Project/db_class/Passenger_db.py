import sqlite3
#conn = sqlite3.connect('example.db')

print "Hello"

conn = sqlite3.connect('Passenger.db')
c = conn.cursor()

c.execute('''CREATE TABLE Passenger(Book_Flag text, Passenger_Name text, Passenger_Age integer, Booking text, PNR_Number text)''')

c.execute("INSERT INTO Passenger VALUES ('True', \
                                        'XYX', \
                                        '29', \
                                        'Completed', \
                                        'PNR-XYZ-29-Done')")
conn.commit()
conn.close()
