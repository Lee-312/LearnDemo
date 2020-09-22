package com.lee;

public class IsValidSudoku {
	public static void main(String[] args) {
		char[][] cs = new char[][]{
				{'5', '3', '.', '7', '.', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		System.out.println(isValidSudoku(cs));
	}

	public static boolean isValidSudoku(char[][] board) {
		// 每行
		for (int i = 0; i < board.length; i++) {
			char[] chars = board[i];
			String s = String.valueOf(chars).replaceAll("\\.", "");
			if(!chongfu(s)){
				return false;
			}
		}
		//每列
		for (int i = 0; i < board.length; i++) {
			StringBuffer s = new StringBuffer();
			for (int j = 0; j < board.length; j++) {
				s.append(board[j][i]);
			}
			//System.out.println(s.toString().replaceAll("\\.", ""));
			if (!chongfu(s.toString().replaceAll("\\.", ""))) {
				return false;
			}
		}
		// 每九个单元
		for (int i = 0; i < 9; i += 3) {
			StringBuffer s = new StringBuffer();
			for (int j = 0; j < 9; j += 3) {
				s.append(board[0 + i][0 + j]);
				s.append(board[0 + i][1 + j]);
				s.append(board[0 + i][2 + j]);
				s.append(board[1 + i][0 + j]);
				s.append(board[1 + i][1 + j]);
				s.append(board[1 + i][2 + j]);
				s.append(board[2 + i][0 + j]);
				s.append(board[2 + i][1 + j]);
				s.append(board[2 + i][2 + j]);
				System.out.println(s.toString());
				if (!chongfu(s.toString().replaceAll("\\.", ""))) {
					return false;
				}
				s.setLength(0);
			}
		}

		System.out.println("------------");
		return true;
	}

	public static boolean chongfu(String s) {
		char[] c = new char[10];
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case '1':
					if (c[1] == '\0') {
						c[1] = s.charAt(i);
					} else {
						return false;
					}
					break;
				case '2':
					if (c[2] == '\0') {
						c[2] = s.charAt(i);
					} else {
						return false;
					}
					break;
				case '3':
					if (c[3] == '\0') {
						c[3] = s.charAt(i);
					} else {
						return false;
					}
					break;
				case '4':
					if (c[4] == '\0') {
						c[4] = s.charAt(i);
					} else {
						return false;
					}
					break;
				case '5':
					if (c[5] == '\0') {
						c[5] = s.charAt(i);
					} else {
						return false;
					}
					break;
				case '6':
					if (c[6] == '\0') {
						c[6] = s.charAt(i);
					} else {
						return false;
					}
					break;
				case '7':
					if (c[7] == '\0') {
						c[7] = s.charAt(i);
					} else {
						return false;
					}
					break;
				case '8':
					if (c[8] == '\0') {
						c[8] = s.charAt(i);
					} else {
						return false;
					}
					break;
				case '9':
					if (c[9] == '\0') {
						c[9] = s.charAt(i);
					} else {
						return false;
					}
					break;
				default:
					return false;
			}
		}
		return true;
	}

}
