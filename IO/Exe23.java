import java.util.Scanner;

public class Exe23 {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int resultado = 0;

        for(int index = 0; index < 10; index++){
            System.out.format("Digite o valor %d: ",index+1);
            int valorDigitado = leitor.nextInt();
            resultado += valorDigitado;

            System.out.format("O resultado dos valores digitados é %d", resultado);
        }
    }
}