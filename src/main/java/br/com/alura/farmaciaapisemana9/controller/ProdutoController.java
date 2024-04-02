package br.com.alura.farmaciaapisemana9.controller;

import br.com.alura.farmaciaapisemana9.DTO.DadosCadastroDTO;
import br.com.alura.farmaciaapisemana9.DTO.DadosRetornoDTO;
import br.com.alura.farmaciaapisemana9.model.Fabricante;
import br.com.alura.farmaciaapisemana9.model.Produto;
import br.com.alura.farmaciaapisemana9.repository.FabricanteRepository;
import br.com.alura.farmaciaapisemana9.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ProdutoController {

    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

@PostMapping
@Transactional
public ResponseEntity cadastrar (@RequestBody @Valid DadosCadastroDTO dadosCadastro, UriComponentsBuilder uriBuilder){
     Fabricante fabricante = fabricanteRepository.findByNome(dadosCadastro.nomeFabricante());
     if (fabricante == null){
         fabricante = new Fabricante(dadosCadastro);
         fabricanteRepository.save(fabricante);
       }
       var produto = new Produto(dadosCadastro, fabricante);
       produtoRepository.save(produto);

       var uri = uriBuilder.path("{id}").buildAndExpand(produto.getId()).toUri()

       return  ResponseEntity.created(uri).body(new DadosRetornoDTO(produto));

     }

     
}
