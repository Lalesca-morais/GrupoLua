package Controller;

import Model.ClienteModel;
import Model.ProdutosModel;
import Model.VendasModel;
import Model.VendedorModel;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import java.util.Map;
public class ClienteController {
    static List<VendasModel> vendas = new ArrayList<>();
    static Map<String, ClienteModel> clientes = new HashMap<>();
    public void cadastrarCliente(String nomeC, String emailC, String cpfC) {
        try {
            if (!metodoUsadoParaValidarAEntradaDoEmail(emailC)) {
                throw new IllegalArgumentException("E-mail invalido");
            }
            boolean encontrado = false;
            for (ClienteModel produto : clientes.values()) {
                if (produto.getEmail().equals(emailC)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                throw new IllegalArgumentException("E-mail ja cadastrado para outro cliente");
            }
            if (clientes.containsKey(cpfC)) {
                throw new IllegalArgumentException("CPF ja cadastrado para outro cliente");
            }
            clientes.put(cpfC, new ClienteModel(nomeC, emailC, cpfC));
            System.out.println("Registrado com sucesso");

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    } public static boolean metodoUsadoParaValidarAEntradaDoEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
    public void listarClientes() {
        System.out.println("Lista de clientes cadastrados: ");
        for (ClienteModel cliente : clientes.values()) {
            System.out.print(cliente);
        }
    }

}
