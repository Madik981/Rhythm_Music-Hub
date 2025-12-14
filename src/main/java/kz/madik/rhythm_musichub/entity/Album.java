package kz.madik.rhythm_musichub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_id")
    private Long id;

    private String title;

    private int releaseYear;
}
