package com.galaxy.merchant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * 
 * @author DAMA
 *
 */
public class TransactionProcess {

	public static int getTransValue(String[] trans, HashMap<String, String> transList) {
		int value = 0;
		List<String> romans = new ArrayList<String>();
		for (int i = 0; i < trans.length; i++) {
			if (!transList.keySet().contains(trans[i])) {
				
				System.out.println(Constants.INVALID_INPUT);
				return 0;
			}
			romans.add(transList.get(trans[i]));
		}
		List<Integer> src = new ArrayList<Integer>();
		for (String s : romans) {
			src.add(getValueByRoman(s));
		}

		List<Integer> newSrc = doSubstract(src);
		;
		for (int i : newSrc) {
			value += i;
		}

		return value;
	}

	private static List<Integer> doSubstract(List<Integer> numbers) {
		int currentElement;

		for (int i = 0; i < numbers.size() - 1; i++) {
			currentElement = numbers.get(i);
			if (currentElement < numbers.get(i + 1)) {
				numbers.set(i, -currentElement);
			}
		}
		return numbers;
	}

	public static int getValueByRoman(String roman) {
		switch (roman) {
		case "I":
			return Roman.I.getValue();
		case "V":
			return Roman.V.getValue();
		case "X":
			return Roman.X.getValue();
		case "L":
			return Roman.L.getValue();
		case "C":
			return Roman.C.getValue();
		case "D":
			return Roman.D.getValue();
		case "M":
			return Roman.M.getValue();
		default:
			return 0;
		}
	}

}
