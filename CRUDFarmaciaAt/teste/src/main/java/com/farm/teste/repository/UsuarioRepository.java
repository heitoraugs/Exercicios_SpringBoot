package com.farm.teste.repository;

import com.farm.teste.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
    public Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);
    public Optional<Usuario> findByUsuario(String usuario);

    Optional<Usuario> findAllByUsuario(String userName);
}