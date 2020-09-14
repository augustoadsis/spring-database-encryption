package com.augusto.springdatabaseencryption.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User implements Serializable {

    @Value("${encryption.secretKey}")
    @Transient
    final String SECRET = "";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @ColumnTransformer(
            read = "aes_decrypt(name, '" + SECRET + "')",
            write = "aes_encrypt(?, '" + SECRET + "')"
    )
    @Column(columnDefinition = "Blob")
    private String name;

    @ColumnTransformer(
            read = "aes_decrypt(email, '" + SECRET + "')",
            write = "aes_encrypt(?, '" + SECRET + "')"
    )
    @Column(columnDefinition = "Blob")
    private String email;

}
