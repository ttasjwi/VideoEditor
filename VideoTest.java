import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VideoTest {

    @Test
    @DisplayName("getId 테스트")
    void getIdTest() {

        // given
        Video video = Video.CLOSE_DB;

        // when
        String id = video.getId();

        // then
        assertThat(id).isEqualTo("close_db");
    }

    @Test
    @DisplayName("getTitle 테스트")
    void getTitleTest() {

        // given
        Video video = Video.DOG_NYAONG;

        // when
        String title = video.getTitle();

        // then
        assertThat(title).isEqualTo("개가 냐옹냐옹");
    }

    @Test
    @DisplayName("getTime 테스트")
    void getTimeTest() {

        // given
        Video video = Video.GIT_PUSH_FORCE;

        // when
        int time = video.getTime();

        // then
        assertThat(time).isEqualTo(12);
    }

}