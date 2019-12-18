package my.app.has.musicplayer.repositories;

import my.app.has.musicplayer.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
