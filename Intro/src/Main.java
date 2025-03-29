
public class Main {
    public static void main(String[] args) {
        Carro hb20 = new Carro();
        hb20.marca = "Hyundai";
        hb20.ano = 2010;
        hb20.modelo = "HB20";

        System.out.println(hb20.getDescricaoCarro());
    }
}