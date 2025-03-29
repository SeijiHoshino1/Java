public class PagamentoBoleto extends Pagamento{
    private String codigoBarras;

    public PagamentoBoleto(double novoValor, String novoCodigoBarras){
        super(novoValor); /* Super recebe o valor de um construtor de outra classe */
        /* Chama o construtor da classe que  esta sendo estendido */
        this.codigoBarras = novoCodigoBarras;
    }

}
