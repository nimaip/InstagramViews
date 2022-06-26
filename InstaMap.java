package Insta;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class InstaMap {

	public static void main(String[] args) {
		TreeMap<Integer, LinkedList<String>> map = new TreeMap();
		ArrayList<Integer> views = new ArrayList();

		try {

			File file = new File("C:\\Users\\nimai\\eclipse-workspace\\USACO\\src\\Insta\\data.dat");
			Scanner sc = new Scanner(file);
			String s = sc.nextLine();

			String[] nums = s.split("'");
			nums[0] = nums[0].substring(1);
			nums[nums.length - 1] = nums[nums.length - 1].substring(0, nums[nums.length - 1].length() - 1);

			for (String str : nums) {
				if (str.length() > 0 && !str.substring(0, 1).equals(",")) {
					int psn = str.indexOf(",");
					if (psn > 0)
						str = str.substring(0, psn) + str.substring(psn + 1);
					views.add(Integer.parseInt(str));
				}
			}
			double acc = 0;
			for(int i: views) {
				acc += i;
			}
			System.out.println("AVERAGE VIEWS OVER 32 REELS:\t\t\t" + acc/views.size()+"\n\n\n\n");
			int cnt = 0;
			while (sc.hasNextLine()) {
				String lin = sc.nextLine();
				if (lin.length() == 0)
					cnt++;
				else {
					lin = lin.substring(lin.indexOf("#") + 1, lin.length() - 1);
					if (map.get(views.get(cnt)) == null)
						map.put(views.get(cnt), new LinkedList<String>());
					map.get(views.get(cnt)).add(lin);
				}
			}
//			myPrint(map);
			avgs(map);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void myPrint(TreeMap<Integer, LinkedList<String>> m) {
		for (Integer i : m.keySet()) {
			System.out.println("# views:  " + i + "\n");
			for (String s : m.get(i))
				System.out.println("\t\t" + s);
			System.out.println("\n-------------------\n");
		}
	}

	public static void avgs(TreeMap<Integer, LinkedList<String>> m) {
		TreeMap<String, Double> temp = new TreeMap();
		TreeMap<String, Integer> freq = new TreeMap();
		for (Integer i : m.keySet())
			for (String s : m.get(i)) {
				if (temp.get(s) == null)
					temp.put(s, i * 1.0);
				temp.put(s, temp.get(s) + i);
				if (freq.get(s) == null)
					freq.put(s, 0);
				freq.put(s, freq.get(s) + 1);
			}
		for (String s : temp.keySet()) {
//			temp.put(s, temp.get(s)/freq.get(s));
			double average = ((int) (temp.get(s) / freq.get(s)) * 100) / 100.0;
			System.out.println(s + ":\n\t\t" + average);
		}
		System.out.println("\n\nRELEVANT\n\n");
		for (String s : temp.keySet()) {
//			temp.put(s, temp.get(s)/freq.get(s));
			double average = ((int) (temp.get(s) / freq.get(s)) * 100) / 100.0;
			if (average >= 1300)
				System.out.println(s + ":\n\t\t" + average);
		}
	}
}
