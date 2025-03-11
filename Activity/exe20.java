import java.util.Scanner;

public class Exe20{
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um número: ");
        int valorDigitado = leitor.nextInt();

        for(int i = 0; i <= valorDigitado; i++){
            System.out.println(valorDigitado);
        }
    }
}