package br.savior;

import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		inicio ();

	}
	
	public static void inicio () {
		
		if (numJog() == 1) {
			singleplayer ();
		}
		
		else {
			multiplayer ();
		}
	}
	
	public static char[][] iniciaTabuleiro () {
		char [][] tabuleiro = new char [3][3];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
		return tabuleiro;
	}
	
	public static int numJog () {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o número de jogadores: ");
		int num = scan.nextInt();
		
		if (num > 2 || num < 1) {
			System.out.println("Valor inválido digite novamente");
			numJog ();
		}
		
		else 
			return num;
		
		return num;
		
	}
	
	public static void singleplayer () {
		char [][] tabuleiro = iniciaTabuleiro ();
		int vitoria = 0;
		
		if (escolhaXO() == 'X') {
			
			while (vitoria == 0) {
			System.out.println("Sua vez:");
			imprimirTabuleiro (tabuleiro);
			tabuleiro = vezX (tabuleiro, defLin(), defCol());
			vitoria = checaVitoria (tabuleiro, 'X');
			if (vitoria == 1) {
				imprimirTabuleiro (tabuleiro);
				System.out.println("\nJogador X ganhou");
				break;
			}
			
			if (checaEmpate(tabuleiro) == 1) {
				System.out.println("EMPATE");
				break;
			}
			
			tabuleiro = vezIA (tabuleiro, 'O');
			vitoria = checaVitoria (tabuleiro, 'O');
			if (vitoria == 1) {
				imprimirTabuleiro (tabuleiro);
				System.out.println("\nComputador ganhou");
				break;
			}
			
			
			}
		}
	}
	
	public static void multiplayer () {
			char [][] tabuleiro = iniciaTabuleiro ();
			int vitoria = 0;
			
			imprimirTabuleiro (tabuleiro);
			while (vitoria == 0) {
			
			System.out.println("Jogador X");
			tabuleiro = vezX (tabuleiro, defLin(), defCol());
			imprimirTabuleiro (tabuleiro);
			
			vitoria = checaVitoria (tabuleiro, 'X');
			if (vitoria == 1) {
				System.out.println("\nJogador X ganhou");
				break;
			}
			
			
			System.out.println("Jogador O");
			tabuleiro = vezO (tabuleiro, defLin(), defCol());
			imprimirTabuleiro (tabuleiro);
			
			vitoria = checaVitoria (tabuleiro, 'O');
			if (vitoria == 1) {
				System.out.println("\nJogador O ganhou");
				break;
			}
			
		}
		
	}
	
	public static char escolhaXO () {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Escolha entre X ou O: ");
		char escolha = scan.next().charAt(0);
		
		if (escolha == 'x' || escolha == 'o')
			escolha -= 32;
		
		if (escolha == 'X' || escolha == 'O') {
			return escolha;
		}
		
		else {
			System.out.println("Caracter Inválido digite novamente");
			escolhaXO ();
		}
		
		return escolha;
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
	
	public static char[][] vezX (char[][] tabuleiro, int lin, int col){
		
		if (checaJogada (lin, col, tabuleiro) == 0) {
			System.out.println("\nJogada Inválida");
			vezX (tabuleiro, defLin(), defCol());
		}
		
		else {
		tabuleiro = jogadaX (tabuleiro, lin, col);
		}
		
		return tabuleiro;
	}
	
	public static char[][] jogadaX (char[][] tabuleiro, int lin, int col){
		
		tabuleiro[lin][col] = 'X';
		
		return tabuleiro;
	}
	
	public static char[][] vezO (char[][] tabuleiro, int lin, int col){
		
		if (checaJogada (lin, col, tabuleiro) == 0) {
			System.out.println("\nJogada Inválida");
			vezO (tabuleiro, defLin(), defCol());
		}
		
		else {	
		tabuleiro = jogadaO (tabuleiro, lin, col);
		}
		
		return tabuleiro;
	}
	
	public static char [][] jogadaO (char[][] tabuleiro, int lin, int col){
		
		tabuleiro[lin][col] = 'O';
		
		return tabuleiro;
	}
	
	public static char[][] vezIA (char[][] tabuleiro, char op){
		int lin = aleatorio(0,2);
		int col = aleatorio(0,2);
		
		if (tabuleiro[lin][col] != ' ') {
			tabuleiro = vezIA(tabuleiro, op);
		}
		
		else {
			tabuleiro[lin][col] = op;
		}
		
		return tabuleiro;
	}
	
	public static void imprimirTabuleiro (char[][] tabuleiro) {
		System.out.println("   0   1   2");
		System.out.println("0  " + tabuleiro[0][0] + "| " + tabuleiro[0][1] + "  |" + tabuleiro[0][2]);
		System.out.println("  ------------");
		System.out.println("1  " + tabuleiro[1][0] + "| " + tabuleiro[1][1] + "  |" + tabuleiro[1][2]);
		System.out.println("  ------------");
		System.out.println("2  " + tabuleiro[2][0] + "| " + tabuleiro[2][1] + "  |" + tabuleiro[2][2]);
		System.out.println();
	}
	
	public static int checaEmpate (char[][]tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] == ' ')
					return 0;
			}
		}
		return 1;
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
	
	public static int checaJogada (int lin, int col, char[][] tabuleiro) {
		
		if (lin < 0 || col < 0 || lin > 2 || col > 2 || tabuleiro[lin][col] == 'X' || tabuleiro[lin][col] == 'O')
			return 0;
		
		return 1;
	}
	
	public static int defLin () {
		Scanner scan = new Scanner (System.in);
		System.out.print("Digite a linha da jogada: ");
		int lin = scan.nextInt();
		return lin;
	}
	
	public static int defCol () {
		Scanner scan = new Scanner (System.in);
		System.out.print("Digite a coluna da jogada: ");
		int col = scan.nextInt();
		return col;
	}
	
	public static int aleatorio (int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
}
