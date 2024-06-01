package keyllian.dev.projeto.api.dao;

import keyllian.dev.projeto.api.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceUsuario extends CrudRepository<Usuario, Integer>{
}
