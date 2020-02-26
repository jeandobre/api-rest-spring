package com.dog.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Length(min = 2, max = 30, message = "O tamanho do nome deve estar entre {min} e {max} caracteres")
	private String nome;
	
	@NotNull
	@Length(min = 2, max = 300, message = "O tamanho do endereço deve estar entre {min} e {max} caracteres")
	private String endereco;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Pedido> pedidos;

	public Cliente(Long id, String nome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public void novoPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	
}
