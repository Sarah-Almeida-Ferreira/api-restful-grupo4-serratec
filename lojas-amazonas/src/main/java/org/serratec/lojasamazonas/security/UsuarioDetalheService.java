package org.serratec.lojasamazonas.security;

import java.util.ArrayList;
import java.util.Optional;

import org.serratec.lojasamazonas.model.UsuarioModel;
import org.serratec.lojasamazonas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioDetalheService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> usuario = usuarioRepository.buscarPorLogin(username);
		
		if(usuario.isPresent()) {
			UsuarioModel u = usuario.get();
			return new User(u.getUsername(), u.getPassword(), new ArrayList<>());
			
		}
		
		throw new UsernameNotFoundException("Usuario incorreto");
	}

}
