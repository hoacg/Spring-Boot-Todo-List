package my.app.has.musicplayer.repositories;

import my.app.has.musicplayer.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
