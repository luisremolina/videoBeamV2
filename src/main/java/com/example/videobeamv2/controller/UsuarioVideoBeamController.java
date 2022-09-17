package com.example.videobeamv2.controller;

import com.example.videobeamv2.entity.UsuarioVideoBeam;
import com.example.videobeamv2.repository.UsuarioVideoBeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class UsuarioVideoBeamController {
    @Autowired
    UsuarioVideoBeamRepository usuarioVideoBeamRepository;

    // CREATE
    @PostMapping("/")
    public ResponseEntity<UsuarioVideoBeam> create(@RequestBody  UsuarioVideoBeam usuarioVideoBeam){
        return new ResponseEntity(usuarioVideoBeamRepository.save(usuarioVideoBeam), HttpStatus.CREATED);
    }

    // READ
    @GetMapping("/")
    public ResponseEntity<List<UsuarioVideoBeam>> read(){

        List<UsuarioVideoBeam> listaDeUsuarios = usuarioVideoBeamRepository.findAll();
        return new ResponseEntity(listaDeUsuarios, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/update")
    public  ResponseEntity<UsuarioVideoBeam> update(@RequestBody UsuarioVideoBeam usuarioVideoBeam){
        if (usuarioVideoBeamRepository.existsById(usuarioVideoBeam.getId())){
            return new ResponseEntity(usuarioVideoBeamRepository.save(usuarioVideoBeam), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (usuarioVideoBeamRepository.existsById(id)){
            usuarioVideoBeamRepository.deleteById(id);
            return ResponseEntity.ok("Usuario Eliminado correctamente");
        }
        return ResponseEntity.notFound().build();
    }
}
