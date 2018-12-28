package br.art.sandrosantos.java.app2cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.art.sandrosantos.java.app2cursomc.domain.Categoria;
import br.art.sandrosantos.java.app2cursomc.domain.Cidade;
import br.art.sandrosantos.java.app2cursomc.domain.Cliente;
import br.art.sandrosantos.java.app2cursomc.domain.Endereco;
import br.art.sandrosantos.java.app2cursomc.domain.Estado;
import br.art.sandrosantos.java.app2cursomc.domain.Pagamento;
import br.art.sandrosantos.java.app2cursomc.domain.PagamentoComBoleto;
import br.art.sandrosantos.java.app2cursomc.domain.PagamentoComCartao;
import br.art.sandrosantos.java.app2cursomc.domain.Pedido;
import br.art.sandrosantos.java.app2cursomc.domain.Produto;
import br.art.sandrosantos.java.app2cursomc.domain.enums.EstadoPagamento;
import br.art.sandrosantos.java.app2cursomc.domain.enums.TipoCliente;
import br.art.sandrosantos.java.app2cursomc.repositories.CategoriaRepository;
import br.art.sandrosantos.java.app2cursomc.repositories.CidadeRepository;
import br.art.sandrosantos.java.app2cursomc.repositories.ClienteRepository;
import br.art.sandrosantos.java.app2cursomc.repositories.EnderecoRepository;
import br.art.sandrosantos.java.app2cursomc.repositories.EstadoRepository;
import br.art.sandrosantos.java.app2cursomc.repositories.PagamentoRepository;
import br.art.sandrosantos.java.app2cursomc.repositories.PedidoRepository;
import br.art.sandrosantos.java.app2cursomc.repositories.ProdutoRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class App2CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(App2CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		// ### //

		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

		// ### //

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "13213213295", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12312312", "45645645"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "90220190", cli1, cidade1);
		Endereco e2 = new Endereco(null, "Av Matos", "105", "Sala 800", "Centro", "15694865", cli1, cidade2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		// ## //

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("10/10/2017 19:35"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

	}
}
