package chs.model;

import java.util.ArrayList;

public class InputBean {
	//Input Value
		private String inputtedText;
		
		//Grouped Value
		private ArrayList<Character> allNum;
		private ArrayList<Character> allSpeChar;
		
		private static int spaceCounter = 0;
		
		//Constructors
		
		public InputBean() {
			allNum = new ArrayList<Character>();
			allSpeChar = new ArrayList<Character>();
		}
		
		public InputBean(String inputtedText) {
			this.inputtedText = inputtedText;
			allNum = new ArrayList<Character>();
			allSpeChar = new ArrayList<Character>();
		}
		
		//Getters
		
		public String getInputtedText() {
			return inputtedText;
		}

		public ArrayList<Character> getAllNum() {
			return allNum;
		}

		public ArrayList<Character> getAllSpeChar() {
			return allSpeChar;
		}

		public int getSpaceCounter() {
			return spaceCounter;
		}
		
		//Method
		
		public void Group(){
			char[] ch = this.inputtedText.toCharArray();
			InputBean.spaceCounter =0;
			for (int i = 0; i < inputtedText.length(); i++) {
				
				if (Character.isDigit(ch[i])) {
					allNum.add(ch[i]);
				}else if (Character.isSpaceChar(ch[i])){
					InputBean.spaceCounter++;
				}else if (Character.isLetter(ch[i]) && allSpeChar.contains(ch[i]) || allSpeChar.contains(ch[i])) {
					System.out.println(ch[i] + "Is already added to the session");
				}else {
					allSpeChar.add(ch[i]);
				}
				

			}
		}
}
