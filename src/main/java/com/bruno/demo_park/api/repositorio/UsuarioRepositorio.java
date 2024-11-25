package com.bruno.demo_park.api.repositorio;

import com.bruno.demo_park.api.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio  extends JpaRepository<Usuario, Long>{



}


