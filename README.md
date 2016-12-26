### Disclaimer

To see all recent changes you should clone from the __dev__ branch! __master__ branch is kept clean from the source code.

### Required tools

* JDK 1.8
* maven 3.3.9
* MySQL database

### Database creation

Run `sql/migration.sql` from the root folder of the project.

### Run project

Run `mvn clean jetty:run -P frontend-build` from the command line.

### Build Docker image

Make build

`mvn clean install -P frontend-build`

Build a Docker image with command

`docker build -t restaurant .`

Then run it simply typing

`docker run -p 8080:8080 -it restaurant`




