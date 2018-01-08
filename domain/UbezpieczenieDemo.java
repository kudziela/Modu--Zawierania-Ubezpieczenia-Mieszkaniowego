package com.muka.modul_ubezpieczen.domain;

import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Magda on 27.12.2017.
 */

@Getter
@NoArgsConstructor
@Entity
@Table
public class UbezpieczenieDemo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Column(name = "nazwa")
    private String nazwa;

    @ManyToOne
    private Klient klient;

    @Builder
    public UbezpieczenieDemo(String nazwa, Klient klient) {
        this.nazwa = nazwa;
        this.klient = klient;
    }
}
