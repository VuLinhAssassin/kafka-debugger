# Introduction

This application is meant for sending Kafka message via a graphical user interface, as well as by using exposed controller to do so (read: using Postman or something).

# How to Send Kafka Message

## Via graphical user interface
Just use the goddamn interface, specify the topic name and kafka message, and press "**Send Message!**".

Isn't it a bit too easy?

## Via Sending Request
By default, the application will run at port 32767 in your local machine (don't ask me why I chose that port number, because I want it that way! No Backstreet Boys pun intended, obviously, it is not like I tell you that or anything). So it will be `http://localhost:32767`.

~~Okay, here is your pun: https://www.youtube.com/watch?v=4fndeDfaWCg~~

The request information is as follow:
- Request path: /kafka-message/send
- Request method: POST
- Request parameter(s):
  - `topic`: The kafka topic name. If this parameter is not specified, the default topic debug will be used.
- Request body: A string. Can be anything, but I would recommend using JSON string. I don't care what you send, but for debugging purpose in your project, send a parsable JSON, or if you want to troll people, send anything you want, be it junk text or your own will.

# Advance Arguments

## Spring Arguments
Spring arguments are used to manipulate anything that is specified in the project `application.yaml`. For example, to change server port from default **32767** to **6969** ~~(you naughty litle one)~~, just add `--server.port=6969` argument and be done with it.

## Additional Arguments
I made an argument to tell the app to set your interface's look and feel to "Windows". Just add `Windows-Look-And-Feel` argument and you will see the difference. Well, this will not work on Linux or anything that is not Windows, or does not have Windows Look and Feel library. I like Windows, so I made Windows Look and Feel.

## Example

### Run the "packed" application
"Packed" here means you run the app directly with the .jar file. It can be found on your project's target folder after you execute maven `clean install` goal. This application is meant for testers who have no knowledge about Java programming ~~but intelligent enough to understand what is Kafka topic and Kafka message, duh~~.

If you want to use Windows Look and Feel, use this command (in Command Prompt or Windows PowerShell, I don't know about Linux or anything non-Windows):

```java -jar YourDumbAppNameHere.jar Windows-Look-And-Feel```

***

If you want to change the server port from **32767** to something you like, use this command:

```java -jar YourDumbAppNameHere.jar --server.port=6969```

And of course, 6969 is the new server port. ~~FBI should be knocking your door any minute now...~~

***

To specify the Kafka bootstrap servers (your organization's kafka bootstrap servers, for example), use this:

```java -jar YourDumbAppNameHere.jar --app.kafka.bootstrap-servers=192.168.0.69:9092,192.168.0.96:9092```

Bootstrap servers are separated by comma character.
***

And finally, words of wisdom:

>Replace `YourDumbAppNameHere` with the jar file name, obviously! That `Windows-Look-And-Feel` can be put anywhere in your command arguments, as long as those goddamn things are separated by space character.

### Use batch files

Those command can be put into batch files if you intend on using them frequently.

Add `@echo off` at the beginning of your batch file to not let the Command Prompt Windows display the command line when running.
