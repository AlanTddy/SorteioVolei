public class liberos extends Jogador{
    private String posicao = "Líbero";

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public liberos(String nome, double score, int id) {
        super(nome, score, id);
    }

    @Override
    public String toString() {
        return super.toString() + " // Posição: "+posicao;
    }
}
