package com.booksgames.loja.controllers;

import com.booksgames.loja.documents.Grupo;
import com.booksgames.loja.repository.GrupoRepository;
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
@RequestMapping("/grupos")
public class GrupoController {
    @Autowired
    private GrupoRepository grupoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Grupo getPetById(@PathVariable("id") ObjectId id) {
        return grupoRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Grupo grupo) {
        grupo.set_id(id);
        grupoRepository.save(grupo);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Grupo createPet(@Valid @RequestBody Grupo grupo) {
        grupo.set_id(ObjectId.get());
        grupoRepository.save(grupo);
        return grupo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        grupoRepository.delete(grupoRepository.findBy_id(id));
    }
}