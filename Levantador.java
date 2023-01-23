public class Levantador extends Jogador{
    private String posicao = "Levantador";

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Levantador(String nome, double score, int id) {
        super(nome, score, id);
    }

    @Override
    public String toString() {
        return super.toString()  + " // Posição: "+posicao;
    }
}
