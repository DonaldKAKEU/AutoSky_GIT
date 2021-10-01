package com.skysoft.autosky.repository;

import com.skysoft.autosky.CustomProperties;
import lombok.extern.slf4j.Slf4j;
import model.Depanage;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DepanageRepositoryProxy {

    @Autowired
    private CustomProperties props;

    // getUserUrl contient la liste des emplayes et la renvoie

    public Iterable<Depanage> findAllDepanage() {

        String baseApiUrl = props.getApiUrl();
        String getAllDepanageUrl = baseApiUrl + "/getAllDepanage";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<Depanage>> response = restTemplate.exchange(
                getAllDepanageUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Depanage>>() {
                }

        );

        log.debug("Get depanage" + response.getStatusCodeValue());

        return response.getBody();
    }

}
