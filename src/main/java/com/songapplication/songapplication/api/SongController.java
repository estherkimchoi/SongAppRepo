package com.songapplication.songapplication.api;

import com.songapplication.songapplication.Service.SongService;
import com.songapplication.songapplication.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//
@RestController
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("api/v1/songs")
    private List<Song> getAllSongs(){
       return songService.getAllSongs();
    }

    @GetMapping("api/v1/songs/{id}")
    private Song getOneSong(@PathVariable("id") Long id){
        return songService.getSongById(id);
    }

    @DeleteMapping("api/v1/songs/{id}")
    private void deleteSong(@PathVariable("id") Long id){
        songService.deleteById(id);
    }

    @PostMapping("api/v1/songs")
    private Long registerSong(@RequestBody Song song){
        songService.registerSong(song);
        return song.getId();
    }

    @PutMapping("api/v1/songs/{id}")
    private Song editSongById(@PathVariable Long id,@RequestBody Song newSong){
        songService.editSongById(id, newSong);
        return newSong;

    }
}
