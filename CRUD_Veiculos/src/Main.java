import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        crud crud = new crud();

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Listar veículos");
            System.out.println("3. Atualizar veículo");
            System.out.println("4. Remover veículo");
            System.out.println("5. Realizar manutenção");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    crud.cadastrarVeiculos();
                    break;
                case "2":
                    crud.lerVeiculos();
                    break;
                case "3":
                    crud.atualizarVeiculo(sc);
                    break;
                case "4":
                    crud.removerVeiculo(sc);
                    break;
                case "5":
                    crud.realizarManutencao(sc);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
