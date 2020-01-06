package my.app.has.musicplayer.services;


import my.app.has.musicplayer.models.Playlist;
import my.app.has.musicplayer.models.Song;
import my.app.has.musicplayer.repositories.PlaylistRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

public class PlaylistServiceTest {

    private PlaylistRepository playlistRepository = Mockito.mock(PlaylistRepository.class);
    private IPlaylistService playlistService = new PlaylistService(playlistRepository);

    @BeforeEach
    void prepare() {

        Playlist playlist = new Playlist();
        playlist.setId(1L);
        playlist.setName("Nhạc Xuân");

        Song song1 = new Song();
        song1.setId(1L);
        song1.setName("Con bướm xuân");

        Song song2 = new Song();
        song2.setId(2L);
        song2.setName("Xuân này con không về");

        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);


        doReturn(Optional.of(playlist)).when(playlistRepository).findById(1L);
        doReturn(playlist).when(playlistRepository).save(playlist);

    }

    @Test
    void test_addSongsIntoPlaylist() throws Exception {
        Song song1 = new Song();
        song1.setId(1L);
        song1.setName("Con bướm xuân");

        Song song2 = new Song();
        song2.setId(2L);
        song2.setName("Xuân này con không về");

        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);

        Playlist playlist = this.playlistService.addSongsIntoPlaylist(1L, songs);

        Assertions.assertThat(playlist).isNotNull();
        Assertions.assertThat(playlist.getSongs()).hasSize(2);
        Assertions.assertThat(playlist.getSongs()).contains(song1);
        Assertions.assertThat(playlist.getSongs()).contains(song2);
    }
}
