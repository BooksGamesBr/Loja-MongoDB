package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Cor;
import com.booksgames.loja.dto.CorDTO;
import com.booksgames.loja.repository.CorRepository;
import com.booksgames.loja.services.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import org.bson.types.ObjectId;

@RestController
@RequestMapping("/cores")
public class CorController {

    @Autowired
    private CorRepository corRepository;

   @Autowired
    private CorService corService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Cor> getAllCores() {
        return corRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cor getCorById(@PathVariable("id") ObjectId id) {
        return corRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyCorById(@PathVariable("id") ObjectId id, @Valid @RequestBody Cor cor) {
        cor.set_id(id);
        corRepository.save(cor);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Cor createCor(@Valid @RequestBody Cor cor) {
        cor.set_id(ObjectId.get());
        corRepository.save(cor);
        return cor;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCor(@PathVariable ObjectId id) {
        corRepository.delete(corRepository.findBy_id(id));
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<CorDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Cor> list = corService.findPage(page, linesPerPage, orderBy, direction);
        Page<CorDTO> listDto = list.map(obj -> new CorDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }
}