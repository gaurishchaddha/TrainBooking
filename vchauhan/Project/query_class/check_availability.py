import os
import sys

import optparse

import sqlite3
from sqlite3 import Error
 
 
def create_connection(db_file):
    """ create a database connection to the SQLite database
        specified by the db_file
    :param db_file: database file
    :return: Connection object or None
    """
    try:
        conn = sqlite3.connect(db_file)
        return conn
    except Error as e:
        print(e)
 
    return None
 
 
def select_all_tasks(conn):
    """
    Query all rows in the tasks table
    :param conn: the Connection object
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT * FROM Stations")
 
    rows = cur.fetchall()
 
    for row in rows:
        print(row)
 
def select_task_by_id(conn, ID, Class):
    """
    Query tasks by id
    :param conn: the Connection object
    :param id:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT * FROM Seat WHERE Train_ID=? AND Seat_Class=? OR Seat_Status=?", (ID,Class,'Available'))
 
    rows = cur.fetchall()
 
    for row in rows:
        print(row)

def select_task_by_Station(conn, start, Dest, ID, Class):
    """
    Query tasks by id
    :param conn: the Connection object
    :param id:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT * FROM Seat WHERE Start_Station_ID=? AND Destination_Station_ID=? AND Train_ID=? AND Seat_Class=? OR Seat_Status=?", (start,Dest,ID,Class,'Available'))

    rows = cur.fetchall()

    for row in rows:
        print(row)

def select_task_by_Date(conn, start, Dest, ID, Class, Date):
    """
    Query tasks by id
    :param conn: the Connection object
    :param id:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT * FROM Seat WHERE Start_Station_ID=? AND Destination_Station_ID=? AND Train_ID=? AND Seat_Class=? AND Start_date=? OR Seat_Status=?", (start,Dest,ID,Class,Date,'Available'))

    rows = cur.fetchall()

    for row in rows:
        print(row)


#-------------------------------------------
# Command line processing
#-------------------------------------------

USAGE = ('Usage: %prog[options] --SeatClass & --TrainID')

def __process_args():
    """Process command line arguments and return opts dict."""

    print(sys.argv)
    parser = optparse.OptionParser(description=__doc__, usage=USAGE)
    __set_options(parser)
    (cmd_opts, args) = parser.parse_args()

    # Check for extra arguments.
    if len(args):
        msg = 'ERROR: Invalid argument(s): %s' % ' '.join(args)
        __usage(exit_val=1, msg=msg, parser=parser)

    if not cmd_opts.SeatClass:
        __usage(exit_val=1, msg='ERROR: Missing --SeatClass option.', parser=parser)

    if cmd_opts.StartID:
       if not cmd_opts.DestinationID:
         __usage(exit_val=1, msg='ERROR: Missing --DestinationID option.', parser=parser)

    if not cmd_opts.TrainID:
       __usage(exit_val=1, msg='ERROR: Missing --TrainID option.', parser=parser)

    return cmd_opts


def __set_options(parser):
    """Defines command line options."""

    parser.add_option('-C', '--SeatClass', type='string', dest='SeatClass', metavar='STRING',
                     help='Enter the Seat Class to search')

    parser.add_option('-T', '--TrainID', type='string', dest='TrainID', metavar='STRING',
                     help='Enter the train ID to search')

    parser.add_option('-s', '--StartID', type='string', dest='StartID', metavar='STRING',
                     help='Enter the Start Station ID to search')

    parser.add_option('-d', '--DestinationID', type='string', dest='DestinationID', metavar='STRING',
                     help='Enter the Destination Station ID to search')

    parser.add_option('-D', '--Date', type='string', dest='Date', metavar='STRING',
                     help='Enter the Date of travel to search')
#-----------------------------------------------------------------------------
# USAGE Defination
#-----------------------------------------------------------------------------

def __usage(exit_val=0, msg='', parser=None):
    """
    Print usage and exit.

    Print program usage information followed by an additional optional message
    then exit with the given (or default) exit value.
    """
    if parser:
        # Full usage.
        parser.print_help()
    else:
        # Abbreviated usage.
        print(USAGE)
    if msg:
        print(os.linesep, msg)
    sys.exit(exit_val)

def main():

    """Main Function where it all starts"""
    cmd_opts = __process_args()
    database = "/root/Desktop/vchauhan/Project/db_class/Seat.db"
 
    # create a database connection
    conn = create_connection(database)
    with conn:
        if (cmd_opts.SeatClass and cmd_opts.TrainID and cmd_opts.StartID and cmd_opts.DestinationID and cmd_opts.Date):
           print("Quering for Seats Availability in Train %s for SeatClass : %s from station %s to %s on Date - %s" %(cmd_opts.TrainID,cmd_opts.SeatClass,cmd_opts.StartID,cmd_opts.DestinationID,cmd_opts.Date))
           select_task_by_Date(conn,cmd_opts.StartID,cmd_opts.DestinationID,cmd_opts.TrainID,cmd_opts.SeatClass,cmd_opts.Date)
        elif (cmd_opts.SeatClass and cmd_opts.TrainID and cmd_opts.StartID and cmd_opts.DestinationID):
           print("Quering for Seats Availability in Train %s for SeatClass : %s from station %s to %s" %(cmd_opts.TrainID,cmd_opts.SeatClass,cmd_opts.StartID,cmd_opts.DestinationID))
           select_task_by_Station(conn,cmd_opts.StartID,cmd_opts.DestinationID,cmd_opts.TrainID,cmd_opts.SeatClass)
        elif (cmd_opts.SeatClass and cmd_opts.TrainID):
           print("Querying for Seats Availability in Train %s for SeatClass : %s" % (cmd_opts.TrainID,cmd_opts.SeatClass))
           select_task_by_id(conn,cmd_opts.TrainID,cmd_opts.SeatClass)
 
 
if __name__ == '__main__':
    main()
