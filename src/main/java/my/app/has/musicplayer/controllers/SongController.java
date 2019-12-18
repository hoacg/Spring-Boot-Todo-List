package my.app.has.musicplayer.controllers;

import my.app.has.musicplayer.models.Song;
import my.app.has.musicplayer.services.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    @Autowired
    ISongService songService;

    @GetMapping("/api/song/{id}")
    public ResponseEntity<Song> getSong(@PathVariable Long id) {
        Song song = songService.findById(id);
        if (song != null) {
            return new ResponseEntity<>(song, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
