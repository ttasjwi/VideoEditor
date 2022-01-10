import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    @Test
    @DisplayName("존재하는 id로 Video 찾기")
    void ofTest1() {

        SoftAssertions soft = new SoftAssertions();

        for (Video video : Video.VIDEOS) {

            // given
            String id = video.getId();

            // when
            Video findById = Video.of(id).get();

            // then
            soft.assertThat(findById).isEqualTo(video);
        }
    }

    @Test
    @DisplayName("존재하지 않는 id로 Video 찾기")
    void ofTest2() {

        //given
        Optional<Video> maybeEmpty = Video.of("꽐꽐");

        //when
        boolean isEmpty = maybeEmpty.isEmpty();

        //true
        assertThat(isEmpty).isTrue();
    }

}