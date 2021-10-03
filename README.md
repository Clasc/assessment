# Assessment
To run project:
Run:
```./startup.sh```

## Environment variables
Environment variables are configured in the .env file located in the root project root.
Changing one value will propagate through and change in all depending services.

## How to use it
The "app" which is like a frontend for the whole microservice architecture is located in 
http://localhost:8081

The Service with direct database access can be called with
http://localhost:8082

Routes are:
GET - http://localhost:8081/api/v1/calls - gets all logged calls
POST - http://localhost:8081/api/v1/call - adds a new call to log

Example JSON for POST call:
{
    message:"Hi!"
}

The message is omittable.