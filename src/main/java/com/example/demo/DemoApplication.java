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

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void init() throws ParseException {
        Categoria cat1 = new Categoria("Informática", "Produtos de informática em geral");
        Categoria cat2 = new Categoria("Escritório", "Produtos de Escritório em geral");

        Produto p1 = new Produto("Computador", 2000.00);
        Produto p2 = new Produto("Impressora", 800.00);
        Produto p3 = new Produto("Mouse", 80.00);

        if (categoriaRepository.findAll().isEmpty() && produtoRepository.findAll().isEmpty()) {
            categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
            produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        }

        CategoriaProduto cp1 = new CategoriaProduto(cat1, p1);
        CategoriaProduto cp2 = new CategoriaProduto(cat1, p2);
        CategoriaProduto cp3 = new CategoriaProduto(cat1, p3);
        CategoriaProduto cp4 = new CategoriaProduto(cat2, p2);

        if (categoriaProdutoRepository.findAll().isEmpty()) {
            categoriaProdutoRepository.saveAll(Arrays.asList(cp1, cp2, cp3, cp4));
        }

        Estado es1 = new Estado("Minas Gerais", "MG");
        Estado es2 = new Estado("São Paulo", "SP");

        if (estadoRepository.findAll().isEmpty()) {
            estadoRepository.saveAll(Arrays.asList(es1, es2));
        }

        Cidade c1 = new Cidade("Uberlandia", es1);
        Cidade c2 = new Cidade("São Paulo", es2);
        Cidade c3 = new Cidade("Campinas", es2);

        if (cidadeRepository.findAll().isEmpty()) {
            cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
        }

        Cliente cl1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
        cl1.getTelefones().addAll(Arrays.asList("32999332211", "32991223344"));

        Endereco e1 = new Endereco("Rua Flores", "300", "Apto 203", "Jardim", "38220834", cl1, c1);
        Endereco e2 = new Endereco("Avenida Matos", "105", "Sala 800", "Centro", "38777012", cl1, c2);

        cl1.getEnderecos().addAll(Arrays.asList(e1, e2));
        if (clienteRepository.findAll().isEmpty()) {
            clienteRepository.save(cl1);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Pedido ped1 = new Pedido(sdf.parse("30/09/2017 10:32"), cl1, e1);
        Pedido ped2 = new Pedido(sdf.parse("10/10/2017 19:35"), cl1, e2);

        Pagamento pag1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pag1);

        Pagamento pag2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pag2);

        if (pedidoRepository.findAll().isEmpty() && pagamentoRepository.findAll().isEmpty()) {
            pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
            pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
        }
    }
}

