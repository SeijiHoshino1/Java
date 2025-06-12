public class Carro extends Veiculo implements OperacoesVeiculo{
    public Carro(String marca, String modelo, String placa){
        super(marca, modelo, placa);
    }

    @Override
    public void exibirDados() {
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: "+modelo);
        System.out.println("Placa: "+placa);
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Manutenção realizada no carro de placa " + placa);
    }
}
