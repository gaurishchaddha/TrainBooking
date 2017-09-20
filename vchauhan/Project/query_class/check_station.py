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
 
def select_task_by_id(conn, ID):
    """
    Query tasks by id
    :param conn: the Connection object
    :param id:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT * FROM Stations WHERE Start_Station_ID=?", (ID,))
 
    rows = cur.fetchall()
 
    for row in rows:
        print(row)

#-------------------------------------------
# Command line processing
#-------------------------------------------

USAGE = ('Usage: %prog[options] --StationID')

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

    return cmd_opts


def __set_options(parser):
    """Defines command line options."""

    parser.add_option('-S', '--StationID', type='string', dest='ID', metavar='STRING',
                     help='Enter the train ID to search')
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
    database = "/root/Desktop/vchauhan/Project/db_class/Station.db"
 
    # create a database connection
    conn = create_connection(database)
    with conn:
        if (cmd_opts.ID):
           print("Querying for Trains with Station_ID: %s" % (cmd_opts.ID))
           select_task_by_id(conn,cmd_opts.ID)
        else:
           print("Query all available trains in the station")
           select_all_tasks(conn)

 
 
if __name__ == '__main__':
    main()
