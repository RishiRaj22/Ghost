# Welcome to Ghost, a remote PC JAVA servlet
[![Demo of the application](http://i3.ytimg.com/vi/qxdiHaoWSRw/hqdefault.jpg)](http://www.youtube.com/watch?v=qxdiHaoWSRw&t=5s)

This is Ghost, my (RishiRaj22's) first servlet. It was basically made for demonstrational purpose, and as a
fun project. It  can be used to control your P.C. using different devices. It's a fun way to begin your servlet journey. You can control your mouse, run applications, commands and take screenshot of your device from a connected client.

## Example use cases:

Do you want to look cool? Remotely run terminal commands and launch apps without touching your computer.

Do you want to just click a button without reaching for your mouse? Simply control it with your phone.

Do you want to check download status without peeking at your computer? Simply, capture screenshots of your computer and watch it from any device.

## Pre-Requisites:
```
1. Server software like Tomcat
2. JAVA EE compiler or IDE
3. (OPTIONAL) Database management software like MySQL
```

## Setup:
Clone this repository using: 
```
git clone https://github.com/RishiRaj22/Ghost.git
```
Now add it to your IDE of choice like Eclipse supporting Java EE and make sure you have some server like Tomcat.

All the functionalities will run independent of your configuration.

The class raj.rishi.ghost.backend.AddItems is optional, you can use it as a template to support
connection to a database or any other data source that contains information about the apps, commands
needed to launch the app, it's icon, name, etc.
The provided demo raj.rishi.ghost.backend.AddItems uses a MySQL database.
On similar lines, the database table used to show icons in a table could have structure similar to the demo:

| Serial No.    | Name        |Datatype |
| ------------- |:-------------:| -----:|
| 1     | Precedence| int |
| 2    | Name      | varchar |
| 3 | Command     | varchar |
| 4 | Image URL     | varchar |

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

Feel free to clone, fork and raise any bugs or contribute to this project.
