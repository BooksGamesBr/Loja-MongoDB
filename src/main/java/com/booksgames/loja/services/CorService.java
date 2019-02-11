package com.booksgames.loja.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.domain.Cor;
import com.booksgames.loja.dto.CorDTO;
import com.booksgames.loja.repository.CorRepository;
import com.booksgames.loja.services.exceptions.DataIntegrityException;
import com.booksgames.loja.services.exceptions.ObjectNotFoundException;

@Service
public class CorService {

    @Autowired
    private CorRepository corRepository;

    public Cor find(Integer id) {
        Optional<Cor> obj = corRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cor.class.getName()));
    }

    public Cor insert(Cor obj) {
        obj.set_id(null);
        return corRepository.save(obj);
    }

  /*  public Cor update(Cor obj) {
        Cor newObj = find(obj.get_id(null));
        updateData(newObj, obj);
        return corRepository.save(newObj);
    }*/

    public void delete(Integer id) {
        find(id);
        try {
            corRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma cor que possui produtos");
        }
    }

    public List<Cor> findAll() {
        return corRepository.findAll();
    }

    public Page<Cor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return corRepository.findAll(pageRequest);
    }

    public Cor fromDTO(CorDTO objDto) {
        return new Cor(objDto.get_id(), objDto.getNome(),objDto.getHex());
    }

    private void updateData(Cor newObj, Cor obj) {
        newObj.setNome(obj.getNome());
    }
}
