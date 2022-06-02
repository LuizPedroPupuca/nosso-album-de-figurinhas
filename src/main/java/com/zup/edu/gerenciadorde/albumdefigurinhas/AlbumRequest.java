package com.zup.edu.gerenciadorde.albumdefigurinhas;

import com.zup.edu.gerenciadorde.albumdefigurinhas.model.Album;
import com.zup.edu.gerenciadorde.albumdefigurinhas.model.Figurinha;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlbumRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
    @Max(100)
    @Min(10)
    private Integer numeroPaginas;

    @NotEmpty
    private List<FigurinhaRequest> figurinhas= new ArrayList<>();

    public AlbumRequest(String titulo, String descricao, Integer numeroPaginas, List<FigurinhaRequest> figurinhas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
        this.figurinhas = figurinhas;
    }

    public AlbumRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public List<FigurinhaRequest> getFigurinhas() {
        return figurinhas;
    }

    public Album toModel() {
        return new Album(titulo, descricao, numeroPaginas, this.paraFigurinhas());
    }

    public List<Figurinha> paraFigurinhas(){
        return figurinhas.stream()
                .map(f -> new Figurinha(f.getPaginaQueSeEncontra(),
                        f.getDescricao())).collect(Collectors.toList());
    }
}
