/**
 *
 * @author ruanf
 */
package cadastro.model;


import java.util.List;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroComplemento {

    // Exibe as opções do menu do programa
    public static void opcoesMenu() {
        System.out.println("\n    Cadastro de Pessoas:");
        System.out.println("############################");
        System.out.println("\n    1 - Incluir Pessoa");
        System.out.println("    2 - Alterar Pessoa");
        System.out.println("    3 - Excluir Pessoa");
        System.out.println("    4 - Buscar pelo Id");
        System.out.println("    5 - Exibir todos");
        System.out.println("    0 - Finalizar Programa\n");
        System.out.println("############################");
    }

     // Lê a opção que o usuário digitou
    public static int lerOpcao(Scanner scanner) {
        int opcao = -1;
        boolean opcaoValida = false;
        while (!opcaoValida) {
            try {
                System.out.print("\nEscolha uma opcao: ");
                opcao = scanner.nextInt();
                opcaoValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Opcao invalida. Digite um numero valido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
        return opcao;
    }

    // Usuário deve escolher entre F Pessoa Fisica ou J Pessoa Juridica
    public static String selecionarTipo(Scanner scanner) {
        String tipo = "";
        boolean tipoValido = false;
        while (!tipoValido) {
            System.out.print("\nF - Pessoa Fisica | J - Pessoa Juridica ");
            tipo = scanner.next();
            if (tipo.equalsIgnoreCase("F") || tipo.equalsIgnoreCase("J")) {
                tipoValido = true;
            } else {
                System.out.println("Tipo invalido. Digite F ou J.");
            }
        }
        return tipo;
    }
        /* Inclusão da pessoa fisica ou juridica no sistema pelo que foi digitado, F ou J*/
        public static void incluirPessoa(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoInclusao = selecionarTipo(scanner);
        if (tipoInclusao.equalsIgnoreCase("F")) {
            incluirPessoaFisica(scanner, pessoaFisicaDAO);
        } else if (tipoInclusao.equalsIgnoreCase("J")) {
            incluirPessoaJuridica(scanner, pessoaJuridicaDAO);
        }
    }
        
        
        
    /* Alteração dapessoa física ou jurídica */
    public static void alterar(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoAlteracao = selecionarTipo(scanner);
        if (tipoAlteracao.equalsIgnoreCase("F")) {
            alterarPessoaFisica(scanner, pessoaFisicaDAO);
        } else if (tipoAlteracao.equalsIgnoreCase("J")) {
            alterarPessoaJuridica(scanner, pessoaJuridicaDAO);
        }
    }
    
     /* Solicita o id da Pessoa a ser excluida */
        public static int selecionarIdPessoa(Scanner scanner) {
        System.out.println("Digite o ID da pessoa a ser excluída:");
        int idPessoa = scanner.nextInt();
        scanner.nextLine(); 

        return idPessoa;
    }
    
   /* Exclusão da pessoa física ou jurídica */
    public static void excluir(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoExclusao = selecionarTipo(scanner);
        if (tipoExclusao.equalsIgnoreCase("F")) {
        int idPessoa = selecionarIdPessoa(scanner);
        pessoaFisicaDAO.excluir(idPessoa);
        System.out.println("Pessoa fisica excluida com sucesso.");

        listar(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
    } else if (tipoExclusao.equalsIgnoreCase("J")) {
        int idPessoa = selecionarIdPessoa(scanner);
        pessoaJuridicaDAO.excluir(idPessoa);
        System.out.println("Pessoa juridica excluida com sucesso.");

        listar(scanner, pessoaFisicaDAO, pessoaJuridicaDAO);
    }        
        
}

    /* Obter os dados da pessoa física ou jurídica pelo id */
    public static void ObterPorID(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
        String tipoObtencao = selecionarTipo(scanner);
        if (tipoObtencao.equalsIgnoreCase("F")) {
            exibirPessoaFisicaPorID(scanner, pessoaFisicaDAO);
        } else if (tipoObtencao.equalsIgnoreCase("J")) {
            exibirPessoaJuridicaPorID(scanner, pessoaJuridicaDAO);
        }
    }

    /* Listar todas as pessoas físicas ou todas as pessoas juridicas cadastradas no banco de dados */
    public static void listar(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO, PessoaJuridicaDAO pessoaJuridicaDAO) {
    String tipoListagem = selecionarTipo(scanner);
    if (tipoListagem.equalsIgnoreCase("F")) {
        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.listarTodasPessoasFisicas();
        System.out.println("""
                           Exibindo dados de Pessoa Fisica...
                           -------------------------------------------""");
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            System.out.println(pessoaFisica.toString());
        }
    } else if (tipoListagem.equalsIgnoreCase("J")) {
        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.listarTodasPessoasJuridicas();
        System.out.println("""
                           Exibindo dados de Pessoa Juridica...
                           -------------------------------------------""");
        for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
            System.out.println(pessoaJuridica.toString());
        }
    }
}



     /* Leitura de todos os dados da Pessoa fisica para incluir no cadastro */
    public static void incluirPessoaFisica(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Digite o nome da pessoa fisica: ");
        String nome = scanner.nextLine();
        pessoaFisica.setNome(nome);

        System.out.print("Digite o CPF da pessoa fisica: ");
        String cpf = scanner.nextLine();
        pessoaFisica.setCpf(cpf);
        
        System.out.print("Digite o Logradouro da pessoa fisica: ");
        String logradouro = scanner.nextLine();
        pessoaFisica.setLogradouro(logradouro);
        
        System.out.print("Digite o cidade da pessoa fisica: ");
        String cidade = scanner.nextLine();
        pessoaFisica.setCidade(cidade);
        
        System.out.print("Digite o estado da pessoa fisica: ");
        String estado = scanner.nextLine();
        pessoaFisica.setEstado(estado);
        
        System.out.print("Digite o telefone da pessoa fisica: ");
        String telefone = scanner.nextLine();
        pessoaFisica.setTelefone(telefone);
        
        System.out.print("Digite o email da pessoa fisica: ");
        String email = scanner.nextLine();
        pessoaFisica.setEmail(email);

        pessoaFisicaDAO.incluir(pessoaFisica);
        System.out.println("Pessoa fisica incluida com sucesso.");
    }

     /* Leitura de todos os dados da Pessoa Juridica para incluir no cadastro */
    public static void incluirPessoaJuridica(Scanner scanner, PessoaJuridicaDAO pessoaJuridicaDAO) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Digite o nome da pessoa jurídica: ");
        String nome = scanner.nextLine();
        pessoaJuridica.setNome(nome);

        System.out.print("Digite o CNPJ da pessoa jurídica: ");
        String cnpj = scanner.nextLine();
        pessoaJuridica.setCnpj(cnpj);

        System.out.print("Digite o Logradouro da pessoa jurídica: ");
        String logradouro = scanner.nextLine();
        pessoaJuridica.setLogradouro(logradouro);

        System.out.print("Digite a cidade da pessoa jurídica: ");
        String cidade = scanner.nextLine();
        pessoaJuridica.setCidade(cidade);

        System.out.print("Digite o estado da pessoa jurídica: ");
        String estado = scanner.nextLine();
        pessoaJuridica.setEstado(estado);

        System.out.print("Digite o telefone da pessoa jurídica: ");
        String telefone = scanner.nextLine();
        pessoaJuridica.setTelefone(telefone);

        System.out.print("Digite o email da pessoa jurídica: ");
        String email = scanner.nextLine();
        pessoaJuridica.setEmail(email);

        pessoaJuridicaDAO.incluir(pessoaJuridica);
        System.out.println("Pessoa jurídica incluída com sucesso.");
    }


    /* Altera a pessoa fisica no sistema após receber o id correto */
    public static void alterarPessoaFisica(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO) {
        System.out.print("Digite o ID da pessoa física a ser alterada: ");
        int id = scanner.nextInt();

        PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(id);
        if (pessoaFisica != null) {
            System.out.println("Pessoa física encontrada:");
            System.out.println(pessoaFisica);

            scanner.nextLine();

            System.out.print("Digite o nome da pessoa física: ");
            String nome = scanner.nextLine();
            pessoaFisica.setNome(nome);

            System.out.print("Digite o CPF da pessoa física: ");
            String cpf = scanner.nextLine();
            pessoaFisica.setCpf(cpf);

            System.out.print("Digite o Logradouro da pessoa física: ");
            String logradouro = scanner.nextLine();
            pessoaFisica.setLogradouro(logradouro);

            System.out.print("Digite o cidade da pessoa física: ");
            String cidade = scanner.nextLine();
            pessoaFisica.setCidade(cidade);

            System.out.print("Digite o estado da pessoa física: ");
            String estado = scanner.nextLine();
            pessoaFisica.setEstado(estado);

            System.out.print("Digite o telefone da pessoa física: ");
            String telefone = scanner.nextLine();
            pessoaFisica.setTelefone(telefone);

            System.out.print("Digite o email da pessoa física: ");
            String email = scanner.nextLine();
            pessoaFisica.setEmail(email);

            pessoaFisicaDAO.incluir(pessoaFisica);
            System.out.println("Pessoa física incluída com sucesso.");

            pessoaFisicaDAO.alterar(pessoaFisica);
            System.out.println("Pessoa física alterada com sucesso.");
        } else {
            System.out.println("Pessoa física não encontrada com o ID informado.");
        }
    }
    
       /* Altera a pessoa juridica no sistema após receber o id correto */
    public static void alterarPessoaJuridica(Scanner scanner, PessoaJuridicaDAO pessoaJuridicaDAO) {
        System.out.print("Digite o ID da pessoa jurídica a ser alterada: ");
        int id = scanner.nextInt();

        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(id);
        if (pessoaJuridica != null) {
            System.out.println("Pessoa jurídica encontrada:");
            System.out.println(pessoaJuridica);

            scanner.nextLine(); // Limpar o buffer do scanner

            System.out.print("Digite o nome da pessoa Juridica: ");
            String nome = scanner.nextLine();
            pessoaJuridica.setNome(nome);

            System.out.print("Digite o CNPJ da pessoa Juridica: ");
            String cnpj = scanner.nextLine();
            pessoaJuridica.setCnpj(cnpj);

            System.out.print("Digite o Logradouro da pessoa Juridica: ");
            String logradouro = scanner.nextLine();
            pessoaJuridica.setLogradouro(logradouro);

            System.out.print("Digite o cidade da pessoa Juridica: ");
            String cidade = scanner.nextLine();
            pessoaJuridica.setCidade(cidade);

            System.out.print("Digite o estado da pessoa Juridica: ");
            String estado = scanner.nextLine();
            pessoaJuridica.setEstado(estado);

            System.out.print("Digite o telefone da pessoa Juridica: ");
            String telefone = scanner.nextLine();
            pessoaJuridica.setTelefone(telefone);

            System.out.print("Digite o email da pessoa Juridica: ");
            String email = scanner.nextLine();
            pessoaJuridica.setEmail(email);

            pessoaJuridicaDAO.alterar(pessoaJuridica);
            System.out.println("Pessoa jurídica alterada com sucesso.");
        } else {
            System.out.println("Pessoa jurídica não encontrada com o ID informado.");
        }
    }


    /* Exibir todos os dados de pessoas juridicas do sistema */
    public static void listarPessoasJuridicas(PessoaJuridicaDAO pessoaJuridicaDAO) {
    List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.listarTodasPessoasJuridicas();
    System.out.println("""
                       Exibindo dados de Pessoa Juridica...
                       -------------------------------------------""");
    for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
        System.out.println(pessoaJuridica.toString());
    }
}

    /* Exibir todos os dados de pessoas fisicas do sistema */
public static void listarPessoasFisicas(PessoaFisicaDAO pessoaFisicaDAO) {
    List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.listarTodasPessoasFisicas();
    if (pessoasFisicas.isEmpty()) {
        System.out.println("Não há pessoas físicas cadastradas.");
    } else {
        System.out.println("""
                           Exibindo dados de Pessoa Fisica...
                           -------------------------------------------""");
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            System.out.println(pessoaFisica.toString());
        }
    }
}

  



   /* Exibir os dados da pessoa física com base no ID fornecido */
    public static void exibirPessoaFisicaPorID(Scanner scanner, PessoaFisicaDAO pessoaFisicaDAO) {
        System.out.println("Digite o ID da pessoa Física a ser exibida:");
        int idPessoa = scanner.nextInt();
        scanner.nextLine();

        PessoaFisica pessoaFisica = pessoaFisicaDAO.buscarPorId(idPessoa);
        if (pessoaFisica != null) {
            System.out.println(pessoaFisica); // Exibir os dados da pessoa física
        } else {
            System.out.println("Pessoa Física não encontrada com o ID informado.");
        }
    }

    /* Exibir os dados da pessoa jurídica com base no ID fornecido */
    public static void exibirPessoaJuridicaPorID(Scanner scanner, PessoaJuridicaDAO pessoaJuridicaDAO) {
        System.out.println("Digite o ID da pessoa Jurídica a ser exibida:");
        int idPessoa = scanner.nextInt();
        scanner.nextLine();

        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.buscarPorId(idPessoa);
        if (pessoaJuridica != null) {
            System.out.println(pessoaJuridica);
        } else {
            System.out.println("Pessoa Jurídica não encontrada com o ID informado.");
        }
    }
     
       
}

