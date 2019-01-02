package br.art.sandrosantos.java.app2cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	private Double desconto;
	private Integer quantidade;
	private Double preco;


	public ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Pedido getPedido() {
		return this.id.getPedido();
	}

	public Produto getProduto() {
		return this.id.getProduto();
	}

	public ItemPedidoPK getId() {
		return this.id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return this.desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public ItemPedido id(ItemPedidoPK id) {
		this.id = id;
		return this;
	}

	public ItemPedido desconto(Double desconto) {
		this.desconto = desconto;
		return this;
	}

	public ItemPedido quantidade(Integer quantidade) {
		this.quantidade = quantidade;
		return this;
	}

	public ItemPedido preco(Double preco) {
		this.preco = preco;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ItemPedido)) {
			return false;
		}
		ItemPedido itemPedido = (ItemPedido) o;
		return Objects.equals(id, itemPedido.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, desconto, quantidade, preco);
	}

}
