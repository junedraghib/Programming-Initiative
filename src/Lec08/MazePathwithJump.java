package Lec08;

import java.util.ArrayList;

public class MazePathwithJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMazePathwithJump(0, 0, 2, 2).size());

	}

	public static ArrayList<String> getMazePathwithJump(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
//			br.add("");
			return br;
		}

		ArrayList<String> ans = new ArrayList<>();

		for (int jump = 1; jump + cr <= er; jump++) {
			ArrayList<String> hor = getMazePathwithJump(cr + jump, cc, er, ec);
			for (String val : hor) {
				ans.add("H" + jump + val);
			}
		}
	

		for (int jump = 1; jump + cc <= ec; jump++) {
			ArrayList<String> ver = getMazePathwithJump(cr, cc + jump, er, ec);
			for (String val : ver) {
				ans.add("v" + jump + val);
			}
		}

		for (int jump = 1; jump + cr <= er &&  jump + cc <= ec; jump++) {
			ArrayList<String> dd = getMazePathwithJump(cr + jump, cc + jump, er, ec);
			for (String val : dd) {
				ans.add("D" + jump + val);
			}
		}

		return ans;
	}

}
