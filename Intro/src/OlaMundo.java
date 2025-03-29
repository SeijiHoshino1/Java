import java.util.Scanner;

public class OlaMundo {
    public static void main(String[] args){

        String nome = null;

        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        int valorDigitado = leitor.nextInt();

        System.out.print("Digite um nome: ");
        nome = leitor.next();

        System.out.format("Você digitou o valor %d", valorDigitado);

        System.out.format("\n%d caracteres", nome.length());
    }
}
