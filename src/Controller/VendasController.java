package Controller;

import Model.ClienteModel;
import Model.ProdutosModel;
import Model.VendasModel;
import Model.VendedorModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendasController {
    static List<ProdutosModel> produtos = new ArrayList<>();
    List<VendasModel> vendas = new ArrayList<>();
    public void cadastrarCompra(String cpfC, String emailF, int quantidade, String nomeDoProduto) {
        ProdutosModel celular1 = new ProdutosModel("Celular1", 1233211, 2500, 0);
        ProdutosModel celular2 = new ProdutosModel("Celular2", 1876211, 2799, 0);
        ProdutosModel celular3 = new ProdutosModel("Celular3", 1233644, 3179, 0);
        produtos.add(celular1);
        produtos.add(celular2);
        produtos.add(celular3);
        try {
            if (!ClienteController.clientes.containsKey(cpfC)) {
                throw new IllegalArgumentException("Cliente não cadastrado");
            }
            if (!VendedorController.vendedores.containsKey(emailF)) {
                throw new IllegalArgumentException("Vendedor não cadastrado");
            }
            for (ProdutosModel produto : produtos) {
                produto.setQuantidade(quantidade);
                produto.setValorTotal(produto.getQuantidade() * produto.getPreco());
            }
            for (ProdutosModel produto : produtos) {
                System.out.println(produto);
                System.out.println();
            }
            ProdutosModel produtoTemporario = null;
            for (ProdutosModel produto : produtos) {
                if (produto.getNomeDoProduto().equals(nomeDoProduto)) {
                    produtoTemporario = produto;
                }
            }
            if (!produtos.contains(produtoTemporario)) {
                throw new IllegalArgumentException("Produto não cadastrado");
            }
            System.out.println("VENDA CADASTRADA COM SUCESSO!");

            LocalDate data = LocalDate.now();

            VendedorModel vendedor = VendedorController.vendedores.get(emailF);
            ClienteModel cliente = ClienteController.clientes.get(cpfC);
            VendasModel venda = new VendasModel(produtoTemporario, vendedor, cliente, data);

            vendas.add(venda);
            System.out.println();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println();
        }
}
    public void consultarVendasPorCliente(String cpfC) {
        for (VendasModel venda : vendas) {
            ClienteModel clienteAux = venda.getCliente();
            if (clienteAux.getCpf().equals(cpfC)) {
                System.out.println(venda);
            }
        }
    }

    public void consultarVendasPorFuncionario(String emailF) {
        for (VendasModel venda : vendas) {
            VendedorModel vendedorAux = venda.getVendedor();
            if (vendedorAux.getEmail().equals(emailF)) {
                System.out.println(venda);
            }
        }
    }

    public void consultarTodasAsVendas() {
        System.out.println("Lista de vendas finalizadas");
        for (VendasModel venda : vendas) {
            System.out.println(venda);
        }
    }

}
