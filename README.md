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

Please refer snapshots in snapshots directory and down below

<img width="894" alt="Screen Shot 2565-08-22 at 13 59 48" src="https://user-images.githubusercontent.com/87823879/233625948-63c23a82-3b39-43fe-aa4d-859c5df37440.png">
<img width="708" alt="Screen Shot 2565-08-22 at 14 00 18" src="https://user-images.githubusercontent.com/87823879/233625953-e00b756d-d00f-4f36-83d3-8fa78537b024.png">
<img width="730" alt="Screen Shot 2565-08-22 at 14 14 40" src="https://user-images.githubusercontent.com/87823879/233625956-3e4f2a4e-0001-4062-bf3c-97f37860d1d9.png">
<img width="715" alt="Screen Shot 2565-08-22 at 15 39 58" src="https://user-images.githubusercontent.com/87823879/233625959-fbbe7676-4027-4cdd-b0a6-b70bbc3cba2d.png">
<img width="673" alt="Screen Shot 2565-08-22 at 15 42 15" src="https://user-images.githubusercontent.com/87823879/233625961-070c9c1a-c640-4583-a8fd-9e169d88db49.png">
<img width="811" alt="Screen Shot 2565-08-22 at 16 11 24" src="https://user-images.githubusercontent.com/87823879/233625963-cea5076a-382a-4cb7-8964-bedc8375bd6c.png">
