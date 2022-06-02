package com.zup.edu.gerenciadorde.albumdefigurinhas.model;

import com.zup.edu.gerenciadorde.albumdefigurinhas.FigurinhaRequest;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    @Positive
    @Max(100)
    @Min(10)
    private Integer numeroPaginas;

    @OneToMany(mappedBy = "album", cascade = {CascadeType.PERSIST})
    private List<Figurinha> figurinhas= new ArrayList<>();


    public Album(String titulo, String descricao, Integer numeroPaginas, List<Figurinha> figurinhas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
        this.figurinhas.addAll(figurinhas);
        this.figurinhas.stream().forEach(figurinha -> figurinha.setAlbum(this));

    }

    /**
     * @deprecated construtor para uso exclusivo do hibernate
     */
    @Deprecated
    public Album(){

    }

    public Long getId() {
        return id;
    }
}
