# Example of hexagonal architecture

This repository is a simple example about how we can configure a project following DDD practices.

This project is a rest api to get/create customers and store his data in a mongoDB.

Stack:

* Spring boot
* MongoDB
* lombock
* Mapstruct
* Mockito

## Run the project in local

```bash
➜ docker-compose up
```

## Endpoints

### Create a consumer
#### Request

```bash
curl --location --request POST 'localhost:8080/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name": "Alejandro",
	"surnames": "Mateo",
	"dob": "2020-09-26"
}'
```

#### Response

```json
{
  "id": "6211dd736e399e2e673cad0d"
}
```

### Get a consumer

#### Request

```bash
curl --location --request GET 'localhost:8080/customer/6211dd736e399e2e673cad0d'
```

#### Response

```json
{
  "id": "6211dd736e399e2e673cad0d",
  "name": "Alejandro",
  "surnames": "Mateo",
  "dob": "2020-09-26"
}
```