import javax.swing.JButton;

public class TicTacToe {

	private Button[][] board = new Button[3][3];
	private int status;
	private int turn = 1;
	private MainActivity m;
	
	public TicTacToe(int x, int y, MainActivity m){
		this.m = m;
		int xValue;
		int yValue;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				xValue = x + (i * (69));
				yValue = y + (j * (69));
				board[i][j] = new Button(xValue, yValue, 65, 65, this, m);
			}
		}
	}
	
	public int getTurn(){
		return turn;
	}
	
	public void nextTurn(){
		if(turn == 1)
			turn = 2;
		else
			turn = 1;
	}
	
	public int whoWon(){
		int player;
		for(int i = 0; i<3; i++) {
			player = board[i][0].getStatus();
			if(player != 0)
				if(board[i][1].getStatus() == player)
					if(board[i][2].getStatus() == player)
						return player;
		}
		
		for(int i = 0; i<3; i++) {
			player = board[0][i].getStatus();
			if(player != 0)
				if(board[1][i].getStatus() == player)
					if(board[2][i].getStatus() == player)
						return player;
		}
		
		player = board[0][0].getStatus();
		if(player != 0)
			if(board[1][1].getStatus() == player)
				if(board[2][2].getStatus() == player)
					return player;
		
		player = board[0][2].getStatus();
		if(player != 0)
			if(board[1][1].getStatus() == player)
				if(board[2][0].getStatus() == player)
					return player;
		
		boolean isTie = true;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(board[i][j].getStatus() == 0)
					isTie = false;
			}
		}
		
		if(isTie) {
			int t = (int)(Math.random()*2)+1;
			return t;
		}
		else
			return 0;
	}
	
	
	
	
	public int getStatus(){
		return status;
	}
	
	public void addSelf() {
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				m.add(board[i][j]);
			}
		}
	}
	

}
