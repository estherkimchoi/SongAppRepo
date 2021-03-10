package com.songapplication.songapplication.Service;

import com.songapplication.songapplication.Repository.SongRepository;
import com.songapplication.songapplication.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public List<Song> getAllSongs(){
        List<Song> songs = new ArrayList<Song>();
        songRepository.findAll().forEach(song -> songs.add(song));
        return songs;
    }

    public Song getSongById(Long id){
        return songRepository.findById(id).get();
    }

    public void registerSong(Song song){
        songRepository.save(song);

    }

    public void deleteById(Long id){
        songRepository.deleteById(id);
    }

    public void editSongById(Long id, Song newSong){
        songRepository.findById(id).map(song -> { song.setId(newSong.getId());
                                                  song.setTitle(newSong.getTitle());
                                                  song.setReleaseDate(newSong.getReleaseDate());
                                                  song.setSingerName(newSong.getSingerName());
                                                  return songRepository.save(song);

        } );
    }
}
