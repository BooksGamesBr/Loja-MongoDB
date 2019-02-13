package com.booksgames.loja.services.impl;


import java.util.List;
import java.util.Optional;

import com.booksgames.loja.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.booksgames.loja.documents.Produto;
import com.booksgames.loja.dto.ProdutoDTO;
import com.booksgames.loja.repository.ProdutoRepository;
import com.booksgames.loja.services.exceptions.DataIntegrityException;
import com.booksgames.loja.services.exceptions.ObjectNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findId(String _id) {
        Optional<Produto> obj = produtoRepository.findById(_id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + _id + ", Tipo: " + Produto.class.getName()));
    }

    @Transactional
    public Produto insert(Produto obj) {
        obj.set_id(null);
        return produtoRepository.save(obj);
    }

    public Produto update(String _id) {
        Produto newObj = findId(_id);
        updateData(newObj, newObj);
        return produtoRepository.save(newObj);
    }

    public void delete(String _id) {
        findId(_id);
        try {
            produtoRepository.deleteById(_id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma produto que possui produtos");
        }
    }

    public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return produtoRepository.findAll(pageRequest);
    }

    public String _id;

    public Produto fromDTO(ProdutoDTO objDto) {
        return new Produto(
                objDto.get_id(),
                objDto.getDescricao(),
                objDto.getPreco(),null,null,
               /* objDto.getGrupoDTO().getNome(),
                objDto.getCorDTO().getNome(),*/
                objDto.getDatacadastro());
    }

    private void updateData(Produto newObj, Produto obj) {
        newObj.setCor(obj.getCor());
        newObj.setDescricao(obj.getDescricao());
        newObj.setGrupo(obj.getGrupo());
        newObj.setPreco(obj.getPreco());
        newObj.setDatacadastro(obj.getDatacadastro());
    }
  }
