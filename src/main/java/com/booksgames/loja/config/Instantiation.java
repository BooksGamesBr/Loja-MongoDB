package com.booksgames.loja.config;

import com.LojaApplication;
import com.booksgames.loja.documents.Cor;
import com.booksgames.loja.documents.Grupo;
import com.booksgames.loja.documents.Marca;
import com.booksgames.loja.documents.Produto;
import com.booksgames.loja.repository.CorRepository;
import com.booksgames.loja.repository.GrupoRepository;
import com.booksgames.loja.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation  implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(LojaApplication.class);

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CorRepository corRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Grupo GRUPOA =  new Grupo(null, "DESCRICAO GRUPO");
        Cor PRETO = new Cor(null, "PRETO", "XXXXX");
        Marca MARCA = new Marca(null, "MARCA X");

        Produto COMPUTADOR = new Produto(null,"COMPUTADOR", 4.1, null,
                "SIM", 82.0, "SIM", "Ativo", null,
                PRETO, null, null,
                sdf.parse("21/03/2018"));

        Produto CELULAR = new Produto(null,"CELULAR", 4.1, null,
                "SIM", 82.0, "SIM", "Ativo", null,
                PRETO, null, null,
                sdf.parse("21/03/2018"));



        corRepository.saveAll(Arrays.asList(PRETO));
        corRepository.save(PRETO);

        produtoRepository.saveAll(Arrays.asList(COMPUTADOR, CELULAR));

        produtoRepository.save(COMPUTADOR);

    }
}
