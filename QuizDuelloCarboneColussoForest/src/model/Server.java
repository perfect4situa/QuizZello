package model;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {

	private ServerSocket server;
	private QuizList quizList;
	private ClientList clientList;
	private int nQuiz;
	private int nClient;
	Thread t;
	
	public Server() {
		server=null;
		quizList=null;
		clientList=null;
		nQuiz=1;
		nClient=2;
	}
	
	public int getnQuiz() {
		return nQuiz;
	}

	public void setnQuiz(int nQuiz) {
		this.nQuiz = nQuiz;
	}

	public int getnClient() {
		return nClient;
	}

	public void setnClient(int nClient) {
		this.nClient = nClient;
	}

	public void run() {
		quizList=new QuizList(nQuiz);
		try {
			quizList.caricaQuiz();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			while(clientList.getList().size() < nClient) {
				Utente newFace;
				try {
					newFace = new Utente(server.accept());
					clientList.add(newFace);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			while(!clientList.allReady());
			
			String msg = "startGame";
			for(int i = 0; i < clientList.getList().size(); i++) {
				msg += ";" + clientList.getList().get(i).getNickname();
				
			}
			clientList.sendAll(msg);
			
			while(quizList.getIndex() < nQuiz) {
				while(!clientList.allReady());
				clientList.sendQuiz(quizList.take());
			}
			
			while(!clientList.allReady());
			
			clientList.winner();
	}
	
	public void start(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientList = new ClientList();
		t = new Thread(this);
		t.start();
	}
	
	public void close()	{
		
		if(server!=null)
		{
			clientList.closeConnections();
			t.interrupt();
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			server = null;
		}
	}
	
}
