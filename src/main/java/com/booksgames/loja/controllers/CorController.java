package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Cor;
import com.booksgames.loja.dto.CorDTO;
import com.booksgames.loja.repository.CorRepository;
import com.booksgames.loja.services.CorService;
import com.booksgames.loja.services.impl.CorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/cores")
public class CorController {

    @Autowired
    private CorRepository corRepository;

    @Autowired
    private CorServiceImpl corServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cor> getAllCores() {
        return corRepository.findAll();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Cor getCorById(@PathVariable("_id") String _id) {
        return corRepository.findBy_id(_id);
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public void modifyCorById(@PathVariable("_id") String _id, @Valid @RequestBody Cor cor) {
        cor.set_id(_id);
        corRepository.save(cor);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCor(@Valid @RequestBody CorDTO objDto) {
        Cor obj = corServiceImpl.fromDTO(objDto);
        obj = corServiceImpl.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{_id}").buildAndExpand(obj.get_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void deleteCor(@PathVariable String id) {
        corRepository.delete(corRepository.findBy_id(id));
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<CorDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Cor> list = corServiceImpl.findPage(page, linesPerPage, orderBy, direction);
        Page<CorDTO> listDto = list.map(CorDTO::new);
        return ResponseEntity.ok().body(listDto);
    }
}