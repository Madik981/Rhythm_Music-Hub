package kz.madik.rhythm_musichub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int duration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    private Album album;
}
