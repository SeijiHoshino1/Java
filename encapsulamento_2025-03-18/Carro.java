public class Carro {
    private String marca;
    private String modelo;
    private int velocidadeAtual;

    public int getVelocidadeAtual(){

    }

    public void setMarca(String novaMarca) {
        this.marca = novaMarca;
    }

    public void setModelo(String novoModelo) {
        this.modelo = novoModelo;
    }

    public void acelerar(int incremento) {

        int velocidadeAumentada = this.velocidadeAtual + incremento;

        System.out.printf("Velocidade antes de aumentar: %d", this.velocidadeAtual);


        setVelocidadeAtual(velocidadeAumentada);

    }

    public void frear(int decremento){
        int velocidadeReduzida = this.velocidadeAtual - decremento;

        setVelocidadeAtual(velocidadeReduzida);
    }

    private void setVelocidadeAtual(int velocidade){
        if (velocidade <= 180 && velocidade >= 0) {
            this.velocidadeAtual = velocidade;
        }

    }

}

