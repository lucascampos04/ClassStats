import java.util.Random;
import java.util.Scanner;

public class Alunos {
    private String nome;
    private int idade;
    private String semestre;
    private double[] notas;
    private int faltas;

    public Alunos(String nome, int idade, String semestre) {
        this.nome = nome;
        this.idade = idade;
        this.semestre = semestre;
        this.notas = new double[3];
        this.faltas = 0;
    }

    public void gerarNotasEFaltas() {
        Random random = new Random();
        for (int i = 0; i < notas.length; i++) {
            notas[i] = 5 + random.nextDouble() * 6; // Notas entre 5 e 10
        }
        faltas = random.nextInt(15); // Faltas entre 0 e 14
    }

    public double calcularMedia() {
        double somaNotas = 0;
        for (double nota : notas) {
            somaNotas += nota;
        }
        return somaNotas / notas.length;
    }

    public boolean estaAprovado() {
        return calcularMedia() >= 8;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSemestre() {
        return semestre;
    }

    public double[] getNotas() {
        return notas;
    }

    public int getFaltas() {
        return faltas;
    }
}