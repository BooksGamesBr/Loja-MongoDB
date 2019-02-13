package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Produto;
import com.booksgames.loja.dto.ProdutoDTO;
import com.booksgames.loja.repository.ProdutoRepository;
import com.booksgames.loja.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.bson.types.ObjectId;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private ProdutoService produtoService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Produto> getAllProduto() {
    return produtoRepository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Produto getPetById(@PathVariable("id") ObjectId id) {
    return produtoRepository.findBy_id(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Produto produto) {
    produto.set_id(id);
    produtoRepository.save(produto);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Produto createPet(@Valid @RequestBody Produto produto) {
    produto.set_id(ObjectId.get());
    produtoRepository.save(produto);
    return produto;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    produtoRepository.delete(produtoRepository.findBy_id(id));
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