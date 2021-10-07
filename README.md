# Assessment
To run project:
Run:
```./startup.sh```

To shutdown:
```./shutdown.sh```

To clean all docker images and eventually delete all volumes (if wanted):
```./cleanup.sh```

## Environment variables
Environment variables are configured in the .env file located in the project root.
Changing one value will propagate through and change in all depending services.

## How to use it
The "app" which is acts a frontend for the query service is located in   
http://localhost:8001

The Service with direct database access can be called with  
http://localhost:8002

Routes are:
* GET - http://localhost:8001/api/v1/calls - gets all logged calls
* POST - http://localhost:8001/api/v1/call - adds a new call to log

Example JSON for POST call:  
{  
    "message":"Hi!"  
}  
  
The message is omittable.
