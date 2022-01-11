public class Prompt {

    private static Prompt prompt = new Prompt();

    private VideoClipRepository videoClipRepository;

    private Prompt() {
        videoClipRepository = SampleVideoClipRepository.getRepository();
    }

    public static void run() {
        prompt.execute();
    }

    private void execute() {
        printVideoClip();
    }

    private void printVideoClip() {
        StringBuilder sb = new StringBuilder();
        sb.append("================영상클립================").append('\n');
        sb.append("id\t제목 : 재생시간").append('\n');
        sb.append("---------------------------------------").append('\n');
        for (VideoClip video : videoClipRepository.findAll()) {
            sb.append(video.getId()).append('\t').append(video.getTitle()).append(" : ").append(video.getTime()).append(" sec").append('\n');
        }
        sb.append("=======================================").append('\n');
        System.out.println(sb);
    }

}
