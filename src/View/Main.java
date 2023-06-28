package View;

import Controller.ClienteController;
import Controller.VendasController;
import Controller.VendedorController;
import Model.ProdutosModel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteController cliente = new ClienteController();
        VendedorController vendedor = new VendedorController();
        VendasController vendas = new VendasController();
        Scanner scanner = new Scanner(System.in);

        boolean encerrar = false;
        while (!encerrar) {
            try {
                System.out.println("==============================  MENU  ==============================");
                System.out.println("1. Cadastro de Cliente");
                System.out.println("2. Cadastro de Funcionario");
                System.out.println("3. Cadastrar compra");
                System.out.println("4. Lista de Funcionarios cadastrados");
                System.out.println("5. Lista de Clientes cadastrados");
                System.out.println("6. Pesquisar venda por cliente");
                System.out.println("7. Pesquisar venda por funcionario");
                System.out.println("8. Pesquisar todas as vendas");
                System.out.println("9. Sair");
                System.out.println("Digite a opção desejada:");
                int opcao = scanner.nextInt();
                switch (opcao) {

                    case 1 -> {
                        System.out.println("Digite seu nome: ");
                        scanner.nextLine();
                        String nomeCliente = scanner.nextLine();
                        System.out.println("Digite seu email: ");
                        String emailCliente = scanner.nextLine();
                        System.out.println("Digite seu CPF (apenas numeros): ");
                        String cpf = scanner.nextLine();
                        cliente.cadastrarCliente(nomeCliente, emailCliente, cpf);

                    }
                    case 2 -> {
                        System.out.println("Digite seu nome: ");
                        scanner.nextLine();
                        String nomeVendedor = scanner.nextLine();
                        System.out.println("Digite seu email: ");
                        String emailVendedor = scanner.next();
                        System.out.println("Digite seu CPF (apenas numeros): ");
                        String cpf = scanner.next();
                        vendedor.cadastrarFuncionario(nomeVendedor,emailVendedor,cpf);
                    }
                    case 3 -> {
                        vendas.produtosDisponiveis();
                        System.out.println("Qual o CPF do cliente? (Digite apenas numeros)");
                        String cpfCliente1 = scanner.next();
                        System.out.println("Qual o E-mail do funcionario?");
                        String emailVendedor1 = scanner.next();
                        System.out.println("Qual a quantidade do produto?");
                        int qntProduto = scanner.nextInt();
                        System.out.println("Qual produto deseja comprar?");
                        String nomeProduto = scanner.next();
                        vendas.cadastrarCompra(cpfCliente1,emailVendedor1,qntProduto,nomeProduto);
                    }
                    case 4 -> vendedor.listarDeFuncionarios();
                    case 5 -> cliente.listarClientes();
                    case 6 -> {
                        System.out.println("Digite o CPF do cliente (apenas numeros)");
                        String cpfCliente = scanner.next();
                        vendas.consultarVendasPorCliente(cpfCliente);
                    }
                    case 7 -> {
                        System.out.println("Digite o email do vendedor");
                        String emailVendedor = scanner.next();
                        vendas.consultarVendasPorFuncionario(emailVendedor);
                    }
                    case 8 -> vendas.consultarTodasAsVendas();
                    case 9 -> encerrar = true;
                    default -> System.out.println("Opção inválida");
                }
                System.out.println();
            } catch (NumberFormatException exception) {
                System.out.println("Entrada inválida. " + exception.getMessage());
                System.out.println();
            } catch (IllegalArgumentException | UnsupportedOperationException exception) {
                System.out.println(exception.getMessage());
                System.out.println();
            }
        }

    }
}