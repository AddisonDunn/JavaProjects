import javax.swing.*;

public class MainActivity extends JFrame {

	/** Array of smaller games **/
	private TicTacToe[][] t = new TicTacToe[3][3];

	/** Constructor for the whole game activity **/
    public MainActivity() {
    	initUI();
    }

    private void initUI() {
    
    	/** Create and place an array of buttons **/
    	int xValue;
    	int yValue;
    	int x = 65;
    	int y = 65;
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			xValue = x + (i * (235));
				yValue = y + (j * (235));
    			t[i][j] = new TicTacToe(xValue, yValue, this);
    			this.add(t[i][j]);
    		}
    	}

    	/** Draw the 9 small tic-tac-toe boards and the large board  **/
    	DrawPanel p1 = new DrawPanel();
    	add(p1);
    	pack();
    	        
    	/** Other setup **/
        setTitle("Tic-Tac-Toe");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(p1);
    }

    public static void main(String[] args) {

    	MainActivity game = new MainActivity();
    	//TicTacToe t = new TicTacToe(50,50, ex);
    	
    	game.getContentPane().setLayout(null);
    	
        //ex.repaint();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	game.setVisible(true);
            }
        });
        
    }

//    private int whoWon() {
//    	int player;
//		for(int i = 0; i<3; i++) {
//			player = t[i][0].getStatus();
//			if(player != 0)
//				if(t[i][1].getStatus() == player)
//					if(t[i][2].getStatus() == player)
//						return player;
//		}
//		
//		for(int i = 0; i<3; i++) {
//			player = t[0][i].getStatus();
//			if(player != 0)
//				if(board[1][i].getStatus() == player)
//					if(board[2][i].getStatus() == player)
//						return player;
//		}
//		
//		player = board[0][0].getStatus();
//		if(player != 0)
//			if(board[1][1].getStatus() == player)
//				if(board[2][2].getStatus() == player)
//					return player;
//		
//		player = board[0][2].getStatus();
//		if(player != 0)
//			if(board[1][1].getStatus() == player)
//				if(board[2][0].getStatus() == player)
//					return player;
//		
//		boolean isTie = true;
//		for(int i = 0; i<3; i++) {
//			for(int j = 0; j<3; j++) {
//				if(board[i][j].getStatus() == 0)
//					isTie = false;
//			}
//    }
	private void add(TicTacToe t) {
		t.addSelf();
		
	}
    

    
    
    

}

