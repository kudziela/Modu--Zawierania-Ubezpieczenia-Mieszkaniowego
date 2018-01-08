package com.muka.modul_ubezpieczen.domain.Ubezpieczenie;

import com.muka.modul_ubezpieczen.domain.Inne.PolisaTurystyczna;
import com.muka.modul_ubezpieczen.domain.Inne.WariantTurystyczny;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magda on 17.12.2017.
 */

@NoArgsConstructor
@Getter
@Entity
@Table(name = "UBEZPIECZENIA")
public class Ubezpieczenie {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "Kategoria")
    private Integer kategoria;

    @Column(name = "Nazwa")
    private String nazwa;

    @Column(name = "Opis")
    private String opis;

    @Column(name = "Zdjecie")
    private Blob zdjecie;

    @Column(name = "Kwota")
    private Integer kwota;

}
