import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Exercício 1

        Scanner sc = new Scanner(System.in);
        String op;
        try (FileWriter arquivo = new FileWriter("produto.txt", true)){
            do {
                System.out.println("Digite o nome do produto: ");
                String produto = sc.nextLine();
                System.out.println("Digite o valor do produto: ");
                double valor = sc.nextDouble();
                sc.nextLine();
                System.out.println("Deseja continuar? (Y/N)");
                op = sc.nextLine();
                arquivo.append("Nome: ").append(produto).append(", ").append("Valor: ").append(String.valueOf(valor)).append("\n");
            } while (op.equalsIgnoreCase("Y"));

            sc.close();

        } catch (IOException e) {
            System.out.printf("Erro: " + e);
        }

        // Exercício 2

        String dados = "";
        try (FileReader arquivo = new FileReader("produto.txt")){
            int ascii = arquivo.read();
            while(ascii != -1){
                dados += (char) ascii;
                ascii = arquivo.read();
            }
        }catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado!");
        }catch (IOException erro){
            System.out.println("Erro ao fechar o arquivo!");
        }

        String[] itens = dados.split("\n");
        for (String item : itens){
            String[] valores = item.split(", ");
            String produto = valores[0].replace("Nome: ", "");
            double valor = Double.parseDouble(valores[1].replace("Valor: ", ""));
            System.out.printf("Produto: %s - Preço: R$%.2f\n", produto, valor);
        }

        // Exercício 3

        String dados = "";

        try (FileWriter arquivo = new FileWriter("texto.txt", true)) {
            arquivo.append("Maringa").append('\n');
            arquivo.append("Texto").append('\n');
            arquivo.append("Litoral").append('\n');
            arquivo.append("Caixa").append('\n');
        } catch(IOException e){
            System.out.println("Erro ao abrir arquivo: " + e.getMessage());
        }

        try (FileReader arquivo = new FileReader("texto.txt")){
            int ascii = arquivo.read();
            while(ascii != -1){
                dados += (char) ascii;
                ascii = arquivo.read();
            }
        }catch (IOException e){
            System.out.println("Arquivo não encontrado!");
        }

        String[] word = dados.split("\n");
        System.out.printf("O arquivo tem %d palavras\n", word.length);

        // Exercício 4

        Scanner sc = new Scanner(System.in);
        String op = "";

        try (FileWriter log = new FileWriter("log.txt", true)) {
            while (!op.equalsIgnoreCase("sair")) {
                System.out.println("Digite uma ação (cadastrar, excluir, consultar) ou 'sair' para encerrar:");
                op = sc.nextLine();

                if (!op.equalsIgnoreCase("sair")) {
                    System.out.println("Digite o nome do produto:");
                    String produto = sc.nextLine();

                    LocalDateTime agora = LocalDateTime.now();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    String linha = "[" + agora.format(formato) + "] Produto " + opcao + ": " + produto + "\n";
                    log.write(linha);

                    System.out.println("Ação registrada no log.");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de log.");
        }

        sc.close();

        // Exercício 5

        Scanner sc = new Scanner(System.in);
        String dados = "";
        System.out.println("1 - Ver tarefas");
        System.out.println("2 - Adicionar tarefa");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                try (FileReader file = new FileReader("tarefas.txt")) {
                    int ascii = file.read();
                    while(ascii != -1) {
                        dados += (char) ascii;
                        ascii = file.read();
                    }
                    String[] linhas = dados.split("\n");
                    for (String linha : linhas){
                        System.out.println(linha);
                    }
                }catch (IOException e){
                    System.out.println("Erro ao abrir arquivo");
                }
                break;
            case 2:
                try (FileWriter file = new FileWriter("tarefas.txt", true)) {
                    System.out.println("Digite a tarefa: ");
                    String tarefa = sc.nextLine();
                    file.append("-" + tarefa + "\n");
                }catch (IOException e) {
                    System.out.println("Erro ao escrever no arquivo");
                }
        }
    }
}
