package my.app.has.youtube.services;

import my.app.has.youtube.models.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoService {

    static List<Video> videos = new ArrayList<>();

    static {
        Video video = new Video();
        video.setId("knW7-x7Y7RE");
        video.setTitle("Hay trao cho anh");

        Video video1 = new Video();
        video1.setId("knW7-x7Y7RE");
        video1.setTitle("Hay trao cho anh");

        Video video2 = new Video();
        video2.setId("knW7-x7Y7RE");
        video2.setTitle("Hay trao cho anh");

        Video video3 = new Video();
        video3.setId("knW7-x7Y7RE");
        video3.setTitle("Hay trao cho anh");

        videos.add(video);
        videos.add(video1);
        videos.add(video2);
        videos.add(video3);

    }

    public static List<Video> getVideos() {
        return videos;
    }

    public static void addVideo(Video video) {
        videos.add(video);
    }
}
