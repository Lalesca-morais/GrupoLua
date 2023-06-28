package Controller;

import Model.VendasModel;
import Model.VendedorModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendedorController {
    public static Map<String, VendedorModel> vendedores = new HashMap<>(2);
    public void cadastrarFuncionario(String nomeF, String emailF, String cpfF) {
        vendedores.put("raissa@gmail.com", new VendedorModel("Raissa", "raissa@gmail.com", "1234"));
        try {

            if (!metodoUsadoParaValidarAEntradaDoEmail(emailF)) {
                throw new IllegalArgumentException("E-mail invalido");
            }
            if (vendedores.containsKey(emailF)) {
                throw new IllegalArgumentException("E-mail ja cadastrado para outro funcionario");
            }

            String cpfVendedor = String.valueOf(Integer.parseInt(cpfF));
            boolean encontrado = false;
            for (VendedorModel produto : vendedores.values()) {
                if (produto.getCpf().equals(cpfF)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                throw new IllegalArgumentException("CPF já cadastrado para outro funcionario");
            }

            vendedores.put(emailF, new VendedorModel(nomeF, emailF, cpfVendedor));
            System.out.println("Registrado com sucesso");
            if (vendedores.size() > 1) {
                System.out.println("Lista de vendedores completa");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println();
        }
    }public static boolean metodoUsadoParaValidarAEntradaDoEmail(String email) {
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    return email.matches(regex);
}
    public void listarDeFuncionarios() {
        System.out.println("Lista de funcionarios cadastrados: ");
        for (VendedorModel vendedor : vendedores.values()) {
            System.out.println(vendedor);
        }
    }
}
