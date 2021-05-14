package com.search.cep.controllers;

import com.search.cep.entities.Cep;
import com.search.cep.usecases.GetCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SearchCepController {

    @Autowired
    private GetCep getCep;

    @GetMapping("/get-cep/{cep}")
    public ResponseEntity<Cep> getCep(@PathVariable("cep") final String cep) throws Exception {
        return ResponseEntity.ok(getCep.execute(cep));
    }
}
