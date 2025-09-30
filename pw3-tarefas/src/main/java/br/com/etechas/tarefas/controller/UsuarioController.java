package br.com.etechas.tarefas.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    public ResponseEntity<Void> criar(@PathVariable Long Id){

    }
}
