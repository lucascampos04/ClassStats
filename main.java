import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Criar 9 alunos com nomes, idades e semestres diferentes
        Alunos[] alunos = new Alunos[9];
        alunos[0] = new Alunos("Lucas", 19, "Primeiro Ano");
        alunos[1] = new Alunos("Mariana", 20, "Segundo Ano");
        alunos[2] = new Alunos("João", 18, "Terceiro Ano");
        alunos[3] = new Alunos("Maria", 21, "Segundo Ano");
        alunos[4] = new Alunos("Pedro", 19, "Quarto Ano");
        alunos[5] = new Alunos("Ana", 20, "Primeiro Ano");
        alunos[6] = new Alunos("Carlos", 22, "Terceiro Ano");
        alunos[7] = new Alunos("Beatriz", 19, "Segundo Ano");
        alunos[8] = new Alunos("Rafael", 21, "Quarto Ano");

        // Gerar notas e faltas aleatórias para cada aluno
        for (Alunos aluno : alunos) {
            aluno.gerarNotasEFaltas();
        }

        // Menu para acessar o perfil de cada aluno
        while (true) {
            System.out.println("Escolha um aluno (1 a 9) ou 0 para sair:");
            int escolha = input.nextInt();

            if (escolha >= 1 && escolha <= 9) {
                Alunos alunoEscolhido = alunos[escolha - 1];
                System.out.println("Perfil do Aluno " + alunoEscolhido.getNome());
                System.out.println("Idade: " + alunoEscolhido.getIdade());
                System.out.println("Semestre: " + alunoEscolhido.getSemestre());
                for (String s : Arrays.asList("Notas: " + String.join(", ", Arrays.stream(alunoEscolhido.getNotas()).mapToObj(Double::toString).toArray(String[]::new)), "Faltas: " + alunoEscolhido.getFaltas())) {
                    System.out.println(s);
                }

                double media = alunoEscolhido.calcularMedia();
                System.out.println("Média: " + media);

                if (alunoEscolhido.estaAprovado()) {
                    System.out.println("Situação: Aprovado");
                } else {
                    System.out.println("Situação: Reprovado");
                }
            } else if (escolha == 0) {
                System.out.println("Saindo do programa...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}