package com.book.song.web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_fn_test() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto hrdto = new HelloResponseDto(name, amount);

        assertThat(hrdto.getName()).isEqualTo(name);
        assertThat(hrdto.getAmount()).isEqualTo(amount);
    }
}
