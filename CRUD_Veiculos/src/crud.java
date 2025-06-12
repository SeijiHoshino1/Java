import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class crud {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void lerVeiculos(){
        String dados = "";
        try (FileReader arquivo = new FileReader("veiculos.txt")){
            int ascii = arquivo.read();
            while (ascii != -1){
                dados += (char) ascii;
                ascii = arquivo.read();
            }
            String[] itens = dados.split("\n");
            for (String item : itens){
                String[] valores = item.split(";");
                String tipo = valores[0];
                String marca = valores[1];
                String modelo = valores[2];
                String placa = valores[3];

                if (tipo.equalsIgnoreCase("Carro")) {
                    veiculos.add(new Carro(placa, marca, modelo));
                } else if (tipo.equalsIgnoreCase("Moto")) {
                    veiculos.add(new Moto(placa, marca, modelo));
                }

                System.out.printf("Tipo: %s - Marca: %s - Modelo: %s - Placa: %s", tipo, marca, modelo, placa);
            }
        }catch (IOException erro){
            System.out.println("Erro ao ler o arquivo");
        }
    }

    public void cadastrarVeiculos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tipo (Carro/Moto): ");
        String tipo = sc.nextLine();
        System.out.println("Marca: ");
        String marca = sc.nextLine();
        System.out.println("Modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Placa: ");
        String placa = sc.nextLine();

        Veiculo v;
        if (tipo.equalsIgnoreCase("Carro")){
            v = new Carro(placa, marca, modelo);
        } else {
            v = new Moto(placa, marca, modelo);
        }
        veiculos.add(v);

        try(FileWriter arquivo = new FileWriter("veiculos.txt", true)){
            arquivo.append(tipo)
                    .append(";")
                    .append(marca)
                    .append(";")
                    .append(modelo)
                    .append(";")
                    .append(placa)
                    .append("\n");

            System.out.println("Veículo cadastrado com sucesso!");
        }catch(IOException erro){
            System.out.println("Erro ao abrir o arquivo");
        }
    }

    public void atualizarVeiculo(Scanner sc) {
        System.out.print("Placa do veículo: ");
        String placa = sc.nextLine();
        Veiculo v = buscarPorPlaca(placa);
        if (v == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        System.out.print("Nova marca: ");
        v.marca = sc.nextLine();
        System.out.print("Novo modelo: ");
        v.modelo = sc.nextLine();

        try (FileWriter arquivo = new FileWriter("veiculos.txt")) {
            for (Veiculo veiculo : veiculos) {
                String tipo = veiculo.getClass().getSimpleName();
                arquivo.append(tipo)
                        .append(";")
                        .append(veiculo.getPlaca())
                        .append(";")
                        .append(veiculo.marca)
                        .append(";")
                        .append(veiculo.modelo)
                        .append("\n");
            }
        } catch (IOException erro) {
            System.out.println("Erro ao salvar os veículos.");
        }
        System.out.println("Veículo atualizado.");
    }

    public void removerVeiculo(Scanner sc) {
        System.out.print("Placa do veículo: ");
        String placa = sc.nextLine();
        Veiculo v = buscarPorPlaca(placa);
        if (v == null) {
            System.out.println("Veículo não encontrado.");
        } else {
            veiculos.remove(v);
            System.out.println("Veículo removido.");
        }
    }

    public void realizarManutencao(Scanner sc) {
        System.out.print("Placa do veículo: ");
        Veiculo v = buscarPorPlaca(sc.nextLine());
        try {
            OperacoesVeiculo op = (OperacoesVeiculo) v;
            op.realizarManutencao();
        } catch (NullPointerException e) {
            System.out.println("Veículo não encontrado ou não suporta manutenção.");
        }
    }

    private Veiculo buscarPorPlaca(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
}
