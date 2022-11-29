package com.ss8_develop_feature_to_validate_song_information.service.impl;

import com.ss8_develop_feature_to_validate_song_information.model.Song;
import com.ss8_develop_feature_to_validate_song_information.repository.ISongRepository;
import com.ss8_develop_feature_to_validate_song_information.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public Page<Song> findByNameSong(Pageable pageable, String name) {
        return songRepository.findByNameSong(pageable, name);
    }
}
