package com.zup.edu.gerenciadorde.albumdefigurinhas;

import com.zup.edu.gerenciadorde.albumdefigurinhas.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
