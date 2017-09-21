# chatroom
Sample app with spring boot<br />
<br />
To build the project cd to project dir and run below command<br />
mvn clean compile package install -Dmaven.test.skip=true -P pro<br />

To build the project after first build you can use below command<br />
mvn clean compile package install -o -Dmaven.test.skip=true -P pro<br />

<br />
to call load method use below curl command:<br />
curl "http://localhost:8081/chatroom/message/load/0"<br />
<br />
to call save method use below curl command:<br />
curl "http://localhost:8081/chatroom/message/save/1392/yes"<br />
<br />
to ssh to spring boot shell use below command and give him the spring boot password:<br />
ssh user@localhost -p 2000<br />
<br />
For installation cp target/gs-spring-boot-distribution.dir/* to your server and afterward run start.bat file.