package com.zup.edu.gerenciadorde.albumdefigurinhas.model;

import javax.persistence.*;

@Entity
public class Figurinha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer paginaQueSeEncontra;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne(optional = false)
    private Album album;

    public Figurinha(Integer paginaQueSeEncontra, String descricao) {
        this.paginaQueSeEncontra = paginaQueSeEncontra;
        this.descricao = descricao;
    }

    /**
     * @deprecated construtor apenas para uso do hibernate
     */
    @Deprecated
    public Figurinha() {
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
