#Welcome to Ghost, a remote PC JAVA servlet
[![Demo of the application](http://i3.ytimg.com/vi/qxdiHaoWSRw/hqdefault.jpg)](http://www.youtube.com/watch?v=qxdiHaoWSRw&t=5s)

This is Ghost, my(RishiRaj22 's) first servlet. It was basically made for demonstrational purpose, and as a
fun project. It  can be used to control your P.C. using different devices. It's a fun way to begin your servlet journey. You can run any application and take screenshot of your device from a connected client.

##Example use cases:

Wanna look cool? Remotely run terminal commands and launch apps without touching your computer.
Wanna check download status without peeking at your computer? Simply,Capture screenshots of your computer and watch it from any device.

##Pre-Requisites:
```
1. Server software like Tomcat
2. Database management software like MySQL
3. JAVA EE compiler or IDE
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
