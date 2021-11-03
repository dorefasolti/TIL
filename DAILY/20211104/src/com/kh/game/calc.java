package com.kh.game;

import java.util.Scanner;

public class calc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("# 난이도를 입력하세요 [상, 중, 하]");
		System.out.print(">> ");
		char ch = sc.next().charAt(0);
		
		char[] ch1 = new char[3];
		ch1[0] = '+';
		ch1[1] = '-';
		ch1[2] = '*';

			
			if(ch == '상') {
				System.out.println("상급 난이도입니다. 1 ~ 1000범위로 출력됩니다.");
				while(true) {
					
					for(int i = 1; i < 1000; i++) {
						double num = (int)(Math.random() * 1000);
						double num2 = (int)(Math.random() * 1000);
						double num3 = (int)(Math.random()* 3);

							System.out.println("Q" + i + ")" + (int)num + ch1[(int)num3] + (int)num2 + " = ?");
							System.out.print(">> ");
							int input = sc.nextInt();
							if(input == num * num2 || input == num + num2 || input == num - num2)  {
								System.out.println("# 정답입니다!");
								System.out.println("");
							}else if(input == 0){
								return;
							}else {								
								System.out.println("# 틀렸습니다!");
								System.out.println("");
							}
						}
					}
		}else if(ch == '중') {
			System.out.println("중급 난이도입니다. 1 ~ 100범위로 출력됩니다.");
			while(true) {
				
				for(int i = 1; i < 1000; i++) {
					double num = (int)(Math.random() * 100);
					double num2 = (int)(Math.random() * 100);
					double num3 = (int)(Math.random()* 3);

						System.out.println("Q" + i + ")" + (int)num + ch1[(int)num3] + (int)num2 + " = ?");
						System.out.print(">> ");
						int input = sc.nextInt();
						if(input == num * num2 || input == num + num2 || input == num - num2)  {
							System.out.println("# 정답입니다!");
							System.out.println("");
						}else if(input == 0){
							return;
						}else {								
							System.out.println("# 틀렸습니다!");
							System.out.println("");
						}
					}
				}
		}else if(ch == '하') {
			System.out.println("하급 난이도입니다. 1 ~ 10범위로 출력됩니다.");
			while(true) {
				
				for(int i = 1; i < 1000; i++) {
					double num = (int)(Math.random() * 20);
					double num2 = (int)(Math.random() * 20);
					double num3 = (int)(Math.random()* 3);

						System.out.println("Q" + i + ")" + (int)num + ch1[(int)num3] + (int)num2 + " = ?");
						System.out.print(">> ");
						int input = sc.nextInt();
						if(input == num * num2 || input == num + num2 || input == num - num2)  {
							System.out.println("# 정답입니다!");
							System.out.println("");
						}else if(input == 0){
							return;
						}else {								
							System.out.println("# 틀렸습니다!");
							System.out.println("");
						}
					}
				}
		}
	}
}
