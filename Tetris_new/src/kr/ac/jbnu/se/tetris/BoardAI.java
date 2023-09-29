package kr.ac.jbnu.se.tetris;

import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class BoardAI extends Board {

    private TetrisAI computer;

    private String bestRoute = "";

    private int index = 0;

    public BoardAI(Tetris parent, int moveDelay) throws CloneNotSupportedException {
        super(parent);
        //TODO Auto-generated constructor stub 
        computer = new TetrisAI(this);

        bestRoute = computer.findBestRoute();

        timer = new Timer(moveDelay, this);
        
        start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isFallingFinished) {
            isFallingFinished = false;
            index = 0;
            if (!newPiece()) {
                if(opponent.isStarted){
                    // ai가 패배한 경우
                }
                else{
                    // ai가 승리한 경우
                }
                opponent.isStarted = false;
                opponent.timer.stop();

                isStarted = false;
                timer.stop();

                parent.gameManager().gameOverDialog().setVisible(true);
            }
            else {
                try {
                    bestRoute = computer.findBestRoute();
                } catch (CloneNotSupportedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } 
        else {
            moveToBestRoute(index++);
        }
    }

    private void moveToBestRoute(int i){
        if(i >= bestRoute.length()){
            dropDown();
            return;
        }

        if(bestRoute.charAt(i) == '0' && tryMove(curPiece, curPiece.curX() - 1, curPiece.curY()))
            move(curPiece, curPiece.curX() - 1, curPiece.curY());
        else if(bestRoute.charAt(i) == '1' && tryMove(curPiece, curPiece.curX() + 1, curPiece.curY()))
            move(curPiece, curPiece.curX() + 1, curPiece.curY());
        else if(bestRoute.charAt(i) == '2' && tryMove(curPiece, curPiece.curX(), curPiece.curY() - 1))
            move(curPiece, curPiece.curX(), curPiece.curY() - 1);
        else if(bestRoute.charAt(i) == '3' && tryMove(curPiece.rotateRight(), curPiece.curX(), curPiece.curY()))
            move(curPiece.rotateRight(), curPiece.curX(), curPiece.curY());    
    }
}
