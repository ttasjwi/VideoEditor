import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VideoClipTest {

    @Test
    @DisplayName("초기화되지 않은 상태에서는 Id는 null임")
    void initId_Test1() {
        // given
        VideoClip videoClip = new VideoClip("테스트1", 1);

        // when
        Long id = videoClip.getId();

        // then
        assertThat(id).isNull();
    }

    @Test
    @DisplayName("id 최초 init시 지정 id값이 id값이 되어야함.")
    void initId_Test2() {
        // given
        VideoClip videoClip = new VideoClip("테스트2", 2);

        // when
        videoClip.initId(5L);
        Long id = videoClip.getId();

        // then
        assertThat(id).isEqualTo(5L);
    }

    @Test
    @DisplayName("id가 초기화된 VideoClip에 다시 init을 시도할 때 id가 변경되선 안 됨")
    void initId_Test3() {
        // given
        VideoClip videoClip = new VideoClip("테스트3", 3);

        // when
        videoClip.initId(5L);
        videoClip.initId(10L);
        Long id = videoClip.getId();

        // then
        assertThat(id).isEqualTo(5L);
    }

    @Test
    @DisplayName("getTitle은 생성 시의 title이 반환되어야함")
    void getTitle_Test() {
        // given
        VideoClip videoClip = new VideoClip("테스트4", 4);

        // when
        String title = videoClip.getTitle();

        // then
        assertThat(title).isEqualTo("테스트4");
    }

    @Test
    @DisplayName("생성 시의 time이 반환되어야함")
    void getTime_Test() {
        // given
        VideoClip videoClip = new VideoClip("테스트5", 5);

        // when
        int time = videoClip.getTime();

        // then
        assertThat(time).isEqualTo(5);
    }

    @Test
    @DisplayName("서로 같은 id를 가진 videoClip에 대하여, equals는 true를 반환해야함.")
    void equals_Test1() {
        // given
        VideoClip videoClip1 = new VideoClip("강아지가 날아다님", 2);
        VideoClip videoClip2 = new VideoClip("강아지가 날아다님", 2);

        // when
        videoClip1.initId(15L);
        videoClip2.initId(15L);

        boolean equals = videoClip1.equals(videoClip2);

        // then
        assertThat(equals).isTrue();
    }

    @Test
    @DisplayName("서로 다른 id를 가진 videoClip에 대하여, equals는 false를 반환해야함.")
    void equals_Test2() {
        // given
        VideoClip videoClip1 = new VideoClip("강아지가 날아다님", 2);
        VideoClip videoClip2 = new VideoClip("강아지가 날아다님", 2);

        // when
        videoClip1.initId(15L);
        videoClip2.initId(3L);

        boolean equals = videoClip1.equals(videoClip2);

        // then
        assertThat(equals).isFalse();
    }

    @Test
    @DisplayName("서로 같은 id를 가진 videoClip에 대하여, hashCode값은 같은 값을 반환해야함.")
    void hashCode_Test1() {
        // given
        VideoClip videoClip1 = new VideoClip("강아지가 날아다님", 2);
        VideoClip videoClip2 = new VideoClip("강아지가 날아다님", 2);

        // when
        videoClip1.initId(15L);
        videoClip2.initId(15L);

        int hashCode1 = videoClip1.hashCode();
        int hashCode2 = videoClip2.hashCode();

        // then
        assertThat(hashCode1).isEqualTo(hashCode2);
    }

    @Test
    @DisplayName("서로 다른 id를 가진 videoClip에 대하여, hashCode값은 다른 값을 반환해야함.")
    void hashCode_Test2() {
        // given
        VideoClip videoClip1 = new VideoClip("강아지가 날아다님", 2);
        VideoClip videoClip2 = new VideoClip("강아지가 날아다님", 2);

        // when
        videoClip1.initId(15L);
        videoClip2.initId(3L);

        int hashCode1 = videoClip1.hashCode();
        int hashCode2 = videoClip2.hashCode();

        // then
        assertThat(hashCode1).isNotEqualTo(hashCode2);
    }
}