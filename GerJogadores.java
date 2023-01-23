import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GerJogadores {
    Scanner a =  new Scanner(System.in);
    ArrayList<Jogador> levantadores = new ArrayList<Jogador>();
    ArrayList<Jogador> ponteiros = new ArrayList<Jogador>();
    ArrayList<Jogador> liberos = new ArrayList<Jogador>();
    private ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
    private ArrayList <Jogador> JogadorSorteio = new ArrayList<Jogador>();

    public ArrayList<Jogador> getListaJogadores() {
        return listaJogadores;
    }
    public void setListaJogadores(ArrayList<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }
    public ArrayList<Jogador> getJogadorSorteio() {
        return JogadorSorteio;
    }
    public void setJogadorSorteio(ArrayList<Jogador> jogadorSorteio) {
        JogadorSorteio = jogadorSorteio;
    }
    
    public void adcJogador(Jogador jogador){
        for (Jogador j1 : listaJogadores) {
            if (j1.getId() == jogador.getId()) {
                System.out.println("Jogador ja existente");
                return;
            }
        }
        System.out.println("Jogador adicionado com sucesso!");
        listaJogadores.add(jogador);
        if (jogador instanceof Levantador) {
            levantadores.add(jogador);
            return;
        }
        if (jogador instanceof Ponteiros){
            ponteiros.add(jogador);
            return;
        }
        if (jogador instanceof liberos) {
            liberos.add(jogador);
            return;
        }
        else{
            System.out.println("Posição nao identificada");
        }
    }

    public void rmvJogador(Jogador jogador){
        for (Jogador j1 : listaJogadores) {
            if(j1.getId() == jogador.getId()){
                System.out.println("Jogador removido");
                listaJogadores.remove(jogador);
                return;
            }
            System.out.println("Não foi possivel remover jogador");
        }
    }

    public void edtJogador(Jogador jogador){
        for (Jogador j1 : listaJogadores) {
            if (j1.getId() == jogador.getId()) {
                System.out.println("Nome atual: "+jogador.getNome());
                System.out.println("Digite o novo nome: ");
                jogador.setNome(a.nextLine());
                System.out.println("Score atual: "+jogador.getScore());
                System.out.println("Digite o novo score: ");
                jogador.setScore(a.nextInt());
            }
        }
    }

    public void verJogador(int id){
        for (Jogador j1 : listaJogadores) {
            if (j1.getId() == id) {
                System.out.println(j1);
            }
        }
        System.out.println("Jogador nao encontrado");
    }

    public void imprimirJogadores(){
        System.out.println("--Jogadores: ");
        if (listaJogadores.size() > 0) {
            for (Jogador jogador : listaJogadores) {
            System.out.println(jogador);
        }
        }else{
            System.out.println("Não há jogadores cadastrados");
        }
    }

    public void imprimirLevantadores(){
        Collections.sort(levantadores);
        System.out.println("--Levantadores: ");
        if (levantadores.size() > 0) {
            for (Jogador jogador: levantadores) {
            System.out.println(jogador);
        }
        }else{
            System.out.println("Não há levantedores cadastrados");
        } 
    }

    public void imprimirLiberos(){
        Collections.sort(liberos);
        System.out.println("--Liberos: ");
        if (liberos.size() > 0) {
            for (Jogador jogador : liberos) {
            System.out.println(jogador);
        }
        }else{
            System.out.println("Não há liberos cadastrados");
        }
    }

    public void imprimirPonteiros(){
        Collections.sort(ponteiros);
        System.out.println("--Ponteiros: ");
        if (ponteiros.size() > 0) {
            for (Jogador jogador : ponteiros) {
            System.out.println(jogador);
        }
        }else{
            System.out.println("Não há ponteiros cadastrados");
        }
    }

    public int qtdTimes(){
        int qtd;
        qtd = listaJogadores.size() / 9;
        qtd = qtd * 9;
        return qtd;
    }

    public void organizaJogadores(){
        Collections.sort(levantadores);
        Collections.sort(ponteiros);
        Collections.sort(liberos);
        int i = 0;
        for (Jogador jogador : levantadores) {
            if (i < qtdTimes()/9) {
                JogadorSorteio.add(jogador);
                i++;
            }
        }
        int a = 0;
        for (Jogador jogador : ponteiros) {
            if (a < (qtdTimes()/9) * 4) {
                JogadorSorteio.add(jogador);
                a++;
            }
        }
        int b = 0;
        for (Jogador jogador : liberos) {
            if (b < (qtdTimes()/9) * 4) {
                JogadorSorteio.add(jogador);
                b++;
            }
        }
    }

    public void dividirTimes(){
        organizaJogadores();
        int n = qtdTimes()/9;
        while (levantadores.size() < qtdTimes()/9 || ponteiros.size() < (qtdTimes()/9) * 4 || liberos.size() < (qtdTimes()/9) * 4){
            if(levantadores.size() < qtdTimes()/9){
                for(int h = levantadores.size() ; h < n ; h++){
                    levantadores.add(new Levantador(null, 7, h*100));
                }
            }
            if(levantadores.size() > qtdTimes()/9){
                for(int cont = (qtdTimes()/9) ; cont <= levantadores.size(); cont++){
                    ponteiros.add(new Ponteiros(levantadores.get(cont).getNome(), levantadores.get(cont).getScore(), cont*177));
                    levantadores.remove(cont);
                }
            }
            if (ponteiros.size() < (qtdTimes()/9) * 4) {
                for(int h = ponteiros.size() ; h < (qtdTimes()/9) * 4 ; h++){
                    ponteiros.add(new Ponteiros(liberos.get(h).getNome(), liberos.get(h).getScore(), h*101));
                    liberos.remove(h);
                }
            }
            if (liberos.size() < (qtdTimes()/9) * 4) {
                for(int h = liberos.size() ; h < (qtdTimes()/9) * 4 ; h++){
                    liberos.add(new liberos(ponteiros.get(h).getNome(), ponteiros.get(h).getScore(), h*99));
                    ponteiros.remove(h);
                }
            }
        }
        organizaJogadores();
        for(int is = 1 ; is <= n ; is++){
            int as = 0;
            System.out.println("\nTIME "+is+":");
            // organizaJogadores();
            for (Jogador jogador : JogadorSorteio) {
                if (as >= qtdTimes()){
                    break;
                }
                else{
                    for(as = 0 ; as < qtdTimes() ; as=as+n){
                        while (JogadorSorteio.get(as) == null) {
                            as++;
                        }
                        System.out.println(JogadorSorteio.get(as).getNome());
                        JogadorSorteio.set(as, null);
                    }
                }
            } 
        }
    }
}