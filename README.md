#Determine if two cities are connected - SpringBoot Application

#Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.
#List of Roads are:

Boston, New York
Philadelphia, Newark
Newark, Boston
Trenton, Albany

#Steps to populate the city.txt file into the application and use its content:

1) Add city.txt in the Resources folder of your application.

2) Provide its absolute path inside the body of "connected" method of CityController class where "readCityConnections" method of CityService class is being called.


#Steps to run the application:

1) After populating the city.txt file, hit this API : http://localhost:8080/connected?origin=city1&destination=city2

2) Replace city1 and city2 with any of the city names.

3) If the cities are connected, the API will return "yes" otherwise it will return "no".

#Test Cases:

Please find the test cases inside src/test/java package in the application.