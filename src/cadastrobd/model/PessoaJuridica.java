/**
 *
 * @author ruanf
 */

/*Classe PessoaJuridica com seus geters e setters*/
package cadastrobd.model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private int id;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;

    public PessoaJuridica() {
    }

    public PessoaJuridica(int id, String nome, String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getLogradouro() {
        return logradouro;
    }

    @Override
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String getCidade() {
        return cidade;
    }

    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setIdPessoa(int idPessoa) {
        this.id = idPessoa;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Nome: " + nome + "\n" +
               "CNPJ: " + cnpj + "\n" +
               "Logradouro: " + logradouro + "\n" +
               "Cidade: " + cidade + "\n" +
               "Estado: " + estado + "\n" +
               "Telefone: " + telefone + "\n" +
               "Email: " + email + "\n" +
               "-------------------------------------------";
    }
}
