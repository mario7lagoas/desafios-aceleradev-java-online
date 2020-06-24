package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int size = elements.length;
		int total = 0;
		for (int element : elements) {
			total += element;
		}
		return total / size;
	}

	public static int mode(int[] elements) {
		int ct = 0, num = 0, swap = 0;
		Arrays.sort(elements);
		for (int x : elements) {
			ct = 0;
			for (int y : elements) {
				if (x == y) {
					ct += 1;
				}
			}
			if (ct > swap) {
				swap = ct;
				num = x;
			}
		}
		return num;
	}

	public static int median(int[] elements) {
		int total = elements.length;
		Arrays.sort(elements);
		if (( total % 2) != 0) {
			return elements[total / 2];
		}else {
			int p1 = (( total / 2)-1);
			int p2 = p1 + 1;
			return (int) ((elements[p1] + elements[p2]) / 2);
		}
	}
}
