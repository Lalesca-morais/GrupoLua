package Model;
public class ProdutosModel {
    private String nomeDoProduto;
    private int codigo;
    private int quantidade;
    private double preco;
    private double valorTotal;


    public ProdutosModel(String nomeDoProduto, int codigo, double preco, int quantidade) {
        this.nomeDoProduto = nomeDoProduto;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String toString() {
        return "Nome do produto: " + getNomeDoProduto() +
                "\nCodigo: " + getCodigo() +
                "\nQuantidade: " + getQuantidade() +
                "\nPreço do produto: " + getPreco() +
                "\nValor total a pagar: " + getValorTotal();
    }
}
