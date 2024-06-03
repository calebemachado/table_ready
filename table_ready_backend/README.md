Title: TableReady - Digital Queue Management for Restaurants

Description:   
TableReady is a digital queue management system for restaurants, designed to enhance customer experience
and streamline restaurant workflows. With TableReady, customers can join the queue digitally and receive
real-time updates on their status, reducing the need for physical waiting areas and improving overall efficiency.

Features:
- Digital Queue Management: Customers can join the queue remotely via a web interface.
- Real-Time Updates: Customers receive notifications about their queue status,
  estimated wait times, and when their table is ready.
- Admin Dashboard: Restaurant staff can manage the queue, add or remove customers,
  and monitor queue metrics from an intuitive dashboard.

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