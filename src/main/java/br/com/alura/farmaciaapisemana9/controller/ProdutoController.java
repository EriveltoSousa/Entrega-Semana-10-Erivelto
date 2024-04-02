package br.com.alura.farmaciaapisemana9.controller;

import br.com.alura.farmaciaapisemana9.DTO.DadoasAtualizacaoDTO;
import br.com.alura.farmaciaapisemana9.DTO.DadosCadastroDTO;
import br.com.alura.farmaciaapisemana9.DTO.DadosRetornoDTO;
import br.com.alura.farmaciaapisemana9.model.Fabricante;
import br.com.alura.farmaciaapisemana9.model.Produto;
import br.com.alura.farmaciaapisemana9.repository.FabricanteRepository;
import br.com.alura.farmaciaapisemana9.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

       var uri = uriBuilder.path("{id}").buildAndExpand(produto.getId()).toUri();

       return  ResponseEntity.created(uri).body(new DadosRetornoDTO(produto));

     }

     @GetMapping(" /{id}")
    public ResponseEntity detalhar (@PathVariable int id){
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosRetornoDTO(produto));
     }

     @GetMapping
    public  ResponseEntity<Page<DadosRetornoDTO>> listar(@PageableDefault(size=2, sort = {"nome"})Pageable paginacao){
         var page = produtoRepository.findAll(paginacao).map(DadosRetornoDTO::new);
         return ResponseEntity.ok(page);
     }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadoasAtualizacaoDTO produtoDTO){
        var produto = produtoRepository.getReferenceById(produtoDTO.id());
        produto.atualizar(produtoDTO);
        return ResponseEntity.ok(new DadosRetornoDTO(produto));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable int id){
         produtoRepository.deleteById(id);
         return ResponseEntity.noContent().build();
    }
}
