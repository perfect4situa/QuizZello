package main;

import controller.ControllerServer;
import view.FinestraServer;

public class MainServer {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ControllerServer ctrl = new ControllerServer(new FinestraServer());
	}

}
