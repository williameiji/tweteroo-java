# tweteroo-java

Backend for an application similar to twitter using java, where the user must login with his name and link to the avatar and inside the app he can post his tweets.

```yml
POST /api/auth/sign-up
    - Route to login.
    - headers: {}
    - body: {
	            username: 'Shazam',
	            avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
            }
```

```yml
POST /api/tweets
    - Route to add a tweet.
    - headers: {}
    - body: {
	            username: "Shazam",
                tweet: "Algum texto aqui..."
            }
```

```yml
GET /api/tweets?page=0 (pagination)
    - Route to return a list of the last 5 tweets.
    - headers: {}
    - body: {}
```

```yml
GET /api/tweets/{Username}
    - Route to return a list of all tweets from a user by their username.
    - headers: {}
    - body: {}
```
