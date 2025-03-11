import java.util.Scanner;

public class exe29 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um nome: ");
        String valorDigitado = leitor.next();

        if (valorDigitado.toUpperCase().startsWith("A")){
            System.out.println("Começa com A");
        }else{
            System.out.println("Não começa com A");
        }
    }
}
