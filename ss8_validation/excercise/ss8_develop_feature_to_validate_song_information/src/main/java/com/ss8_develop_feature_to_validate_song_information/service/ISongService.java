package com.ss8_develop_feature_to_validate_song_information.service;

import com.ss8_develop_feature_to_validate_song_information.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ISongService extends IGeneralService<Song> {

    Page<Song> findByNameSong(Pageable pageable, String name);

}
