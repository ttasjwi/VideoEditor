import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class SampleVideoClipRepository implements VideoClipRepository {

    private static SampleVideoClipRepository instance;

    private static Map<Long, VideoClip> store;
    private static AtomicLong order;

    private SampleVideoClipRepository() {
        this.store = new HashMap<>();
        this.order = new AtomicLong();
        sampleSaves();
    }

    private void sampleSaves() {
        this.save(new VideoClip("땃쥐가 밥먹어요", 13));
        this.save(new VideoClip("해가 서쪽에서 떠요",7));
        this.save(new VideoClip("토끼가 깡총깡총 뛰어요",8));
        this.save(new VideoClip("땃고양이가 멍멍해요", 5));
        this.save(new VideoClip("서버 DB에 rm -rf / 하기", 14));
        this.save(new VideoClip("리베이스한거 회사 서버에 git push --force 하기", 12));
        this.save(new VideoClip("DB 전원 내려감", 4));
        this.save(new VideoClip("개가 냐옹냐옹",7));
        this.save(new VideoClip("돼지가 날아다녀요",10));
        this.save(new VideoClip("회사 주가가 폭락해요", 1));
        this.save(new VideoClip("Hello World 치기",3));
        this.save(new VideoClip("호눅스 먹방",2));
        this.save(new VideoClip("피카츄, 22900V!",11));
    }

    public static VideoClipRepository getRepository() {
        if (instance == null) {
            instance = new SampleVideoClipRepository();
        }
        return instance;
    }

    @Override
    public VideoClip save(VideoClip videoClip) {
        Long id = order.updateAndGet(v-> v+1);
        videoClip.initId(id);
        store.put(id, videoClip);
        return videoClip;
    }

    @Override
    public Optional<VideoClip> findyId(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<VideoClip> findAll() {
        return new ArrayList<>(store.values());
    }
}
