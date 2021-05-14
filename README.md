# flexberry-gis-java-odata-backend
An example of building a web service for accessing data (PostgresSQL) using the OData protocol using olingo-odata4 and olingo-jpa-processor-v4.

# Build and run
docker-compose build && docker-compose up

# Query examples

## Metadata:
**GET** http://localhost:8080/SampleService/SampleService.svc/$metadata

## Entity metadata:
**GET** http://localhost:8080/SampleService/SampleService.svc/$metadata#Maps

## Create entity:
**POST** http://localhost:8080/SampleService/SampleService.svc/Maps
{
    "Primarykey":"684AB811-DFEA-4488-98A9-1595C21CA930",
    "Name" : "Test entity"
}

## Modify entity:
**PATCH** http://localhost:8080/SampleService/SampleService.svc/Maps(684ab811-dfea-4488-98a9-1595c21ca930)
{
    "Name" : "Another test",
    "Ispublic":false
}

## Entity data:
**GET** http://localhost:8080/SampleService/SampleService.svc/Maps(684ab811-dfea-4488-98a9-1595c21ca930)

## Delete entity:
**DELETE** http://localhost:8080/SampleService/SampleService.svc/Maps(684ab811-dfea-4488-98a9-1595c21ca930)

## Get linked enitties:
**GET** http://localhost:8080/SampleService/SampleService.svc/MapLayers(262930cd-2898-4c96-bb17-bc42fcd9efe0)/Map/Layers

## Get filtered enitties:
**GET** http://localhost:8080/SampleService/SampleService.svc/MapLayers?$filter=Map/Name eq 'Карта объектов АИП'

