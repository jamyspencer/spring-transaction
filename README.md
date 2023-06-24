# README
### Design Considerations
* Minimal unit testing, but did unit test the only explicit requirement
* Fractional points allowed, in real-world would have asked for clarification on this point.
* Points are left as a computed field on the Purchase object. In real world this could create a versioning issue. Solution would be to update db with a points_version field populating existing items with 1. then update the entity to have the pointsVersion field and have a switch clause in the computed property...or refactor to use a service.
### Endpoints
| URL                                                | METHOD | BODY                                                | FUNCTION                                                                |
|----------------------------------------------------|--------|-----------------------------------------------------|-------------------------------------------------------------------------|
| localhost:8080/api/purchase                        | GET    | none                                                | Gets all purchases                                                      |
| localhost:8080/api/purchase/{id}                   | GET    | none                                                | Gets purchase with specific id                                          |
| localhost:8080/api/purchase/history/{months}       | GET    | none                                                | Gets all purchases in the  preceding number of months                   |
| localhost:8080/api/purchase/history/{months}/total | GET    | none                                                | Gets total points for all  purchases in the preceding  number of months |
| localhost:8080/api/purchase                        | POST   | {"amount":number,"purchaseDate":"MM/dd/yyyy"}       | Write a purchase                                                        |
| localhost:8080/api/purchase/bulk                   | POST   | [{"amount":number,"purchaseDate":"MM/dd/yyyy"},...] | Writes an array of purchases                                            |


### Running
* clone project
* ```
  mvn spring-boot:run
  ```
* ```
  curl -X POST 'localhost:8080/api/purchase/bulk/' \
  --header 'Content-Type: application/json' \
  --data '[
  {
  "amount": 122.00,
  "purchaseDate": "04/06/2023"
  },
  {
  "amount": 21.00,
  "purchaseDate": "05/09/2023"
  },
  {
  "amount": 77.00,
  "purchaseDate": "04/19/2023"
  },
  {
  "amount": 61.00,
  "purchaseDate": "04/13/2023"
  },
  {
  "amount": 21.00,
  "purchaseDate": "05/13/2023"
  },
  {
  "amount": 52.00,
  "purchaseDate": "04/18/2023"
  },
  {
  "amount": 81.00,
  "purchaseDate": "04/13/2023"
  },
  {
  "amount": 41.00,
  "purchaseDate": "05/13/2023"
  },
  {
  "amount": 66.22,
  "purchaseDate": "04/10/2023"
  },
  {
  "amount": 121.00,
  "purchaseDate": "04/11/2023"
  },
  {
  "amount": 45.00,
  "purchaseDate": "05/13/2023"
  },
  {
  "amount": 33.00,
  "purchaseDate": "04/11/2023"
  },
  {
  "amount": 41.00,
  "purchaseDate": "05/13/2022"
  },
  {
  "amount": 66.22,
  "purchaseDate": "01/10/2023"
  },
  {
  "amount": 41.00,
  "purchaseDate": "01/13/2023"
  },
  {
  "amount": 66.22,
  "purchaseDate": "02/10/2023"
  }
  ]'
  ```
* ```
  curl --location 'localhost:8080/api/purchase/history/3/total'
  ```
