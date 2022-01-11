import java.util.Objects;

public class VideoClip {

    private Long id;
    private String title;
    private int time;

    public VideoClip(String title, int time) {
        this.title = title;
        this.time = time;
    }

    public void initId(Long initId) {
        if (id == null) {
            this.id = initId;
        }
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoClip videoClip = (VideoClip) o;
        return id.equals(videoClip.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
