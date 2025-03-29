import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Carro novoCarro = new Carro();

        novoCarro.setMarca("Fiat");
        novoCarro.setModelo("Uno");

        System.out.printf("\n Digite a velocidade a ser aumentada: ");
        int velocidade = leitor.nextInt();
        novoCarro.acelerar(velocidade);

        System.out.printf("\n Digite a velocidade a ser reduzida: ");
        int velocidade = leitor.nextInt();
        novoCarro.frear(velocidade);
    }
}