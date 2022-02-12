# Bricoly : Engineer Your Life The Way It Should Be...

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Bricoly-Icon.png?token=GHSAT0AAAAAABQA32QBVCMLGDZDQNEBXNDGYQQNT4Q" width="auto" height="160" />
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/Bricoly.png?token=GHSAT0AAAAAABQA32QBP6YP6LUPO6QK2TSAYQQNUHQ" width="auto" height="140" />
</p>

## Description

This project's aims to connect people who are able to grant services with clients who may need them. This was done in the context of our federator project in Ensias. You can check the report [here](https://github.com/Ignema/Bricoly/blob/master/res/Report.pdf).

## Instructions

The first thing we need to do is clone the repository and get the code:

    git clone https://github.com/Ignema/Bricoly.git

### Running the code locally from source

There are four things that need to be running in order to execute the whole application.

- **Postgres Database** (Make sure you edit *application.properties* with the right credentials so that the backend can detect your database)
- **JDK 17** (An IDE like intellij or eclipse will do the work automatically for you)
   
        # Windows
        gradlew bootRun
        # Linux
        ./gradlew bootRun
- **Node**

        npm install

- **Angular-CLI**
        
        npm install -g @angular/cli 
        ng serve --open

### Running the project with containers

If you want to run the containers seperately then you can pull them independently from docker hub like so
    
    # Frontend
    docker pull ignema/bricoly/frontend:1.0

    # Backend
    docker pull ignema/bricoly/backend:1.0

    # Don't forget to run a postgres container as well!!!

If you want to run the cluster at once, you can simply run this command

    docker-compose -p bricoly up

## Database Schema

<p align="center">
<img src="https://raw.githubusercontent.com/Ignema/Bricoly/master/res/SQL/schema.png?token=GHSAT0AAAAAABQA32QBVENAZ6O25U3TLXR6YQQNSZA" />
</p>

## App Overview

TODO: Add screens and stuff