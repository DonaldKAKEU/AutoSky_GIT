package model;

import lombok.Data;

import javax.security.auth.callback.PasswordCallback;


@Data
public class User {

    private Long id;

    private  String nom;

    private  String prenom;

    private String login;

    private String password;

}
