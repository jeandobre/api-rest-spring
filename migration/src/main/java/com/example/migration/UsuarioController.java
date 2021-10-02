package com.example.migration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public @ResponseBody List<Usuario> listAll() {
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}