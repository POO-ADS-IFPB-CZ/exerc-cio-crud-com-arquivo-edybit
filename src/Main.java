import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ManibularPessoas gerenciador = new ManibularPessoas("pessoas.dat");
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Pessoa pessoa = new Pessoa(nome, email);
                    gerenciador.adicionarPessoas(pessoa);
                    break;
                case 2:
                    System.out.println("Pessoas cadastradas:");
                    for (Pessoa p : gerenciador.listaPessoas()) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}