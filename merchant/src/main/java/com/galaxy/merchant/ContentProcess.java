package com.galaxy.merchant;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dama
 */
public class ContentProcess {

	private static HashMap<String, String> transList = new HashMap<String, String>();
	private static HashMap<String, Double> curryList = new HashMap<String, Double>();

	String currency = "";

	public void processLogic(String inputline) {

		String flag = checkFlag(inputline);

		/***
		 * idea design step 1: get the flag and proceed it accordingly step 2: construct
		 * the symbol list with roman step 3: construct currency and credits step 4:
		 * process the questions step 5: handle error
		 */

		if (flag.equals("assignment")) {
			Pattern ptn = Pattern.compile(Constants.ASSIGNMENT);
			Matcher mcher = ptn.matcher(inputline);
			mcher.matches();
			String name = mcher.group(1).trim();
			String roman = mcher.group(2).trim();
			if (!transList.containsKey(name)) {
				transList.put(name, roman);
			}
		} else if (flag.equals("credits")) {
			Pattern ptn = Pattern.compile(Constants.CREDITS);
			Matcher mcher = ptn.matcher(inputline);
			mcher.matches();

			// get currency name
			currency = mcher.group(4).trim();

			String[] trans = mcher.group(1).split(" ");
			int transValue = TransactionProcess.getTransValue(trans, transList);
			String curr = mcher.group(2);
			int credits = Integer.parseInt(mcher.group(3).trim());
			double value = credits / transValue;
			curryList.put(curr, value);

		} else if (flag.equals("howmany")) {
			Pattern ptn = Pattern.compile(Constants.HOW_MANY);
			Matcher mcher = ptn.matcher(inputline);
			mcher.matches();
			// check currency
			if (!currency.equals(mcher.group(1))) {
				//System.out.println(Constants.ERROR);
			}

			String[] trans = mcher.group(2).split(" ");
			int transValue = TransactionProcess.getTransValue(trans, transList);

			String curr = mcher.group(3).trim();
			double value = 0;
			for (String k : curryList.keySet()) {
				if (k.equals(curr)) {
					value = curryList.get(k);
				}
			}

			double total = transValue * value;
			if (total != 0) {
				System.out.println(mcher.group(2) + "is " + (long) total + " " + currency);
			}

		} else if (flag.equals("howmuch")) {
			Pattern ptn = Pattern.compile(Constants.HOW_MUCH);
			Matcher mcher = ptn.matcher(inputline);
			mcher.matches();

			String[] trans = mcher.group(1).split(" ");
			int transValue = TransactionProcess.getTransValue(trans, transList);
			if (transValue != 0) {
				System.out.println(mcher.group(1) + "is " + transValue);
			}
		} else {
			System.out.println(Constants.ERROR);
		}

	}

	private static String checkFlag(String s) {
		String flag = Constants.ERROR;
		String[] rgxArray = new String[] { Constants.ASSIGNMENT, Constants.CREDITS, Constants.HOW_MANY,
				Constants.HOW_MUCH };
		for (int i = 0; i < rgxArray.length; i++) {
			Pattern ptn = Pattern.compile(rgxArray[i]);
			Matcher mcher = ptn.matcher(s);
			if (mcher.matches()) {
				switch (i) {
				case 0:
					flag = Constants.ASSIGNMENT_FLAG;
					break;
				case 1:
					flag = Constants.CREDITS_FLAG;
					break;
				case 2:
					flag = Constants.HOW_MANY_FLAG;
					break;
				case 3:
					flag = Constants.HOW_MUCH_FLAG;
					break;
				default:
					break;
				}
			}
		}
		return flag;
	}

}
