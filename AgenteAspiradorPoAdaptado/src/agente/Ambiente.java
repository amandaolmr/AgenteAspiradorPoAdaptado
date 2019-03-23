package agente;

public class Ambiente {

    public static int tamanho = (int) (Math.random() * 18 + 1);//tamanho alatorio entre 0 e 10
    public static int posicaoAtual = (int) (Math.random() * tamanho);//Posicao aleatorio
    public static int ambiente[];
    public static int inicio;
    public static int fim;

    public static void Ambiente() {

        ambiente = new int[tamanho];
        System.out.println("TAMANHO DO AMBIENTE: " + tamanho);
        for (int i = 0; i < tamanho; i++) {
            ambiente[i] = (int) (Math.random() * 2);//posicao aleatoria (0,1)
            System.out.print("[ " + ambiente[i] + " ]");
        }

        System.out.println("\nA Posicao do Agente: [ " + posicaoAtual + " ]");
    }

    public static int percepcao(int posicaoAt) {
        //A PERCEPÇÃO PARA SABER SE TA LIMPO OU SUJO
        Acao movimentoAcao;
        if (ambiente[posicaoAt] == 1) {
            System.out.println("Percepção-> AMBIENTE SUJO: " + ambiente[posicaoAt]);
            movimentoAcao = Acao.LIMPAR;
            System.out.println(movimentoAcao);
            System.out.println("Limpando...");
            movimentoAcao = Acao.ANDAR;
            System.out.println(movimentoAcao);
        } else if (ambiente[posicaoAt] == 0) {
            System.out.println("\nPercepção-> AMBIENTE LIMPO: " + ambiente[posicaoAt]);
            movimentoAcao = Acao.ANDAR;
            System.out.println(movimentoAcao);
        }
        return posicaoAt;
    }

    //ainda falta ajeitar eu acho
    public static void atualizaMemoria(int posicaoAt) {
        System.out.println("\nAtualiza Memória :");

        for (int i = 0; i < tamanho; i++) {
            if (ambiente[posicaoAt] == 1) {
                ambiente[posicaoAt] = 0;
            }
            System.out.print("[ " + ambiente[i] + " ]");
        }
    }

    public static boolean posicoesDireita = false;
    public static boolean posicoesEsquerda = false;

    public static void sensorLocalizacaoDireita() {
//		System.out.println("\nVERIFICA A DIREITA: " + quantPosicoesDireita);

        int proximaPosicao = posicaoAtual + 1;
        int posAtual = posicaoAtual;
        int posicaoAtualNoFinal = 0;
        fim = tamanho - 1;
        int posicaoLimpa = 0;
        //CONTA AS POSIÇÕES DA DIREITA
        for (int i = posAtual; i < fim; i++) {
            System.out.println("POSICAO ATUAL DO AGENTE " + proximaPosicao);
            if (posAtual < proximaPosicao) {
                posicoesDireita = true;
                if (posicoesDireita) {
                    System.out.println("\nPERCEBE AMBIENTE DIREITA ---->");
                    posicaoLimpa = percepcao(proximaPosicao);

                    proximaPosicao++;
                    atualizaMemoria(posicaoLimpa);
                    if (!posicoesDireita) {
                        posicoesEsquerda = true;
                    }
                }
            } else {
                posicoesDireita = false;
            }
            posicaoAtualNoFinal = proximaPosicao;
        }

        for (int i = posicaoAtualNoFinal; i > proximaPosicao - 1;) {
            if (posicaoAtualNoFinal > proximaPosicao - 1) {
                proximaPosicao--;
                posicaoAtualNoFinal--;
            }
            System.out.println("POSIÇÃO ATUAL: " + posicaoAtualNoFinal);
            if (posicaoAtualNoFinal == posAtual) {
                posAtual = posicaoAtualNoFinal;
                break;
            }
        }
    }

    public static void sensorLocalizacaoEsquerda() {

        int posicaoAnterior = posicaoAtual - 1;
        int posAtual = posicaoAtual;
        inicio = 0;
        int posicaoLimpa = 0;
        //CONTA AS POSIÇÕES DA ESQUERDA
        for (int i = posAtual; i > inicio; i--) {
            System.out.println("POSICAO ATUAL DO AGENTE " + posicaoAnterior);
            if (posAtual > posicaoAnterior) {
                posicoesEsquerda = true;

                if (posicoesEsquerda) {
                    posicoesEsquerda = true;
                    System.out.println("\nPERCEBE AMBIENTE ESQUERDA <----");
                    posicaoLimpa = percepcao(posicaoAnterior);

                    posicaoAnterior--;
                    atualizaMemoria(posicaoLimpa);
                    if (!posicoesEsquerda) {
                        posicoesDireita = true;
                    }
                }
            } else {
                posicoesEsquerda = false;
            }
        }
        System.out.println("\n" + Acao.PARAR);
    }

    public static void main(String[] args) {
        Ambiente();
        atualizaMemoria(posicaoAtual);
        System.out.println("\n");
        sensorLocalizacaoDireita();
        sensorLocalizacaoEsquerda();
    }
}