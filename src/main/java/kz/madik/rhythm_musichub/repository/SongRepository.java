package kz.madik.rhythm_musichub.repository;

import kz.madik.rhythm_musichub.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
