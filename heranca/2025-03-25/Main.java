import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int opcoes = 0;

        do{
            System.out.println("------------ Pagamento ------------");
            System.out.println("1 - Pagamento de boleto");
            System.out.println("2 - Pagamento no cartão");
            System.out.println("9 - Sair");
            leitor.nextInt();

            if (opcoes == 1){

            }

        }while (opcoes != 9);

        PagamentoBoleto novoTenis = new PagamentoBoleto(
                19.90,
                "234324243647547"
        );

        PagamentoCartao placaVideo = new PagamentoCartao(499.90);
        placaVideo.numeroCartao = "53453532462";
    }
}