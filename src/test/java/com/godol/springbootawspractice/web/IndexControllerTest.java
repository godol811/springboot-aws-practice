package com.godol.springbootawspractice.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("메인페이지 로딩 테스트")
    @Test
    public void mainPageLoading() throws Exception{
        // Given
        // When
        String body = this.restTemplate.getForObject("/", String.class);

        // Then
        assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
    }
}