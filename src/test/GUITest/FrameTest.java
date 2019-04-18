package test.GUITest;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class FrameTest {

	JFrame jf = null;
	
	
	
	public static void main(String[] args) {
		new FrameTest();
	}
	
	public FrameTest() {
		
		jf = new JFrame("²âÊÔ");
		jf.setSize(400, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel jp = new JPanel();
		JButton jb = new JButton("¿ªÊ¼");
		
		jp.add(jb);
		
		jf.add(jp);
		
		jf.setVisible(true);
		
		jb.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jb.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jb.setBackground(Color.RED);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("dsakdsjakldasjdklsajdlksajd");
			}
		});
		
		
	}

}
