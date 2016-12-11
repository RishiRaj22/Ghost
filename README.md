#Welcome to Ghost, a remote PC JAVA servlet
[![Demo of the application](http://i3.ytimg.com/vi/qxdiHaoWSRw/hqdefault.jpg)](http://www.youtube.com/watch?v=qxdiHaoWSRw&t=5s)

This is Ghost, my(RishiRaj22 's) first servlet. It was basically made for demonstrational purpose, and as a
fun project. It  can be used to control your P.C. using different devices. It's a fun way to begin your servlet journey. You can run any application and take screenshot of your device from a connected client. 
##Example use cases:
1. Remotely launch apps
2. Remotely run scripts
3. Capture screenshots at a high quality instantaneously.

##Pre-Requisites:
```
Server software like Tomcat
Database management software like MySQL
JAVA EE compiler or IDE
```
##Setup:
Clone this repository using: 
```
git clone https://github.com/RishiRaj22/Ghost.git
```
Now add it to your IDE of choice like Eclipse supporting Java EE and make sure you have some server like Tomcat, database like MySQL.
All the functionalities will run independent of your configuration.
However edit raj.rishi.ghost.backend.AddItems to support your database.
The database should have the following items in the ***EXACT ORDER***
```
1. Precedence or Serial No.
2. Name
3. Command (Primary Key)
4. Image URL
Any other additional columns
```

Feel free to clone and fork.
