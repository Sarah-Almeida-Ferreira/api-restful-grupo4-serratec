package org.serratec.lojasamazonas.service;

import org.serratec.lojasamazonas.dto.UsuarioDTO;
import org.serratec.lojasamazonas.model.UsuarioModel;
import org.serratec.lojasamazonas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	private UsuarioDTO mapToDTO(UsuarioModel usuario, UsuarioDTO udto) {
		udto.setIdUsuario(usuario.getIdUsuario());
		udto.setUsername(usuario.getUsername());
		udto.setPassword(usuario.getPassword());
		udto.setPassword(encoder.encode(usuario.getPassword()));
		return udto;
	}
	
	private UsuarioModel mapToModel(UsuarioModel usuario, UsuarioDTO dto) {
		usuario.setUsername(dto.getUsername());
		usuario.setPassword(encoder.encode(dto.getPassword()));
		return usuario;
	}
	
	public UsuarioDTO buscar(Long idUsuario) {
		return usuarioRepository.findById(idUsuario)
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public List<UsuarioDTO> buscarTodos(){
		return usuarioRepository.findAll()
				.stream()
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.collect(Collectors.toList());
	}
	
	public UsuarioDTO buscarPorLogin(String username) {
		return usuarioRepository.findAll()
				.stream()
				.filter(usuario -> usuario.getUsername().equals(username))
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.findFirst()
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Long salvar(UsuarioDTO usuarioDTO) {
		UsuarioModel usuario = new UsuarioModel();
		mapToModel(usuario, usuarioDTO);
		usuarioRepository.save(usuario);
		return usuario.getIdUsuario();
	}
	
}
	

