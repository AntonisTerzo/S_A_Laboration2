# **Laboration 2/3**
## This is the 2nd and 3rd exercise in the system architecture course
# **Docker instalation**
## 1. Pull the docker image:
###  docker pull tony300/wildfly-excercise3:latest
## 2. Run the container:
###   docker run -d -p 8080:8080 tony300/wildfly-excercise3:latest
## 3. Visit the URL:
###  http://localhost:8080/S_A_Laboration2-1.0-SNAPSHOT/products
# **API documentation**
# **1. Get all products**
## Description: Fetches all available products.
### Request URL: GET /products 
# Response:
###  Status Code: 200 OK
###  Content-Type: application/json
#  **2. Add a New Product**
##  Description: Adds a new product to the product list.
###  Request URL: POST /add-product
# Request Header:
###  Content-Type: application/json
#  Request body:
###  
{
  "id": "2",
  "name": "burger",
  "category": "FOOD",
  "rating": 10,
  "createdDate": "2024-10-03T11:59:00",
  "modifiedDate": "2024-10-03T11:59:00"
 }
# Response:
###  Status Code: 201 Created
### Status Code: 400 Bad Request
###  Content-Type: application/json
# **3. Get a Product by ID
## Description: Retrieve a specific product by its ID.
### Request URL: GET /products/{id}
# Response:
### Status Code: 200 OK
### Status Code: 404 Not Found
### Content-Type: application/json
# **4. Get All Products by Category
## Description: Retrieve all products under a specific category.
### Request URL: GET /products/categories/{category}
# Response:
### Status Code: 200 OK
### Status Code: 404 Not Found 
Content-Type: application/json
