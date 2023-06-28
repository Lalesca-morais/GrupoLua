package Model;

public class ClienteModel {
    private String nome;
    private String email;
    private String cpf;
    public ClienteModel(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getCpf() {
        return cpf;
    }
    public String toString(){
        return "\nNome do Desafio.Cliente: "+getNome()+
                "\nE-mail: " + getEmail()+
                "\nCPF: "+getCpf();
    }
}