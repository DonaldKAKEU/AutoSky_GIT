package com.skysoft.autosky.repository;

import com.skysoft.autosky.CustomProperties;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Repository
public class UserRepositoryProxy {


    @Autowired
    private CustomProperties props;

    // getUserUrl contient la liste des emplayes et la renvoie

    public Iterable<User> findAllUsers() {

        String baseApiUrl = props.getApiUrl();
        String getAllUsersUrl = baseApiUrl + "/getAllUsers";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<User>> response = restTemplate.exchange(
                getAllUsersUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<User>>() {
                }

        );

        log.debug("Get Users" + response.getStatusCodeValue());

        return response.getBody();
    }

   public User createUrl(User u){
        String baseApiUrl = props.getApiUrl();
        String createUserUrl = baseApiUrl +"/createUser";

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<User> request =new HttpEntity<>(u);
        ResponseEntity<User> response= restTemplate.exchange(
                createUserUrl,
                HttpMethod.POST,
                request,
                User.class
        );

        log.debug("create Employee call" + response.getStatusCodeValue());

        return  response.getBody();
    }

    public void deleteUrl(Long id) {
        String baseApiUrl = props.getApiUrl();
        String deleteUserUrl = baseApiUrl + "/deleteUserById/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUserUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete User call " + response.getStatusCode().toString());
    }




}
