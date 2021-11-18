package com.mira.list.mvc.run;

import com.mira.list.mvc.controller.LibraryController;
import com.mira.list.mvc.view.LibraryView;

public class LibraryRun {
	public static void main(String[] args) {
		LibraryView lv = new LibraryView();
		lv.mainMenu();
		
		LibraryController lc = new LibraryController();
		
	}
}
