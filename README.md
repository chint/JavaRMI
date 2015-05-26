# JavaRMI-Java RMI Chat Server-

How to execute.
Server
1. Go to in ChatServer/bin
2. Start rmiregistry in ChatServer/bin/ using command prompt command “start rmiregistry”.
3. Run Server using command prompt command “java Server” at /bin folder. 
4. Enter an USER ID for the server (default- SERVER).
5. Enter a HOST for the server (default- localhost).

Client
1. Go to in ChatClient /bin
2. Start server using above steps.
3. Start a client using command prompt command “java Server” at ChatClient/bin/, any number of                                                          clients can be launched. 
4. Enter an USER ID for the client (default- default client).
5. Enter a HOST for connecting (default- localhost).

Above operations also can be performed using Eclipse. Projects ChatServer and ChatClient needs to be imported to eclipse and compiled.
Before starting the server “rmiregistry” must be running at the ChatServer/bin. (See Sever 2.)
 Running ChatServer->Server.java will start the server. Clients can be started by running ChatClient->Client.java. 
