package br.com.guilherme.controller;

import br.com.guilherme.model.Pessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trovo")
public class TesteController {

    @GetMapping()
    public ResponseEntity<String> pegar() {
        return ResponseEntity.ok("Deu tudo certo Gui!");
    }

    List<Pessoa> listaPessoa = new ArrayList<>();

    @GetMapping("/pessoa")
    public ResponseEntity<List<Pessoa>> getAll() {

        return ResponseEntity.ok(listaPessoa);

    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Pessoa pessoa) {

        listaPessoa.add(pessoa);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PostConstruct
    public void init() {
        listaPessoa.add(Pessoa.builder().id(1).nome("Gui").idade(22).altura(1.84).build());
        listaPessoa.add(Pessoa.builder().id(2).nome("Bia").idade(32).altura(1.60).build());
        listaPessoa.add(Pessoa.builder().id(3).nome("Pe").idade(54).altura(1.73).build());
        listaPessoa.add(Pessoa.builder().id(4).nome("Mig").idade(43).altura(1.45).build());
        listaPessoa.add(Pessoa.builder().id(5).nome("Re").idade(55).altura(1.39).build());
    }

}
