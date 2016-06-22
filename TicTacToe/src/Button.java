import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



public class Button extends JButton {
	
	private int status;
	private TicTacToe t;
	private MainActivity m;
	private boolean hasClicked = false;
	
	public Button() {
		super();
		this.setBounds(0, 0, 1, 1);
	}
	
	
	public Button(int x, int y, int w, int h, TicTacToe t, MainActivity m){
		//super();
//		setOpaque(true);
//		setContentAreaFilled(false);
//		setBorderPainted(false);
		setFont(new Font("Arial", Font.PLAIN, 34));
		this.setBounds(x, y, w, h);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!hasClicked) {
					changeStatus();
				}
				hasClicked = true;
			}
		});
		this.t = t;
		this.m = m;
		status = 0;
	}
	
	public void changeStatus(){
		status = t.getTurn();
		t.nextTurn();
		if(status == 1){
			this.drawX();
		}
		if(status == 2){
			this.drawCircle();
		}
	
		System.out.println(t.whoWon());
	}
	
	public int getStatus(){
		return status;
	}
	
	public void setStatus(int i){
		this.status = i;
	}
	
	
	
	
	public void drawCircle(){
		this.setText("O");
		status = 2;
		//mainactivity.drawcircle(this.getX),this.gety)
	}
	
	public void drawX(){
		this.setText("X");
		status = 1;
	}
}
