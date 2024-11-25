package com.bruno.demo_park.api.web.controler;

import com.bruno.demo_park.api.entidades.Usuario;
import com.bruno.demo_park.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioControler {

    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Usuario>criacaoUsuario(@RequestBody Usuario usuario) {
    Usuario user = usuarioService.salvar(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario>getByid(@PathVariable long id) {
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok().body(user);

    }


    @PatchMapping("/{id}")
    public ResponseEntity<Usuario>updatetsenha(@PathVariable long id, @RequestBody Usuario usuario) {
        Usuario user = usuarioService.editarsemhar(id,usuario.getSenha());
        return ResponseEntity.ok(user);

    }

    @GetMapping
    public ResponseEntity<List<Usuario>>findAll() {
       List <Usuario >users = usuarioService.buscarTodos();
        return ResponseEntity.ok().body(users);

    }

}
