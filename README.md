# Spring Boot encrypt/decrypt database properties

Project using Spring Boot, to encrypt/decrypt database properties (name and email).

Basically Spring calls a database (MySQL) encryption function (aes_encrypt('property', 'secret'))

```
    @ColumnTransformer(
            read = "aes_decrypt(name, '" + SECRET + "')",
            write = "aes_encrypt(?, '" + SECRET + "')"
    )
    @Column(columnDefinition = "Blob")
    private String name;
```

# Running Tests
EncryptionTest.java (savedUser() and getUser())

# References
* [DATABASE COLUMN-LEVEL ENCRYPTION WITH SPRING DATA JPA](https://sultanov.dev/blog/database-column-level-encryption-with-spring-data-jpa/)
* [Encrypt/Decrypt in mysql](https://gist.github.com/rantav/01555fc2ea874bde028d5b04fd97c793)
