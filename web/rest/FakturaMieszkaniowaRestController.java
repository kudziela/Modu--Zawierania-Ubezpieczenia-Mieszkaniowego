package com.muka.modul_ubezpieczen.web.rest;

import com.muka.modul_ubezpieczen.domain.Faktura.FakturaMieszkaniowa;
import com.muka.modul_ubezpieczen.service.FakturaMieszkaniowaService;
import com.muka.modul_ubezpieczen.service.dto.FakturaMieszkaniowaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;



/**
 * Created by Magda on 28.12.2017.
 */
@RestController
@RequestMapping("/api/faktura")
public class FakturaMieszkaniowaRestController {


    @Autowired
    FakturaMieszkaniowaService fakturaMieszkaniowaService;


    @PostMapping()
    public ResponseEntity<FakturaMieszkaniowaDTO> dodajFakture(FakturaMieszkaniowaDTO fakturaMieszkaniowaDTO) throws URISyntaxException {

        FakturaMieszkaniowa fakturaMieszkaniowaToPersist = FakturaMieszkaniowa.builder()
            .kwota(fakturaMieszkaniowaDTO.getKwota())
            .opis(fakturaMieszkaniowaDTO.getOpis())
            .data(fakturaMieszkaniowaDTO.getData())
            .build();

        FakturaMieszkaniowa persistedFakturaMieszkaniowa = fakturaMieszkaniowaService.dodajFakture(fakturaMieszkaniowaToPersist);

        return ResponseEntity.created(new URI("/api/faktura/" + persistedFakturaMieszkaniowa.getIdFaktura()))
            .body(FakturaMieszkaniowaDTO.ofFakturaMieszkaniowa(persistedFakturaMieszkaniowa));
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> pobierzFakturyMieszkaniowe() {

        return ResponseEntity.ok(fakturaMieszkaniowaService.pobierzFakturyMieszkaniowe());
    }

}
