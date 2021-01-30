# Webchat

Webchat is a java project for communication in a private network or internet + public server relay. 

### Installation
Webchat is using [Java 11 JDK](https://www.oracle.com/fr/java/technologies/javase-jdk11-downloads.html), we recommend you using this version to prevent any bug in execution.

Webchat is using [Maven](https://maven.apache.org/download.cgi) to generate java class and jar file.

Tested and developed under Linux Ubuntu 16. We highly recommend to use Linux to prevent unknow bugs.

You can see installation procedure on ##Manual.pdf

### KNOW-BUG

- if you close a chat session jframe (from server side), if you reopen the same chat session the jframe will completely bug and nothing will be printed, even is message is receved.
Solution : restart application

- Similar to the previous bug (jframe problem), if a person A contact B, then a person C contact B, the message from C will not pop up on the jframe created for the chat session (B-C) and will go on the chat session for (A-B). The first JFrame is taking all the content, the others jframes will not get any informations. 
Solution : No solution found 

### Security Warning
This project is unsecure, do not use it in critical environnement. Many attacks is possible (Man in the middle message modification, command injection via upload functionality, password modification via hash replace , etc...)
