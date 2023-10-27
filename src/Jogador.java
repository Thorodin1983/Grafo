public class Jogador {
    private String nome;
    private String clube;
    private String nacionalidade;

    public Jogador(String nome, String clube, String nacionalidade) {
        this.nome = nome;
        this.clube = clube;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getClube() {
        return clube;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}
