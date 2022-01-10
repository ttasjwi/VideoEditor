import java.util.Optional;
import java.util.stream.Stream;

public enum VideoClip {

    TTASJWI_EAT("ttasjwi_eat", "땃쥐가 밥어요", 13),
    SUN_RISE_WEST("sun_rise_west", "해가 서쪽에서 떠요", 7),
    TTASCAT_BARK("ttascat_bark", "땃고양이가 멍멍해요", 5),
    RABBIT_JUMP("rabbit_jump", "토끼가 깡총깡총 뛰어요", 8),
    RM_RF("rm_rf", "서버 DB에 rm -rf / 하기", 14),
    GIT_PUSH_FORCE("git_push_force", "리베이스한거 회사 서버에 git push --force 하기", 12),
    CLOSE_DB("close_db", "DB 전원 내려감", 4),
    DOG_MEW("dog_mew", "개가 냐옹냐옹", 7),
    PIG_FLY("pig_fly", "돼지가 날아다녀요", 10),
    STOCK_CRASH("stock_crash", "회사 주가가 폭락해요", 1),
    HELLO_WORLD("hello-world", "Hello World 치기", 3),
    HONUX_EAT("honux-eat", "호눅스 먹방", 2),
    PIKACHU("pikachu", "피카츄, 22900V!", 11);

    public static final VideoClip[] VIDEO_CLIPS = VideoClip.values();

    private String id;
    private String title;
    private int time;


    VideoClip(String id, String title, int time) {
        this.id = id;
        this.title = title;
        this.time = time;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTime() {
        return this.time;
    }

    // 지정 id와 일치하는 Video를 반환한다.
    public static Optional<VideoClip> of(String id) {
        return Stream.of(VIDEO_CLIPS)
                .filter(video -> video.getId().equals(id))
                .findAny();
    }

}
