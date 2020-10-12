package com.api.crowdlending.integration.webrequest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersHttpTest {
    @LocalServerPort
    private Integer port;
    private static RestTemplate restTemplate = null;
    private String baseUrl = "http://localhost";

    @BeforeAll
    static void init() {
        restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public boolean hasError(HttpStatus statusCode) {
                return false;
            }
        });
    }
    @BeforeEach
    void setUp(){
        //exemple tout bete http://localhost:7097/users
        baseUrl = baseUrl.concat(":").concat(port.toString()).concat("/users");
    }

    @Test
    void shouldReturnAListOfUsers(){
        Object users = restTemplate.getForObject(baseUrl, Object.class);
        System.out.println(users);
//        assertAll(
//                () -> assertNotNull(users),
//                () -> assertTrue(users.length == 2)
//        );
    }
}
