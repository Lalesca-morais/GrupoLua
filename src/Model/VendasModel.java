package Model;

import java.time.LocalDate;

public class VendasModel {

    public LocalDate data;
    public ProdutosModel produto;
    public VendedorModel vendedor;
    public ClienteModel cliente;

    public VendasModel(ProdutosModel produto, VendedorModel vendedor, ClienteModel cliente, LocalDate data) {
        this.produto = produto;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.data = data;
    }

    public VendedorModel getVendedor() {
        return vendedor;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "O vendedor (a) " + vendedor.getNome() +
                " realizou uma venda para o (a) cliente " + cliente.getNome() +
                ", do produto " + produto.getNomeDoProduto() +
                ", no valor de " + produto.getValorTotal() +
                ", no dia " + getData();

    }
}
