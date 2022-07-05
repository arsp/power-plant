# power-plant
Code test

# Run the application
./gradlew bootRun

# Create the Battery List API
API URL : <HOST_NAME>/api/v1/power-plant/batteries

Request Payload sample: 
[
  {
    "name": "Cannington",
    "postcode": "6107",
    "capacity": 13500
  },
  {
    "name": "Midland",
    "postcode": "6057",
    "capacity": 50500
  }
]

# Get the Battery Details By Postcode Range API
API URL : <HOST_NAME>/api/v1/power-plant/postcode

Request Payload sample : 
{
	"from" : "5000",
	"to" : "6000"
}

