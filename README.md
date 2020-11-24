# Introduction
Welcome to Telephone project. This project demonstrates how to use a contact service to save and search contacts.
it includes ContactService which is the main service.
# Software needed
1.	Apache Maven (http://maven.apache.org).
2.	Docker (http://docker.com). 
3.	Git Client (http://git-scm.com).

# How to call the slow third party api (Github public repository names of a user)
the best way is to use Event-Driven Programming. between different Paradigms of Event-Driven Programming
The best way is using Message broker like Apache kafka. But for simplicity I use reactive (Spring Flux).
in ContactRestTemplateClient class I used WebClient instead of RestTemplate
to provide Asynchronous request to github api, so when the response is ready it will be saved in the database.

# Running application
You can run service by maven command spring-boot:run


# Building the Docker Images
To build the code for project as a docker image, open a command-line window

Run the following maven command.  This command will execute the [Spotify docker plugin](https://github.com/spotify/docker-maven-plugin) defined in the pom.xml file.  

   **mvn clean package docker:build**

If everything builds successfully you should see a message indicating that the build was successful.

# Running the Application by docker-compose

Now we are going to use docker-compose to start the actual image.  To start the docker image,
change to the directory containing  your project source code.  Issue the following docker-compose command:

   **docker-compose -f docker/common/docker-compose.yml up**

If everything starts correctly you should see a bunch of spring boot information fly by on standard out.  
At this point ContactService will be running.
