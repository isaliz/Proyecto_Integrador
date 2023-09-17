package com.proyectoIntegradorSpring.security;

import com.proyectoIntegradorSpring.entity.Usuario;
import com.proyectoIntegradorSpring.entity.UsuarioRole;
import com.proyectoIntegradorSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class CargadorInicial implements ApplicationRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // crear un usuario
        // guardarlo en bdd
        // necesito la password
        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
        String clave = cifrador.encode("isabel");
        String clave2 = cifrador.encode("user");
        String clave3 = cifrador.encode("miguel");
        System.out.println("CLAVE CIFRADA: " + cifrador);
        Usuario usuario1 = new Usuario("Isabel Lizarralde", "isabel", "isabel@gmail.com", clave, UsuarioRole.ADMIN);
        Usuario usuario2 = new Usuario("Miguel Buitrago", "miguel", "miguel@gmail.com", clave2, UsuarioRole.ADMIN);
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

    }
}

