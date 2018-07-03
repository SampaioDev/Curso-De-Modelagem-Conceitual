package com.davisampaio.mc.domain;

import java.util.Date;

public class Pedido {
	private Integer id;
	private Date instante;
	
	private Pagamento pagamento;
	
	private Endereco enderecoDeEntrega;
	
	private Cliente cliente;
}
