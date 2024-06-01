package keyllian.dev.projeto.api.controller;

import keyllian.dev.projeto.api.dao.InterfaceUsuario;
import keyllian.dev.projeto.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private InterfaceUsuario dao;

    @GetMapping
    public List<Usuario> listarUsuarios () {
        return (List<Usuario>) dao.findAll();
    }

    @PostMapping
    public Usuario adicionarUsuario (@RequestBody Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    @PutMapping
    public Usuario atualizarUsuario (@RequestBody Usuario usuario) {
        return dao.save(usuario);
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario> deletarUsuario (@PathVariable Integer id) {
        Optional<Usuario> usuario = dao.findById(id);
        dao.deleteById(id);
        return usuario;
    }

}
