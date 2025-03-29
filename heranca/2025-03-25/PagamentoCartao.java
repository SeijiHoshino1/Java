public class PagamentoCartao extends Pagamento{
    String numeroCartao;

    public PagamentoCartao(double novoValor){
        super(novoValor); /* Super recebe o valor de um construtor de outra classe  */
    }
}
