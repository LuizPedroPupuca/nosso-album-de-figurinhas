package com.zup.edu.gerenciadorde.albumdefigurinhas;

import com.zup.edu.gerenciadorde.albumdefigurinhas.model.Figurinha;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FigurinhaRequest {

    @NotBlank
    private Integer paginaQueSeEncontra;

    @NotBlank
    private String descricao;

    public FigurinhaRequest(Integer paginaQueSeEncontra, String descricao) {
        this.paginaQueSeEncontra = paginaQueSeEncontra;
        this.descricao = descricao;
    }

    public FigurinhaRequest() {
    }

    public Integer getPaginaQueSeEncontra() {
        return paginaQueSeEncontra;
    }

    public String getDescricao() {
        return descricao;
    }

}
