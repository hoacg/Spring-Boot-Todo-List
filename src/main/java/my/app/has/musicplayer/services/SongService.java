package my.app.has.musicplayer.services;

import my.app.has.musicplayer.models.Song;
import my.app.has.musicplayer.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SongService implements  ISongService {
    private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAll() {
        return null;
    }

    @Override
    public Song findById(Long id) {
        return this.songRepository.getOne(id);
    }

    @Override
    public boolean save(Song song) {
        return false;
    }

    @Override
    public boolean delete(Song song) {
        return false;
    }
}
