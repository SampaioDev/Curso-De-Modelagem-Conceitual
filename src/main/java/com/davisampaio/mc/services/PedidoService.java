package com.davisampaio.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.davisampaio.mc.domain.Categoria;
import com.davisampaio.mc.domain.Pedido;
import com.davisampaio.mc.repositories.PedidoRepository;
import com.davisampaio.mc.services.exception.DataIntegrityException;
import com.davisampaio.mc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	 }
	
	public Pedido insert (Pedido obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Pedido update(Pedido obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
}
