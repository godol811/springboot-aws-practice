package com.godol.springbootawspractice.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProfileControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("프로필은 인증 없이 호출 된다")
    public void profileIsNotCalledWithoutAuth(){
        // Given
        String expected = "default";
        // When
        ResponseEntity<String> response = restTemplate.getForEntity("/profile", String.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expected);
    }


    @Test
    @DisplayName("리얼 프로필 파일이 조회된다")
    public void realProfileSearched(){
        // Given
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();

        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("read-db");

        ProfileController controller = new ProfileController(env);
        // When
        String profile = controller.profile();
        // Then
        assertThat(profile).isEqualTo(expectedProfile);
    }
    @Test
    @DisplayName("액티브 프로필 파일이 없으면 디폴트가 조회된다")
    public void ifActiveIsNullThenDefaultSearched(){
        // Given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);
        // When
        String profile = controller.profile();
        // Then
        assertThat(profile).isEqualTo(expectedProfile);
    }


}