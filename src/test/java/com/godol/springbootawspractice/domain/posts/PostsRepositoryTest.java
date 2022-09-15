package com.godol.springbootawspractice.domain.posts;

import com.godol.springbootawspractice.domain.posts.Posts;
import com.godol.springbootawspractice.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@WebAppConfiguration
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @DisplayName("게시글 저장 불러오기")
    @Test
    public void loadingPosts(){
        // Given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("godol811@naver.com")
                .build());

        // When
        List<Posts> postsList = postsRepository.findAll();
        // Then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @DisplayName("Auditing 테스트코드")
    @Test
    public void baseTimeEntityRegister(){
        // Given
        LocalDateTime now = LocalDateTime.of(2022,9,14,0,0,0);
        postsRepository.save(Posts.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                        .build());
        // When
        List<Posts> postsList = postsRepository.findAll();

        // Then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>>>>>>> createDate = " + posts.getCreatedTime() + " modifiedDate = " + posts.getModifiedDate());
        assertThat(posts.getCreatedTime()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}