package controller;

import java.util.ArrayList;

import model.dao.Dao;
import model.vo.Product;
import view.View;

public class Controller {

	public void selectByProductName(String keyword) {
		ArrayList<Product> list = new ArrayList<>();
		list = new Dao().selectByProductName(keyword);
		
		if(list.isEmpty()) {
			new View().Fail("키워드를 확인하세요");
		} else {
			new View().Success(list);
		}
	}

}
