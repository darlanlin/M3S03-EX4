package br.com.futurodev.controllers;

import br.com.futurodev.model.PessoaModel;
import br.com.futurodev.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String mostrarnome(@PathVariable String nome) {
        return "O seu nome é " + nome;
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoa) {
        PessoaModel modelo = pessoaRepository.save(pessoa);
        return new ResponseEntity<PessoaModel>(modelo, HttpStatus.CREATED);
    }



}
