package kz.madik.rhythm_musichub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private int releaseYear;
}
