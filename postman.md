# Gateway Service

## Enpoints

### Sign up:
````
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:9040
Content-Type: application/json
Content-Length: 85

{
    "username": "testnemae",
    "password": "test123",
    "name": "testman"
}
````

### Sign in:
````
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:9040
Content-Type: application/json
Content-Length: 61

{
    "username": "testnemae",
    "password": "test123"
}
````