package com.monocept;

import java.util.Scanner;

public class CricketBook {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1 to start game and 0 to exit : ");
		int flag;
		flag = sc.nextInt();
		
		while (flag != 0) {
			sc.nextLine();
			String firstPlayer, secondPlayer;
			System.out.print("Enter Player 1 name : ");
			firstPlayer = sc.nextLine();
			System.out.print("Enter Player 2 name : ");
			secondPlayer = sc.nextLine();
			int score_1 = 0, score_2 = 0;
			int isContinue = 0, round = 0;
			System.out.println("Player : " + firstPlayer);
			System.out.print("Enter 1 to open book : ");
			isContinue = sc.nextInt();
			Score s = new Score();
			while (isContinue == 1) {
				int point = s.point();
				score_1 = score_1 + point;
				System.out.println("        Score " + score_1);
				round++;
				if (point == 0)
					break;
				System.out.print("Enter 1 to open book : ");
				isContinue = sc.nextInt();
			}
			System.out.println(firstPlayer + " Total Score " + score_1);
			System.out.println(firstPlayer + " takes " + round + " rounds.");
			System.out.println(
					secondPlayer + " Needs " + (score_1 + 1) + " Score In " + round + " Rounds To Win The Match");
			System.out.println("Player : " + secondPlayer);
			System.out.print("Enter 1 to open book : ");
			isContinue = sc.nextInt();
			while (isContinue == 1 && score_2 <= score_1) {
				int point = s.point();
				score_2 = score_2 + point;
				round--;
				System.out.println("        Score " + score_2 + "        Rounds Left " + round);
				if (point == 0)
					break;
				if (round == 0) {
					System.out.println("Game Over....");
					break;
				}
				System.out.print("Enter 1 to open book : ");
				isContinue = sc.nextInt();
			}
			System.out.println(secondPlayer + " Total Score " + score_2);
			if (score_2 < score_1)
				System.out.println(firstPlayer + " Win The Match!!");
			else
				System.out.println(secondPlayer + " Win The Match!!");
			System.out.println("Enter 1 to start game and 0 to exit : ");
			flag = sc.nextInt();
		}

	}
}

class Score {
	int point() {
		int pageNumber, point;
		pageNumber = (int) (Math.random() * (300 - 0 + 1) + 0);
		point = pageNumber % 7;
		System.out.print("Page Number " + pageNumber + "         Point " + point);
		return point;
	}
}

