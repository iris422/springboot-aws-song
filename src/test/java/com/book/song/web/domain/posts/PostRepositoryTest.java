package com.book.song.web.domain.posts;

import com.book.song.domain.posts.Posts;
import com.book.song.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void call_save_contents() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("test@gmail.com")
                .build());

        List<Posts> plist = postsRepository.findAll();

        Posts posts = plist.get(0);
        System.out.println(posts.getId());
        System.out.println(posts.getTitle());
        System.out.println(posts.getContent());
        System.out.println(posts.getAuthor());
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void registBaseTimeEntity() {
        LocalDateTime now = LocalDateTime.of(2019, 5, 5, 0,0,0);

        System.out.println("============================  SONG_LOG :: now = " + now.toString());

        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println("============================  SONG_LOG :: createdDate = " + posts.getCreatedDate()
                + ", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
