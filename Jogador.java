class Jogador implements Comparable<Jogador>{
    private String nome;
    private double score;
    private int id;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Jogador(String nome, double score, int id) {
        this.nome = nome;
        this.score = score;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nome: "+nome+" // Score: "+score;
    }
    
    @Override
    public int compareTo(Jogador o) {
        if(o.getClass().getName() == "Ponteiros"){
            if (this.score < o.getScore()) {
                return -1;
            }
            if (this.score > o.getScore()) {
                return 1;
            }
            return 0;
        }
        if (this.score < o.getScore()) {
            return 1;
        }
        if (this.score > o.getScore()) {
            return -1;
        }
        return 0;
    }
}