package br.savior;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		inicio ();

	}
	
	public static int inicio () {
		
		
		iniciaTabuleiro ();
		char [][] tabuleiro = new char [3][3];
		int vitoria = 0;
		
		while (vitoria == 0) {
			
			tabuleiro = vezX (tabuleiro);
			imprimirTabuleiro (tabuleiro);
			
			vitoria = checaVitoria (tabuleiro, 'X');
			if (vitoria == 1) {
				System.out.println("\nJogador X ganhou");
				return 0;
			}
			
			tabuleiro = vezO (tabuleiro);
			imprimirTabuleiro (tabuleiro);
			
			vitoria = checaVitoria (tabuleiro, 'O');
			if (vitoria == 1) {
				System.out.println("\nJogador X ganhou");
				return 0;
			}
			
		}
			
		
		return 0;
	}
	
	public static void iniciaTabuleiro () {
		
		System.out.println("_|_|_");
		System.out.println("_|_|_");
		System.out.println(" | | ");
		
	}
	
	public static int jogadaLinha () {
		Scanner scan = new Scanner(System.in);
		int linha = 0;
		
		System.out.println("Digite a linha da jogada [0 - 2]");
		linha = scan.nextInt();
		
		return linha;
	}
	
	public static int jogadaColuna () {
		Scanner scan = new Scanner(System.in);
		int coluna = 0;
		
		System.out.println("Digite a coluna da jogada [0 - 2]");
		coluna = scan.nextInt();
		
		return coluna;
	}
	
	public static char[][] vezX (char[][] tabuleiro){
		int lin = 0;
		int col = 0;
		
		System.out.println("VEZ DO X");
		lin = jogadaLinha();
		col = jogadaColuna();
		tabuleiro = jogadaX (tabuleiro, lin, col);
		
		
		return tabuleiro;
	}
	
	public static char[][] jogadaX (char[][] tabuleiro, int lin, int col){
		
		tabuleiro[lin][col] = 'X';
		
		return tabuleiro;
	}
	
	public static char[][] vezO (char[][] tabuleiro){
		int lin = 0;
		int col = 0;
		
		System.out.println("VEZ DO O");
		lin = jogadaLinha ();
		col = jogadaColuna();
		tabuleiro = jogadaO (tabuleiro, lin, col);
		
		return tabuleiro;
	}
	
	public static char [][] jogadaO (char[][] tabuleiro, int lin, int col){
		
		tabuleiro[lin][col] = 'O';
		
		return tabuleiro;
	}
	
	public static void imprimirTabuleiro (char[][] tabuleiro) {
		System.out.println(tabuleiro[0][0] + "|" + tabuleiro[0][1] + "|" + tabuleiro[0][2]);
		System.out.println("------");
		System.out.println(tabuleiro[1][0] + "|" + tabuleiro[1][1] + "|" + tabuleiro[1][2]);
		System.out.println("------");
		System.out.println(tabuleiro[2][0] + "|" + tabuleiro[2][1] + "|" + tabuleiro[2][2]);
	}
	
	public static int checaVitoria (char[][] tabuleiro, char player) {
		
		if (testeVitoria(tabuleiro, player) == 1) {
			return 1;
		}
		
		else {
			return 0;
		}
	}
	
	public static int testeVitoria (char[][] tabuleiro, char player) {
		
		if (tabuleiro[0][0] == player && tabuleiro[0][1] == player && tabuleiro[0][2] == player) {
			return 1;
		}
		
		else if (tabuleiro[1][0] == player && tabuleiro[1][1] == player &&  tabuleiro[1][2] == player) {
			return 1;
		}
		
		else if (tabuleiro[2][0] == player && tabuleiro[2][1] == player && tabuleiro[2][2] == player) {
			return 1;
		}
		
		else if (tabuleiro[0][0] == player && tabuleiro[1][0] == player && tabuleiro[2][0] == player) {
			return 1;
		}
		
		else if (tabuleiro[0][1] == player && tabuleiro[1][1] == player && tabuleiro[2][1] == player) {
			return 1;
		}
		
		else if (tabuleiro[0][2] == player && tabuleiro[1][2] == player && tabuleiro[2][2] == player) {
			return 1;
		}
		
		else if (tabuleiro[0][0] == player  && tabuleiro[1][1] == player && tabuleiro[2][2] == player) {
			return 1;
		}
		
		else if (tabuleiro[2][0] == player && tabuleiro[1][1] == player && tabuleiro[0][2] == player) {
			return 1;
		}
		
		else {
			return 0;
		}
		
	}
}
