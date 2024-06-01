package keyllian.dev.projeto.api.controller;

import keyllian.dev.projeto.api.dao.InterfaceUsuario;
import keyllian.dev.projeto.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private InterfaceUsuario dao;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios () {
        return (List<Usuario>) dao.findAll();
    }
}
