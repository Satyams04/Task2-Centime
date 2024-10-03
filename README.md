# Task2-MicroservicesAndHibernate

## Service Description and And Intergration with Hibernate 
1. Used In-memory DB "H2" to integrate with the microservice
2. Exposed POST method endpoint to populate DB with the given table data ---> http://localhost:8080/api/gameCharacters/create
3. Exposed GET method endpoint to fetch requests based on Id ---> http://localhost:8080/api/gameCharacters/getById/{id}.
4. Exposed GET method endpoint to fetch complete list of objects ---> http://localhost:8080/api/gameCharacters/getAll.
5. Exposed GET method endpoint to fetch complete list of objects using nested(parent-child relation) strucutre noutput ---> http://localhost:8080/api/gameCharacters/getNestedCharacters.
6. Used MAP data structure to form the relationship after fetching the list from db, in an efficient way with O(n) Time Complexity.
7. Created a method level Annotation @LogMethodParam which logs parameters passed to method (creategameCharacter, getNestedGameCharacters()).
8. Created one Database Initializer Class to populate Game Characters table data to get executed while running the application to test Nested data.
9.Created GameCharacter Entity and added the required fields to auto create tables in hosted db (h2 console ---> http://localhost:8080/h2-console)
