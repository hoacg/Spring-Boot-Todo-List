package my.app.has.musicplayer.services;

import my.app.has.musicplayer.models.Playlist;
import my.app.has.musicplayer.models.Song;

import java.util.List;

public interface IPlaylistService {
    Playlist addSongsIntoPlaylist(Long playListId, List<Song> songs) throws Exception;
}
