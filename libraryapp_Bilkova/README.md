# Library App

## to run
```docker-compose up```

it runs on localhost:8080

## endpoints
all books 
```GET /books```

all available books
```GET /books/available```

all unavailable books
```GET /books/unavailable```

to borrow book 
```POST body(name of book) /books/borrow```

to return book
```POST body(name of book) /books/return```