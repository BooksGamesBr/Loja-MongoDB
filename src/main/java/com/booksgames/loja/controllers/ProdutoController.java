package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Produto;
import com.booksgames.loja.dto.ProdutoDTO;
import com.booksgames.loja.repository.ProdutoRepository;
import com.booksgames.loja.services.ProdutoService;
import com.booksgames.loja.services.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private ProdutoServiceImpl produtoServiceImpl;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Produto> getAllProduto() {
    return produtoRepository.findAll();
  }

  @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
  public Produto getPetById(@PathVariable("_id") String _id) {
    return produtoRepository.findBy_id(_id);
  }
  
  @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
  public void modifyPetById(@PathVariable("_id") String _id, @Valid @RequestBody Produto produto) {
    produto.set_id(_id);
    produtoRepository.save(produto);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity<Void> createProduto(@Valid @RequestBody ProdutoDTO objDto) {
    Produto obj = produtoServiceImpl.fromDTO(objDto);
    obj = produtoServiceImpl.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{_id}").buildAndExpand(obj.get_id()).toUri();
    return ResponseEntity.created(uri).build();
  }
  
  @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable String _id) {
    produtoRepository.delete(produtoRepository.findBy_id(_id));
  }

/*  @RequestMapping(value="/page", method=RequestMethod.GET)
  public ResponseEntity<Page<ProdutoDTO>> findPage(
          @RequestParam(value="page", defaultValue="0") Integer page,
          @RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
          @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
          @RequestParam(value="direction", defaultValue="ASC") String direction) {
    Page<Produto> list = produtoService.findPage(page, linesPerPage, orderBy, direction);
    Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
    return ResponseEntity.ok().body(listDto);
  }*/
}