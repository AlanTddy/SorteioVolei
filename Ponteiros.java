public class Ponteiros extends Jogador {
    private String posicao = "Ponteiro";
   
    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Ponteiros(String nome, double score, int id) {
        super(nome, score, id);
    }

    @Override
    public String toString() {
        return super.toString()  + " // Posição: "+posicao;
    }
    
}
