import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private Map<Jogador, List<Jogador>> grafo;

    public Grafo() {
        grafo = new HashMap<>();
    }

    public void adicionarJogador(Jogador jogador) {
        grafo.put(jogador, new ArrayList<>());
    }

    public void adicionarCompatibilidade(Jogador jogador1, Jogador jogador2) {
        grafo.get(jogador1).add(jogador2);
        grafo.get(jogador2).add(jogador1);
    }

    public double calcularCompatibilidadePorClube(Jogador jogador1, Jogador jogador2, Jogador jogador3) {
        if (jogador1.getClube().equals(jogador2.getClube())) {
            return 5.0; // Compatibilidade máxima se pertencem ao mesmo clube
        } else {
            return 0.0; // Compatibilidade zero caso contrário
        }
    }

    public double calcularCompatibilidadePorNacionalidade(Jogador jogador1, Jogador jogador2, Jogador jogador3) {
        if (jogador1.getNacionalidade().equals(jogador2.getNacionalidade())) {
            return 4.0; // Alta compatibilidade se tiverem a mesma nacionalidade
        } else {
            return 1.0; // Baixa compatibilidade caso contrário
        }
    }

    public List<Jogador> encontrarJogadoresCompativeis(Jogador jogador) { // Passar parametro de lista de jogadores
        List<Jogador> compativeis = new ArrayList<>();
        for (Jogador outroJogador : grafo.keySet()) {
            if (outroJogador != jogador) {
                double compatibilidade = calcularCompatibilidade(jogador, outroJogador);
                if (compatibilidade > 2.5) {
                    compativeis.add(outroJogador);
                }
            }
        }
        return compativeis;
    }

    public double calcularPontuacaoDoTime(List<Jogador> time) {
        double pontuacao = 0.0;
        for (Jogador jogador : time) {
            pontuacao += calcularPontuacaoDoJogador(jogador);
        }
        return pontuacao;
    }

    public double calcularPontuacaoDoJogador(Jogador jogador) {
        return 85.0; // Exemplo: Pontuação fixa de 85 para todos os jogadores
    }

    public double calcularCompatibilidade(Jogador jogador1, Jogador jogador2, Jogador jogador3) { //Passar o array com a lista de jogadores
        double compatibilidadeClube = calcularCompatibilidadePorClube(jogador1, jogador2, jogador3);
        double compatibilidadeNacionalidade = calcularCompatibilidadePorNacionalidade(jogador1, jogador2, jogador3);
        return (compatibilidadeClube + compatibilidadeNacionalidade) / 2.0;
    }
}
