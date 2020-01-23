package com.dataserver;

import java.util.ArrayList;

public class data {
	private String name, password;
	private static ArrayList<String> accList = new ArrayList();

	private static ArrayList<String> pwList = new ArrayList();
	

	private static ArrayList<String> infoList = new ArrayList();
	
	public static void accCreate(String username,String password){
		accList.add(username);
		pwList.add(password);
		infoList.add("");
	}
	public static void saveText(String text, int index){
		infoList.set(index, text);
		
	}
	
	public static String giveInfoList(int index) {
		return data.infoList.get(index);
	}
	public static ArrayList<String> giveList() {
		return data.accList;
	}
	public static ArrayList<String> givePw() {
		return data.pwList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean check() {
		for (String x : data.accList) {
			if (x.equals(name)) {
				if (pwList.get(data.giveList().indexOf(x)).equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
