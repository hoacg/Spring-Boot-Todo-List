package my.app.has.musicplayer.services;

import my.app.has.musicplayer.models.Playlist;
import my.app.has.musicplayer.models.Song;
import my.app.has.musicplayer.repositories.PlaylistRepository;
import my.app.has.musicplayer.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlaylistService implements IPlaylistService {

    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Playlist addSongsIntoPlaylist(Long playListId, List<Song> songs) throws Exception {

        Optional<Playlist> playlist = this.playlistRepository.findById(playListId);

        if (playlist.isPresent()) {
            Playlist playlist1 = playlist.get();

            playlist1.setSongs(songs);

            Playlist savedPlaylist = this.playlistRepository.save(playlist1);

            return savedPlaylist;
        } else {
            // no playlist
            throw new Exception("id playlist không tồn tại");
        }
    }
}
