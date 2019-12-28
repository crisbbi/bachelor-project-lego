# bachelor-project-lego
A university project to control a LEGO bucket wheel excavator over WiFi using a laptop or Android tablet.

This project was part of a university course from 02.04.2019 to 29.10.2019, called "Bachelor Projekt", at the University of Lübeck. It was guided by Dipl.-Inform. Klaus-Dieter Schumacher and is published here with his permission.

The project goal was to modify a LEGO bucket wheel excavator (model 42055) such that it could be controlled over WiFi, using a laptop (Windows/Linux) or an Android tablet (Android 5). As a group of six students it was our task to implement the following features:
- Driving forward/backward
- Turn right/left
- Use the bucket wheel + assembly line
- Lift up/Lower the bucket wheel
- Rotate the arm clockwise/anti-clockwise (from a bird view perspective)
- Rotate the assembly line clockwise/anti-clockwise (from a bird view perspective)
- Turn on LEDs with white color
- Stop the excavator in emergency case, white LEDs blink red
- Driving backwards, the LEDs blink orange and a little speaker simulates a "beep" sound
- Control the bucket wheel excavator with speech recognition
- Live stream from a camera mounted on the top of the excavator

The project had the following requirements:
- Use Java (as much as possible)
- Run on Windows and Linux
- Run as an app on a provided tablet with Android 5

In general, a Client-Server architecture is used to establish the connection between a client laptop or tablet and a Raspberry Pi as the server. Using Multicast on the WiFi network, the client is able to automatically connect to the server, as long as **both are on the same WiFi and unless the network settings hinder the Multicast**. 

The Android App tries to find the server by polling every second on a specified Multicast adress. Once it finds a server, it connects with the discovered IP. As long as no connection is established, the app shows a placeholder image. As soon as it is conneected, the network thread notifies the UI, whichs calls the camera stream as an internal browser using the new given IP adress. A button click on the UI triggers the network thead, which then sends the appropriate command to the server.  
