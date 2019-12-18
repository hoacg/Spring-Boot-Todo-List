package my.app.has.musicplayer.services;

import my.app.has.musicplayer.models.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    boolean save(Song song);
    boolean delete(Song song);
}
