import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Jogador1", "ClubeA", "NacionalidadeX");
        Jogador jogador2 = new Jogador("Jogador2", "ClubeA", "NacionalidadeX");
        Jogador jogador3 = new Jogador("Jogador3", "ClubeA", "NacionalidadeO");

        Grafo grafo = new Grafo();
        grafo.adicionarJogador(jogador1);
        grafo.adicionarJogador(jogador2);
        grafo.adicionarJogador(jogador3);

        grafo.adicionarCompatibilidade(jogador1, jogador2);
        grafo.adicionarCompatibilidade(jogador2, jogador3);

        List<Jogador> jogadoresCompativeis = grafo.encontrarJogadoresCompativeis(jogador1);

        System.out.println("Jogadores compatíveis com " + jogador1.getNome() + ":");
        for (Jogador jogador : jogadoresCompativeis) {
            System.out.println(jogador.getNome());
        }

        double pontuacaoTime = grafo.calcularPontuacaoDoTime(jogadoresCompativeis);
        System.out.println("Pontuação do time: " + pontuacaoTime);
    }
}