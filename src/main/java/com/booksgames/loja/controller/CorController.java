package com.booksgames.loja.controller;

import com.booksgames.loja.domain.Cor;
import com.booksgames.loja.repository.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.bson.types.ObjectId;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cores")
public class CorController {
    @Autowired
    private CorRepository corRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cor> getAllCors() {
        return corRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cor getPetById(@PathVariable("id") ObjectId id) {
        return corRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Cor cor) {
        cor.set_id(id);
        corRepository.save(cor);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Cor createPet(@Valid @RequestBody Cor cor) {
        cor.set_id(ObjectId.get());
        corRepository.save(cor);
        return cor;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        corRepository.delete(corRepository.findBy_id(id));
    }
}