package com.IBM.associates.controller;

import com.IBM.associates.entidades.Estagiario;
import com.IBM.associates.repository.AssociatesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {
    @Autowired
    AssociatesRepository associatesRepository;

    @PostMapping("/associates/v1")
    public ResponseEntity<Estagiario> cadastrarEstagiario(@RequestBody Estagiario estagiarios){
        associatesRepository.save(estagiarios);
        return new ResponseEntity<Estagiario>(HttpStatus.CREATED);
    }

    @GetMapping("/associates/v1")
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<List<Estagiario>> listarEstagiarios(){
        List<Estagiario> estagiariosList = associatesRepository.findAll();//cria lista estagiários e preenche lista vazia
        if (estagiariosList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estagiariosList);
    }

    @GetMapping("/associates/v1/{cnum}")
    public ResponseEntity<Estagiario> getPorCnum(@PathVariable Long cnum){

        Optional<Estagiario> estagiario = associatesRepository.findById(cnum);
        if (estagiario.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estagiario.get());
    }


}

