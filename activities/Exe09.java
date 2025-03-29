import java.util.Scanner;

public class Exe09 {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        int valor1 = leitor.nextInt();

        System.out.print("Digite o primeiro valor: ");
        int valor2 = leitor.nextInt();

        if (valor1 > valor2){
            System.out.format("O primeiro valor é o maior: %d", valor1);
            System.out.format("\nO segundo valor é o menor: %d", valor2);
        }else if(valor1 < valor2){
            System.out.format("O primeiro valor é o menor: %d", valor1);
            System.out.format("\nO segundo valor é o maior: %d", valor2);
        }else{
            System.out.print("Os valores são iguais");
        }
    }
}
