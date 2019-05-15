package com.galaxy.merchant;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")

/**
 * 
 * @author DAMA
 *
 */
public class RomanTest {

	@Test
	public void romanLetterTest() {

		List<String> romanLetterList = new ArrayList<String>();

		romanLetterList.add("Glob is I");
		romanLetterList.add("prok is V");
		romanLetterList.add("pish is X");
		romanLetterList.add("tegi is L");
		romanLetterList.add("tegi is C");
		romanLetterList.add("tegi is M");

		for (String s : romanLetterList) {
			switch (s) {

			case "I":
				assertEquals(romanTextValidation(s), 1);
				break;
			case "V":
				Assert.assertEquals(romanTextValidation(s), 5);
				break;

			case "X":
				Assert.assertEquals(romanTextValidation(s), 10);
				break;

			case "L":
				Assert.assertEquals(romanTextValidation(s), 50);
				break;
			case "C":
				Assert.assertEquals(romanTextValidation(s), 100);
				break;

			case "D":
				Assert.assertEquals(romanTextValidation(s), 500);
				break;

			case "M":
				Assert.assertEquals(romanTextValidation(s), 1000);
				break;

			}
		}

	}

	private int romanTextValidation(String romantext) {

		Pattern ptn = Pattern.compile(Constants.ASSIGNMENT);
		Matcher mcher = ptn.matcher("romantext");
		mcher.matches();
		String roman = mcher.group(2).trim();

		return TransactionProcess.getValueByRoman(roman);
	}

}
