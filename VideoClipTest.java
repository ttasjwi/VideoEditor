import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class VideoClipTest {

    @Test
    @DisplayName("getId 테스트")
    void getIdTest() {

        // given
        VideoClip videoClip = VideoClip.CLOSE_DB;

        // when
        String id = videoClip.getId();

        // then
        assertThat(id).isEqualTo("close_db");
    }

    @Test
    @DisplayName("getTitle 테스트")
    void getTitleTest() {

        // given
        VideoClip videoClip = VideoClip.DOG_MEW;

        // when
        String title = videoClip.getTitle();

        // then
        assertThat(title).isEqualTo("개가 냐옹냐옹");
    }

    @Test
    @DisplayName("getTime 테스트")
    void getTimeTest() {

        // given
        VideoClip videoClip = VideoClip.GIT_PUSH_FORCE;

        // when
        int time = videoClip.getTime();

        // then
        assertThat(time).isEqualTo(12);
    }

    @Test
    @DisplayName("존재하는 id로 Video 찾기")
    void ofTest1() {

        SoftAssertions soft = new SoftAssertions();

        for (VideoClip videoClip : VideoClip.VIDEO_CLIPS) {

            // given
            String id = videoClip.getId();

            // when
            VideoClip findById = VideoClip.of(id).get();

            // then
            soft.assertThat(findById).isEqualTo(videoClip);
        }
    }

    @Test
    @DisplayName("존재하지 않는 id로 Video 찾기")
    void ofTest2() {

        //given
        Optional<VideoClip> maybeEmpty = VideoClip.of("꽐꽐");

        //when
        boolean isEmpty = maybeEmpty.isEmpty();

        //true
        assertThat(isEmpty).isTrue();
    }

}