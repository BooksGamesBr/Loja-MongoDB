package com.booksgames.loja.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

import com.booksgames.loja.documents.Pets;
import com.booksgames.loja.repository.PetsRepository;
import com.booksgames.loja.services.PetsService;
import com.booksgames.loja.responses.Response;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetsRepository petsRepository;

    @Autowired
    private PetsService petsService;

  /*  @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        return petsRepository.findAll();
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Response<List<Pets>>> listarTodos() {
        return ResponseEntity.ok(new Response<List<Pets>>(this.petsService.listarTodos()));
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") ObjectId id) {
        return petsRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
        pets.set_id(id);
        petsRepository.save(pets);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pets createPet(@Valid @RequestBody Pets pets) {
        pets.set_id(ObjectId.get());
        petsRepository.save(pets);
        return pets;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        petsRepository.delete(petsRepository.findBy_id(id));
    }*/
}