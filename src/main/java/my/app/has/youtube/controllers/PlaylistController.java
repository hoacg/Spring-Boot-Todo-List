package my.app.has.youtube.controllers;

import my.app.has.youtube.models.Video;
import my.app.has.youtube.services.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class PlaylistController {

    @GetMapping("/playlist")
    private ResponseEntity<List<Video>> getPlaylist() {
        List<Video> videos = VideoService.getVideos();
        return new ResponseEntity<>(videos, HttpStatus.CREATED);
    }

    @PostMapping("/video")
    private ResponseEntity<Video> addVideo(@RequestBody Video video) {
        VideoService.addVideo(video);
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }
}
