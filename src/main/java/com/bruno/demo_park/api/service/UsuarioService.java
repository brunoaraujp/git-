package com.bruno.demo_park.api.service;

import com.bruno.demo_park.api.entidades.Usuario;
import com.bruno.demo_park.api.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public Usuario salvar(Usuario usuario) {
      return usuarioRepositorio.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(long id) {
        return usuarioRepositorio.findById(id).orElseThrow(
                () -> new RuntimeException("usuario não encontrado")
                );
    }
    @Transactional
    public Usuario editarsemhar(long id, String senha) {
        Usuario user = buscarPorId(id);
        user.setSenha(senha);
        return user;
        }
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepositorio.findAll();}
}
