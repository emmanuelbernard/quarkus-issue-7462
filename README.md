# Reproducer for 7462

I actually can't reproduce.
I built quarkus master

    cd quarkus
    ./mvnw clean install -DskipTests

Then on this project

    cd banner-test
    ./mvnw quarkus:dev

Then hit the following URL

http://localhost:8080/greeting/init
for the initial object creation

http://localhost:8080/greeting/second
for the read only showing no version increment

http://localhost:8080/greeting/third
showing how the version increment upon changes
