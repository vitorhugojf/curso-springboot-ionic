package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.domain.enums.EstadoPagamento;
import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

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
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void init() throws ParseException {
        if (false) {
            Categoria cat1 = new Categoria("Informática", "Produtos de informática em geral");
            Categoria cat2 = new Categoria("Escritório", "Produtos de Escritório em geral");
            Categoria cat3 = new Categoria("teste 1", "Produtos de Escritório em geral");
            Categoria cat4 = new Categoria("teste 2", "Produtos de Escritório em geral");
            Categoria cat5 = new Categoria("teste 3", "Produtos de Escritório em geral");
            Categoria cat6 = new Categoria("teste 4", "Produtos de Escritório em geral");
            Categoria cat7 = new Categoria("teste 5", "Produtos de Escritório em geral");
            Categoria cat8 = new Categoria("teste 6", "Produtos de Escritório em geral");
            Categoria cat9 = new Categoria("teste 7", "Produtos de Escritório em geral");

            Produto p1 = new Produto("Computador", 2000.00);
            Produto p2 = new Produto("Impressora", 800.00);
            Produto p3 = new Produto("Mouse", 80.00);

            categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
            produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

            CategoriaProduto cp1 = new CategoriaProduto(cat1, p1);
            CategoriaProduto cp2 = new CategoriaProduto(cat1, p2);
            CategoriaProduto cp3 = new CategoriaProduto(cat1, p3);
            CategoriaProduto cp4 = new CategoriaProduto(cat2, p2);

            categoriaProdutoRepository.saveAll(Arrays.asList(cp1, cp2, cp3, cp4));

            Estado es1 = new Estado("Minas Gerais", "MG");
            Estado es2 = new Estado("São Paulo", "SP");

            estadoRepository.saveAll(Arrays.asList(es1, es2));

            Cidade c1 = new Cidade("Uberlandia", es1);
            Cidade c2 = new Cidade("São Paulo", es2);
            Cidade c3 = new Cidade("Campinas", es2);

            cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

            Cliente cl1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
            cl1.getTelefones().addAll(Arrays.asList("32999332211", "32991223344"));

            Endereco e1 = new Endereco("Rua Flores", "300", "Apto 203", "Jardim", "38220834", cl1, c1);
            Endereco e2 = new Endereco("Avenida Matos", "105", "Sala 800", "Centro", "38777012", cl1, c2);

            cl1.getEnderecos().addAll(Arrays.asList(e1, e2));
            clienteRepository.save(cl1);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Pedido ped1 = new Pedido(sdf.parse("30/09/2017 10:32"), cl1, e1);
            Pedido ped2 = new Pedido(sdf.parse("10/10/2017 19:35"), cl1, e2);

            Pagamento pag1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
            ped1.setPagamento(pag1);

            Pagamento pag2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
            ped2.setPagamento(pag2);

            pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
            pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));

            ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
            ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
            ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

            itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
        }
    }
}

