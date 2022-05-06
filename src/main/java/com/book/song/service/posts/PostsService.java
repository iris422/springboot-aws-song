package com.book.song.service.posts;

import com.book.song.domain.posts.Posts;
import com.book.song.domain.posts.PostsRepository;
import com.book.song.web.dto.PostsResponseDto;
import com.book.song.web.dto.PostsSaveRequestDto;
import com.book.song.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No data rows. Please insert posts. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No data rows. Please insert posts. id = " + id));

        return new PostsResponseDto(entity);
    }

}
