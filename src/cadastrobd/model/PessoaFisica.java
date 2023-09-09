/**
 *
 * @author ruanf
 */

/*Classe PessoaFisica com seus geters e setters*/
package cadastrobd.model;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private int id;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    
    public PessoaFisica() {
    }
    public PessoaFisica(int id, String nome, String cpf) {
    this.cpf = cpf;
}
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
       public void setIdPessoa(int idPessoa) {
    this.id = idPessoa;
}
    @Override
        public String toString() {
            return
                   "ID: " + id + "\n" +
                   "Nome: " + nome + "\n" +
                   "CPF: " + cpf + "\n" +
                   "Logradouro: " + logradouro + "\n" +
                   "Cidade: " + cidade + "\n" +
                   "Estado: " + estado + "\n" +
                   "Telefone: " + telefone + "\n" +
                   "Email: " + email+ "\n"+
                    "-------------------------------------------";

        }



 

}
