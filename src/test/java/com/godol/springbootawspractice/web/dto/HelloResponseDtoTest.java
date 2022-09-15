package com.godol.springbootawspractice.web.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HelloResponseDtoTest {

    @DisplayName("롬복 테스트")
    @Test
    public void lombokTest(){
        // Given
        String name = "test";
        int amount = 10000;

        // When
        HelloResponseDto dto = new HelloResponseDto(name,amount);
        // Then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}