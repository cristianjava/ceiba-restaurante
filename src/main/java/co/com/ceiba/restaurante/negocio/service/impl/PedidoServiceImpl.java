package co.com.ceiba.restaurante.negocio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.restaurante.negocio.entity.PedidoEntity;
import co.com.ceiba.restaurante.negocio.model.Pedido;
import co.com.ceiba.restaurante.negocio.repository.PedidoRepository;
import co.com.ceiba.restaurante.negocio.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PedidoService#guardarPedido(co.com.ceiba.restaurante.negocio.model.Pedido)
	 */
	@Override
	public void guardarPedido(PedidoEntity pedido) {
		// Se valida la logica de negocio
		
		// Se guarda en PEDIDO
		pedidoRepository.save(pedido);
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PedidoService#findAll()
	 */
	@Override
	public List<PedidoEntity> findAll() {
		return pedidoRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PedidoService#consultarUltimoPedidoPreparar()
	 */
	@Override
	public PedidoEntity consultarUltimoPedidoPreparar() {
		return pedidoRepository.findPrimerPedidoPorPreparar();
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PedidoService#entregarPedido(co.com.ceiba.restaurante.negocio.model.Pedido)
	 */
	@Transactional
	@Override
	public void entregarPedido(Pedido pedido) {
		pedidoRepository.entregarPedido(pedido.getId());
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PedidoService#consultarPedidoId(long)
	 */
	@Override
	public PedidoEntity consultarPedidoId(long id) {
		return pedidoRepository.findByPk(id);
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PedidoService#consultarProximoDespachoMesa()
	 */
	@Override
	public PedidoEntity consultarProximoDespachoMesa() {
		return pedidoRepository.consultarProximoDespachoMesa();
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PedidoService#entregarDespachoPedido(co.com.ceiba.restaurante.negocio.model.Pedido)
	 */
	@Transactional
	@Override
	public void entregarDespachoPedido(Pedido pedido) {
		pedidoRepository.entregarDespachoPedido(pedido.getId());
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ceiba.restaurante.negocio.service.PedidoService#pagarPedido(co.com.ceiba.restaurante.negocio.model.Pedido)
	 */
	@Transactional
	@Override
	public void pagarPedido(Pedido pedido) {
		pedidoRepository.pagarPedidoPk(pedido.getId());
	}

}
