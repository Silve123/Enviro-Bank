# Enviro-Bank

## Running the Application
To run the application, execute `MainClass.java`.

## Endpoints

### Get Single Investor's Information
To retrieve information about a single investor using their name, make a GET request to:
```http
http://localhost:5555/users/{UserName}
```

### Get List of All Products an Investor Has Invested In
To get a list of all products the investor has invested in, make a GET request to:

```http
http://localhost:5555/investments/user/{userId}
```

### Create a Withdrawal Notice
To create a withdrawal notice, make a POST request to:

```http
http://localhost:5555/withdrawal-notices/create
```
Include the following parameters in the request body:
```http
productId
withdrawalAmount
```
#### Examples:
```http
curl -X POST -d "productId=1&withdrawalAmount=50000" http://localhost:5555/withdrawal-notices/create
```
You should receive a response indicating that the withdrawal amount exceeds 90% of the current balance.
```http
curl -X POST -d "productId=5&withdrawalAmount=50000" http://localhost:5555/withdrawal-notices/create
```
You should receive a response indicating that the investor's age must be greater than 65 for a RETIREMENT product.

#### Finally to create a Withdrawal Notice
```http
curl -X POST -d "productId=1&withdrawalAmount=20000" http://localhost:5555/withdrawal-notices/create
```

### Visualize Withdrawal Notices

To visualize withdrawal notices after creation, visit:
```http
http://localhost:5555/withdrawal-notices/all
```