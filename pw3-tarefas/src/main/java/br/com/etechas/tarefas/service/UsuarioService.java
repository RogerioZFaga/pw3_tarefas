package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.UsuarioCadastroDTO;
import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.mapper.UsuarioMapper;
import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService  implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO registrar(UsuarioCadastroDTO cadastro) {
        var existe = repository.findByUsername(cadastro.username());
        if (existe.isPresent()) {
            throw new RuntimeException("Nome de usuário já existe");
        }

        //Cifrar a senha
        var senhaCifrada = passwordEncoder.encode(cadastro.password());
        var entidade = mapper.toEntity(cadastro);
        entidade.setPassword(senhaCifrada);

        var salvo = repository.save(entidade);
        return mapper.toUsuarioResponseDTO(salvo);
    }

    public List<UsuarioResponseDTO> findAll() {
        return mapper.toUsuarioResponseDTOList(repository.findAll());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Nome de usuario nao encontrado"));
    }
}
