# GraphQL example

## Run application
```shell
gradle bootRun
```
## Links:
[Graph iQL](http://localhost:8080/graphiql) - UI tool for queries

## Request examples

#### Recent posts
```shell
curl localhost:8080/graphql -v -d  '{"query": "{ recentPosts(count: 10, offset: 0) { id, title } }"}'
```

#### Create post
```shell
curl localhost:8080/graphql -v -d '{ "query": "mutation { writePost ( title: \"title2\", text: \"text2\", category: \"category2\", authorId: \"fb891e55-65ee-45db-ae39-876e3d33e61d\") { id } } " }'
```