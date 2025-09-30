package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.UsuarioCadastroDTO;
import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.mapper.UsuarioMapper;
import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioResponseDTO registrar(UsuarioCadastroDTO cadastro) {
        var username = repository.findByUsername(cadastro.username());
        if (username.isPresent()) {
            throw new RuntimeException("Nome de Usuário já existe");
        }
        return usuarioMapper.toUsuarioResponseDTO();
    }
}
