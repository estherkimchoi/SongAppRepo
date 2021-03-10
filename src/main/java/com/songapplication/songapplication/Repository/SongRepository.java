package com.songapplication.songapplication.Repository;

import com.songapplication.songapplication.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
