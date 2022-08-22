Trains API Routes Service
===========================

## Description
Build a restful API that does this:

Can add station pairs.
POST /station {"stations"": ["A", "B"], "time": 1, "cost": 5}

A,B,1,5
B,C,1,5
C,D,1,5
A,D,2,15


GET /station/A
-> {"routes": [{"stations"": ["A", "B"], "time": 1, "cost": 5}, {"stations"": ["A", "D"], "time": 2, "cost": 15}]}

GET /station/X
-> 404

GET /station/B
{"routes": [{"stations"": ["B", "C"], "time": 1, "cost": 5}, {"stations"": ["A", "B"], "time": 1, "cost": 5}]}

GET /stations
-> {"routes": [{"stations"": ["A", "B"], "time": 1, "cost": 5}, ..., ...]}

## Requirements
* Install java 8
* Install maven 3.1.1+
* Install IDE: IntelliJ have the most support, but you are free to use whatever you like.

## Building

#### From IDE (Intellij):

Open as a Maven project and compile.

#### From Command Line:

```
mvn clean install
```

## Running the Application

Run or debug the app with the ```TrainsServiceApplication``` main class at the root of your Java package hierarchy

Open a browser and visit [https://localhost:8080/](https://localhost:8080/) for Swagger documentation.

=====


## Snapshots

Please refer snapshots in snapshots directory.

