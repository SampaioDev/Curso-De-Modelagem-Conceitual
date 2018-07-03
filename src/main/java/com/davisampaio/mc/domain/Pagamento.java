package com.davisampaio.mc.domain;

import com.davisampaio.mc.domain.enums.EstadoPagamento;

public class Pagamento {
	private Integer id;
	private EstadoPagamento estado;
	
	private Pedido pedido;
}
