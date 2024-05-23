Title: TableReady - Digital Queue Management for Restaurants

Description (TODO):

Features (TODO):

Installation: (Provide instructions based on your chosen development stack) (TODO):

Configuration: (Outline configuration steps for restaurants) (TODO):

Usage: (Describe how customers and restaurant staff use the system) (TODO):

Additional Considerations:

Testing: Describe your testing strategy (to be added later).

Database:

Prerequisites:
 - Docker or PostgreSQL installed
 - If using docker, should have docker-compose available too.

Configuration:
 - run the container `docker-compose up -d` (change database password if needed on docker-compose.yaml file)
 - enter the container created with `docker exec -it CONTAINER_ID /bin/bash`
 - inside the container, you should enter the postgresql command line interface to create the database:
   - `psql -U postgres` (postgres is the name of the default user, because we did not specified one in docker-compose.yaml, change if necessary)
   - `create database tablereadylocal` (if you want a different name, change the application.properties too)