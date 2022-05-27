#Databases 2022 - Exam Project

**By**
* Martin Seest Holmqvist
* Nicholas Mathias Tureczek
* Patrick Picard Jønsson

# LINK TO VIDEO

## Table of Contents

## Introduction to our solution

Our project is revolving around music.\
Our vision was to create an application which can show a variety of lists and features, of all the popular songs from Spotify, based on their 
Top 200 lists from the last 10 years - along with a set of different features.

The data we use is collected from [Kaggle](https://www.kaggle.com/datasets/dhruvildave/spotify-charts), where they have a very large dataset, with approximately 21 mio songs.

These features include:
- Audio Features (Taken from the spotify api) -> [Spotify API](https://developer.spotify.com/documentation/web-api/)
- Lyrics (Scrapped from Genius.com) -> [Lyrics](https://www.genius.com)
- Collaborators (Also scrapped from Genius.com) -> [Collaborators](https://www.genius.com)

The data we use in the application is cleaned from different unused values, which includes:
- Duplicates (We just show the highest rank of a given songInfo)
- Other values we didn't know what to use for

We store the different information from the songs in different databases, to show our ability to use them, 
and make them work together in a single frontend application.

Our Application is built of Micro Services, which is set up to be registered with a Eureka Server.\
Through the Eureka Server, our API Gateway stores the information about the different endpoints of the Micro Services - and our frontend application uses the API Gateway to serve the data in a single web application.

### Static Architecture diagram

The following image presents a Static Architecture Diagram of our application.\
The diagram below shows the connection between our services, and how they are managed through the Eureka Server.
It also serves as an overview of the different Micro Services, and which databases we use for the different Services/Applications.

![StaticArchitectureDiagram.jpg](images/StaticArchitectureDiagram.jpg)

### Kafka

We are using Kafka for delivering messages to our Logger Service, in order to gather different data for the
administrators of the website.

The reason we use Kafka, is to eliminate any dependency the different Micro Services would have of each other - 
if we for example stored the data directly into a database, from each Micro Service.

Kafka eliminates these dependencies, because each Micro Service deliver messages through a Kafka Server. If a Service breaks down, it just won't deliver messages - but the rest of the services will still work normally.

The messages to Kafka includes:
- Creation of new users and music entries.
- Login
- Session data about time spend and number of endpoints viewed.
- And more..

Below is an overview of how Kafka handles the different messages between our Micro Services.

![Kafka Overview.jpg](images/Kafka-Overview.jpg)

## Overview of the different services:

<div style="text-align: center;">

|     Application     	| Port  	| Name                 	|
|:-------------------:	|-------	|----------------------	|
| Front End            	| 8080  	| DSDB-FrontEnd 	    |
| Gateway             	| 80      	| DSDB-Gateway      	|
| Users              	| 8081    	| DSDB-Users           	|
| Music             	| 8082  	| DSDB-Music        	|
| Audio Features       	| 8083  	| DSDB-AudioFeatures  	|
| Lyrics             	| 8084  	| DSDB-Lyrics         	|
| Collaborators        	| 8085  	| DSDB-Collaborators   	|
| Logger             	| 8086  	| DSDB-Logger       	|
| Eureka Server       	| 8761  	| DSDB-EurekaServer 	|
| Kafka Server        	| 9092  	| N/A                  	|

</div>


## Chosen technologies

Below we list the technologies we are using for this project.

|    Technology   	|                                                                                                                                                                                  Usage                                                                                                                                                                                  	|
|:---------------:	|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:	|
|  MongoDB Compass 	| MongoDB desktop application which we use to get a look into the tables of our MongoDB database.                                                                                                                                                                                                                                                                         	|
|   IntelliJ IDEA  	| Java development environment                                                                                                                                                                                                                                                                                                                                            	|
|       Kafka      	| Used as a message broker between many of our services. We have presented an overview diagram of our Kafka system in this README                                                                                                                                                                                                                                         	|
|   Netflix Eureka 	| Used as our Microservice register, keeping tabs on our different services, and how to reach them.                                                                                                                                                                                                                                                                       	|
|      Postman     	| Used to verify the API requests and response throughout the system. Additionally it is used to start the camunda flow.                                                                                                                                                                                                                                                  	|
|      DBeaver     	| DBeaver is a universal Database Handler, which is able to hold several different connections to various databases, and thus simplifying the DB management.                                                                                                                                                                                                               	|
|   Neo4J Desktop  	| Neo4j is a graph database which consists of nodes and relationships between these nodes.                                                                                                                                                                                                                	|

## Chosen databases

Below we are listing the databases we use in this project.

|  Databases |    Type   |                                                                                                                                 Usage                                                                                                                                | 
|:----------:|:---------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|   MongoDB  |  Document |                                             We use MongoDB to store Lyrics our songs, and the artist preforming the songInfo. besides that we use mongo to  store our log files, which can be accessed by the administrator.                                             | 
| PostgreSQL |    RDB    |                                                                                                       In PostgreSQL we are storing our users and the userInfo data.                                                                                                      | 
|    Redis   | in-memory |                                                                                           Redis is used as a cache calls to the database on top of our client application.                                                                                           |  
|    Neo4J   |   Graph   |                                      Neo4j is containing nodes with track name, with various relationships to the writers, producers, artists nodes.  These relationships is called [SANG], [COLLABORATED], [WROTE] and [FEATURED]                                     |  
|    MySQL   |    RDB    | MySQL is containing the audio features that matches the tracks. these features are Longs, which are the different attributes on  the songInfo, "Acousticness", "Dancability", "Energy", "Instrumentalness", "Liveness", "Loudness", "Speechiness", "Valance" and "Tempo" |  


<br>
<br>
<br>

***
## Micro Services

- Below we list the different Micro Services we are using, and a brief explanation of their responsibilities.

#### DSDB-Users
- This service is handling all transaction regarding users and makes sure the users' login credentials are correct in terms of password and username. 

#### DSDB-Music
- The DSDB-Music service is managing all calls to the MongoDB regarding the Track and artists related to the specific songInfo.

#### DSDB-AudioFeatures
- Here we are managing all transactions happening to and from the MySql database which contains all the Audio features.

#### DSDB-Lyrics
- As the name implies, the DSDB-Lyric is responsible for handling the transactions we are running to get the lyrics of the songs.

#### DSDB-Collaborators
- This microservice is making sure we can deliver the collaborators on the individual tracks for the songs we are presenting through our other microservices.

#### DSDB-Logger
- In DSDB-Logger, we are managing the log files which can be presented to the administrators if requested. 

#### DSDB-Gateway
- This is more or less an empty shell which works as a middle man between our Eurika server, and our client application. 

#### DSDB-FrontEnd
- DSDB_FrontEnd has the responsibility of presenting the graphical userInfo interface to the guest, userInfo or administrator using our program.

#### DSDB-EurekaServer

Netflix Eureka is our application that holds the information about all client-server applications.
All the microservices in this application are registered into our Eureka server and then our Eureka server knows which port our individual service is running on - this means that we can easily create and annotate a API Gateway, which then has access to all the different Micro Services' endpoints.

![](images/Eureka-Overview.png)

As shown above, we can access this information from our Eureka server, by going to our browser http://localhost:8761/ where we can get an overview of all the servers running, the names and on what port these services are running.
***
###BCrypt

Bcrypt is a password-hashing function based on the blowfish algorithm.

We are using this library to secure the passwords of our users, by making a one way hashing on the passwords.\
This means that when a userInfo is creating a password, it will be hashed - and can never be 'unhashed' again.\
By this way, we ensure that all users passwords remain a secret.

***
## Use Cases


***
## Database queries

### MongoDB
When getting lyrics from our MongoDB database, we sometimes want to get more than just a single lyric.
When this is the case, we are creating a list of id's and a function to return this.
The following is an example on how this works:

    var ids = [16,17];
    var lyric_ids = ids.map(function(id) { return id; });
    db.lyrics.find({songId: {$in: obj_ids}});

MongoDB's native tongue is JavaScript, which allows us to make variables like we have done in the 
previous example. 
Here the database returns the lyric which corresponds to the id's inserted in our list.


    db.log.find({$where: "this.date > 2022-05-20 && this.date < 2022-05-26 ",
    call: /READ/ })

The above query is used in our logging service, to find a specific call to our database. In this example, we are searching for 
all the "reads" from the database between 20th of May 2022 and the 26th of May 2022.

### Neo4j
First thing first, we have to populate our database. This is done by our web scraper to scrape web page "https://genius.com" for information
about the songs and collaborators on the songs. here we get writers, producers and featuring artists.
Hereafter we store these informations in a .csv file and load them into our Neo4j graph database with the apoc library.

    CALL apoc.load.csv('collaborators.csv')
    YIELD lineNo, map, list
    
    WHERE map.Feature IS NOT NULL
    MERGE (f:Person {name:map.Feature})
    MERGE (a:Person {name:"'''+ artist + '''"})
    MERGE (w:Person {name:map.Writer})
    MERGE (p:Person {name:map.Producer})
    MERGE (l:Label {name:map.Label})
    MERGE (s:Song {name:"'''+ track +'''", rank: "'''+ ranking + '''"})
    
    
    MERGE (f)-[:COLLABORATED]-(a)
    MERGE (f)-[:FEATURED]->(s)
    MERGE (a)-[:SANG]->(s)
    MERGE (w)-[:WROTE]->(s)
    MERGE (l)-[:RELEASED]->(s)
    MERGE (p)-[:PRODUCED]->(s);




When we look at our neo4j graph, we are interested in seeing who is working with whom, and what people are collaborating a lot.
First we are going to create our projection.

    CALL gds.graph.project.cypher(
        'artists',
        'MATCH (p:Person) RETURN id(p) AS id',
        'MATCH (p:Person)-[r:COLABORATED]->(m:Person) RETURN id(p) AS source, id(m) AS target')
    YIELD
        graphName AS graph, nodeQuery, nodeCount AS nodes, relationshipQuery, relationshipCount AS rels
This query will create our graph projection. and via the YIELD command return the following:
![img.png](images/Create_graph_projection.png)
 
We can also check all of our graph projections by using:

    CALL gds.graph.list()

After we've created our projection, we can take a look closer to our data in our database.

    CALL gds.degree.stream('artists')
    YIELD nodeId, score
    RETURN gds.util.asNode(nodeID).name AS name, score AS collaborators
    ORDER BY collaborators DESC, name DESC
This tells us who has been collaborator with most different people\
![img.png](images/Collaborated%20_out.png)

We can also see who is a popular person for others to collaborate with

    CALL gds.degree.stream(
        'artists',
        {orientation: 'REVERSE' }
    )
    YIELD nodeID, score
    RETURN gds.util.asNode(nodeId).name AS name, score AS collaborators
    ORDER BY collaborators DESC, name DESC

![img.png](images/collaborators_in.png)

We can see that "Drake" do almost have an equal amount of in and uot collaborators. The same is the case with "Young Thug",
but the placement on the list is different.

The following picture is showing the above two queries in a graph visualization:\
![img.png](images/collaborators_graph.png)

As can be seen "Young Thug" has 6 other artists who have collaborated with him, where "Young Thug" has collaborated with 5 other artist.


We can also see a triangle of what artist have collaborated the most. First we make a graph projection:

    CALL gds.graph.project(
    'Triangle',
    'Person',
    {COLLABORATED: {orientation: 'UNDIRECTED'}})

Then we are counting the numbers of triangles in our graph database:

    CALL gds.triangleCount.stream('Triangle')
    YIELD nodeId, triangleCount
    RETURN gds.util.asNode(nodeId).name AS name, triangleCount
    ORDER BY triangleCount DESC

This gives us the following overview:\
![img.png](images/Triangle_overview.png)

By using the "Triangle" graph projection, we can also see who is in the triangles:

    CALL gds.alpha.triangles('Triangle')
    YIELD nodeA, nodeB, nodeC
    RETURN
    gds.util.asNode(nodeA).name AS nodeA,
    gds.util.asNode(nodeB).name AS nodeB,
    gds.util.asNode(nodeC).name AS nodeC

![img.png](images/triangle_with_names.png)

As shown by the triangleCount, "Boef" has the most triangle connections. Hereafter we can see with whom.


### Redis

### PostgreSQL
