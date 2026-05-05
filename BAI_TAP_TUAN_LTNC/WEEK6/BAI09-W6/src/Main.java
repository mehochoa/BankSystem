interface AudioPlayable {
    void playAudio(String file);
}

interface VideoPlayable {
    void playVideo(String file);
}

class AudioPlayer implements AudioPlayable {
    @Override
    public void playAudio(String file) {
        System.out.println("Playing audio: " + file);
    }
}

class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo(String file) {
        System.out.println("Playing video: " + file);
    }
}

class MediaPlayer {
    private AudioPlayable audio;
    private VideoPlayable video;

    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audio = audio;
        this.video = video;
    }

    public void playAudio(String file) {
        audio.playAudio(file);
    }

    public void playVideo(String file) {
        video.playVideo(file);
    }
}

public class Main {
    public static void main(String[] args) {
        AudioPlayable audioPlayer = new AudioPlayer();
        VideoPlayable videoPlayer = new VideoPlayer();
        MediaPlayer player = new MediaPlayer(audioPlayer, videoPlayer);
        player.playAudio("music.mp3");
        player.playVideo("movie.mp4");
    }
}