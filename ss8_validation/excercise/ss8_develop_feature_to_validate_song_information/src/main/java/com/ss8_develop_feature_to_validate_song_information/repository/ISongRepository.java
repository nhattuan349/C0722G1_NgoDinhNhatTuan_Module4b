package com.ss8_develop_feature_to_validate_song_information.repository;

import com.ss8_develop_feature_to_validate_song_information.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {

    @Query(value = "select s.* " +
            "from `song` s " +
            "where name like concat('%', :name,'%') ",nativeQuery = true)
    Page<Song> findByNameSong(Pageable pageable,
                              @Param("name") String name);

}
