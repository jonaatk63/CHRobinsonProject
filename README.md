# North America Route API

Returns a list of countries a truck must drive through to get from the USA to the country that you 
choose within North America.

#Live: https://jonah-country-api.onrender.com/{countryCode}
- It is hosted on Render's free tier
- So the first request after inactivity might take about a minute for the app to wake up


#Using the app

It is a simple GET endpoint receiving a country code

Example:

https://jonah-country-api.onrender.com/PAN returns:
["USA", "MEX", "GTM", "HND", "NIC", "CRI", "PAN"]

codes: CAN, USA, MEX, BLZ, GTM, SLV, HND, NIC, CRI, PAN

##Stack
- Java 21, Spring Boot 4, Gradle
- Docker file, deployed on render

##Run Locally
./gradlew bootRun
open http://localhost:8080/{countryCode}

##Design
- Simple Controller and Service dependency injection interaction
- Hash Map: the routes are pre entered into a hash map since the data set is small and does not change
- If the data set would for some reason grow I would probably use Breadth-first-search to search each level finding neighbors
- The hosting: I tried Microsoft Azure at first but the free student subscription would not allow me to deploy a web app,
- so I asked Claude Code and it suggested a Dockerfile while deploying on render. 


