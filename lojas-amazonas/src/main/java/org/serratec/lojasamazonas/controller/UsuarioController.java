package org.serratec.lojasamazonas.controller;

import org.serratec.lojasamazonas.dto.UsuarioDTO;
import org.serratec.lojasamazonas.security.JwtUtil;
import org.serratec.lojasamazonas.security.UsuarioAuthenticationRequest;
import org.serratec.lojasamazonas.security.UsuarioDetalheService;
import org.serratec.lojasamazonas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioDetalheService usuarioDetalheService;

	@GetMapping
	public ResponseEntity<UsuarioDTO> buscarPorLogin(@RequestParam String username) {
		return ResponseEntity.ok(usuarioService.buscarPorLogin(username));
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(usuarioService.buscar(idUsuario));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Long> salvar(@RequestBody UsuarioDTO udto) {
		return ResponseEntity.ok(usuarioService.salvar(udto));
	}

	@PostMapping("/authenticate")
	public String criarAutenticacao(@RequestBody UsuarioAuthenticationRequest usuario) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
		} catch (Exception e) {
			throw new Exception("Senha incorreta", e);
		}
		UserDetails usuarioDetalhe = usuarioDetalheService.loadUserByUsername(usuario.getUsername());
		String token = jwtUtil.generateToken(usuarioDetalhe);
		return token;
	}

}
