package my.app.has.musicplayer.services;

import my.app.has.musicplayer.models.Song;
import my.app.has.musicplayer.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        Optional<Song> songOptional = this.songRepository.findById(id);
        if (songOptional.isPresent()) {
            return songOptional.get();
        } else {
            return null;
        }
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
