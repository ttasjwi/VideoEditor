import java.util.List;
import java.util.Optional;

public interface VideoClipRepository {

    VideoClip save(VideoClip videoClip);
    Optional<VideoClip> findyId(Long id);
    List<VideoClip> findAll();
}
