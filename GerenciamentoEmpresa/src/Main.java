import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Entrar como Funcionário");
            System.out.println("2. Entrar como Administrador");
            System.out.println("3. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Entrando como Funcionário...");
                    // Lógica para funcionário
                    break;
                case 2:
                    System.out.println("Entrando como Administrador...");
                    Administrador admin = new Administrador(1, "Admin", "123456789", "Administração");
                    exibirMenuAdministrador(admin);
                    break;
                case 3:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void exibirMenuAdministrador(Administrador admin) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar Membro");
            System.out.println("2. Promover Membro");
            System.out.println("3. Modificar Membro");
            System.out.println("4. Excluir Membro");
            System.out.println("5. Ver Relatórios");
            System.out.println("6. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de novo membro:");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("CPF: ");
                    System.out.print("Função: ");
                    String funcao = scanner.next();
                    admin.adicionarMembro(id, nome);
                    break;
                case 2:
                    System.out.println("Promover membro para funcionário:");
                    System.out.print("ID do membro a ser promovido: ");
                    int idMembro = scanner.nextInt();
                    Membro membro = admin.buscarMembroPorId(idMembro);
                    if (membro != null) {
                        admin.promoverParaFuncionario(membro);
                    } else {
                        System.out.println("Membro não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Modificar membro:");
                    System.out.print("ID do membro a ser modificado: ");
                    int idMembroModificar = scanner.nextInt();
                    Membro membroModificar = admin.buscarMembroPorId(idMembroModificar);
                    if (membroModificar != null) {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.next();
                        membroModificar.setNome(novoNome);
                        System.out.println("Membro modificado com sucesso.");
                    } else {
                        System.out.println("Membro não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Excluir membro:");
                    System.out.print("ID do membro a ser excluído: ");
                    int idMembroExcluir = scanner.nextInt();
                    Membro membroExcluir = admin.buscarMembroPorId(idMembroExcluir);
                    if (membroExcluir != null) {
                        // Lógica para remover o membro da lista
                        System.out.println("Membro excluído com sucesso.");
                    } else {
                        System.out.println("Membro não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Ver relatórios:");
                    System.out.println("Relatórios disponíveis:");
                    System.out.println("1. Relatório de Vendas");
                    System.out.println("2. Relatório de Desempenho");
                    int opcaoRelatorio = scanner.nextInt();
                    if (opcaoRelatorio == 1) {
                        System.out.println("Exibindo Relatório de Vendas...");
                    } else if (opcaoRelatorio == 2) {
                        System.out.println("Exibindo Relatório de Desempenho...");
                    } else {
                        System.out.println("Opção de relatório inválida.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo do menu administrador.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}