package kz.madik.rhythm_musichub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String nationality;

    private int age;

    private String gender;

}
