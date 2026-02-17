public class Candidato {
    private String nome;
    private int numero;
    private int votos;

    public Candidato(String nome, int numero){
        this.votos = 0;
        this.nome = nome;
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }
    
    public String getNome(){
        return nome;
    }

    public int getVotos(){
        return votos;
    }

    public void votar(){
        this.votos++;
    }
}
