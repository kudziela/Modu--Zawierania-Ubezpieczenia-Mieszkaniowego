package com.muka.modul_ubezpieczen.web.rest;

import com.muka.modul_ubezpieczen.domain.Klient.Klient;
import com.muka.modul_ubezpieczen.domain.UbezpieczenieDemo;
import com.muka.modul_ubezpieczen.service.KlientService;
import com.muka.modul_ubezpieczen.service.dto.UbezpieczenieDemoDTO;
import com.muka.modul_ubezpieczen.service.UbezpieczenieDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

import static com.muka.modul_ubezpieczen.service.dto.UbezpieczenieDemoDTO.ofUbezpieczenieDemo;

/**
 * Created by Magda on 27.12.2017.
 */
@RestController
@RequestMapping("/api/ubezpieczenie-demo")
public class UbezpieczenieDemoRestController {

    @Autowired
    private KlientService klientService;

    @Autowired
    private UbezpieczenieDemoService ubezpieczenieDemoService;

    @PostMapping()
    public ResponseEntity<UbezpieczenieDemoDTO> dodajKlienta(UbezpieczenieDemoDTO ubezpieczenieDemo) throws URISyntaxException {

        Klient klient = klientService.findOneById(ubezpieczenieDemo.getKlientDTO().getId());

        UbezpieczenieDemo ubezpieczenieDemoToPersist = UbezpieczenieDemo.builder()
            .nazwa(ubezpieczenieDemo.getNazwa())
            .klient(klient)
            .build();

        UbezpieczenieDemo persistedUbezpieczenieDemo = ubezpieczenieDemoService.addUbezpieczenieDemo(ubezpieczenieDemoToPersist);

        return ResponseEntity.created(new URI("/api/ubezpieczenie-demo/" + persistedUbezpieczenieDemo.getId()))
            .body(ofUbezpieczenieDemo(persistedUbezpieczenieDemo));
    }
}
