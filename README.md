# chatroom
Sample app with spring boot

To build the project cd to project dir and run below command
mvn clean compile package install -o -Dmaven.test.skip=true -P pro

to call load method use below curl command:
curl "http://localhost:8081/chatroom/message/load/0"

to call save method use below curl command:
curl "http://localhost:8081/chatroom/message/save/1392/yes"

to ssh to spring boot shell use below command and give him the spring boot password:
ssh user@localhost -p 2000

