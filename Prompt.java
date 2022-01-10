
public class Prompt {

    private static Prompt prompt = new Prompt();

    private Prompt() {}

    public static void run() {
        prompt.execute();
    }

    private void execute() {
        printVideoClip();
    }

    private void printVideoClip() {
        StringBuilder sb = new StringBuilder();
        sb.append("================영상클립================").append('\n');
        sb.append("제목 (id) : 재생시간").append('\n');
        sb.append("---------------------------------------").append('\n');
        for (VideoClip video : VideoClip.VIDEO_CLIPS) {
            sb.append(video.getTitle()).append(" (").append(video.getId()).append(") : ").append(video.getTime()).append(" sec").append('\n');
        }
        sb.append("=======================================").append('\n');
        System.out.println(sb);
    }

}
