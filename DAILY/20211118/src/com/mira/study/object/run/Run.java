package com.mira.study.object.run;

import com.mira.study.object.model.dao.Dao;

public class Run {
	public static void main(String[] args) {
		Dao d = new Dao();
		d.fileSave("drink.txt");
		d.fileRead("drink.txt");
	}

}
