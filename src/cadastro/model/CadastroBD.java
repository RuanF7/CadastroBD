/**
 *
 * @author ruanf
 */
package cadastro.model;
import java.util.Scanner;

public class CadastroBD {

    /*Opções do Menu, até uma opção válida ser escolhida*/
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

            boolean continuar = true;
            while (continuar) {
                CadastroComplemento.opcoesMenu();

                int opcao = CadastroComplemento.lerOpcao(scanner);

                switch (opcao) {
                    case 1->    {
                                CadastroComplemento.incluirPessoa
                                (scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                    }
                    case 2 -> {
                                CadastroComplemento.alterar
                                (scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                    break;
                    }
                    case 3 -> {
                                CadastroComplemento.excluir
                                (scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                    break;
                    }
                    case 4 -> {
                                CadastroComplemento.ObterPorID
                                (scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                    break;
                    }
                    case 5 -> {
                                CadastroComplemento.listar
                                (scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
                    break;
                    }
                    case 0 -> continuar = false;
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}

