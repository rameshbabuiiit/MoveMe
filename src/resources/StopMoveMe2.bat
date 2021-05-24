wmic process where "COMMANDLINE like '%%MoveMe.jar%%'" CALL TERMINATE
PAUSE