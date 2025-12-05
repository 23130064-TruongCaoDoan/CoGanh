package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InForPlayerPanel extends JPanel{
	private JPanel p1,p2,p11,p21;
	private JLabel name1, name2, point1 , point2,diem1,diem2;
	public InForPlayerPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		p1=new JPanel();
		p1.setBackground(Color.gray);
		add(p1);
		p1.setLayout(new GridLayout(2,1));
		p1.add(name1 =new JLabel(" Player 1"));
		p11=new JPanel();
		p1.add(p11);
		p11.setLayout(new FlowLayout());
		p11.add(point1 =new JLabel("Điểm Player 1:"));
		p11.add(diem1 =new JLabel());
		
		
		p2=new JPanel();
		p2.setBackground(Color.gray);
		add(p2);
		p2.setLayout(new GridLayout(2,1));
		p2.add(name2 =new JLabel(" Player 2"));
		p21=new JPanel();
		p2.add(p21);
		p21.setLayout(new FlowLayout());
		p21.add(point2 =new JLabel("Điểm Player 2:"));
		p21.add(diem2 =new JLabel());
		
	}
	public JPanel getP1() {
		return p1;
	}
	public void setP1(JPanel p1) {
		this.p1 = p1;
	}
	public JPanel getP2() {
		return p2;
	}
	public void setP2(JPanel p2) {
		this.p2 = p2;
	}
	public JLabel getName1() {
		return name1;
	}
	public void setName1(JLabel name1) {
		this.name1 = name1;
	}
	public JLabel getName2() {
		return name2;
	}
	public void setName2(JLabel name2) {
		this.name2 = name2;
	}
	public JLabel getPoint1() {
		return point1;
	}
	public void setPoint1(JLabel point1) {
		this.point1 = point1;
	}
	public JLabel getPoint2() {
		return point2;
	}
	public void setPoint2(JLabel point2) {
		this.point2 = point2;
	}
	public void reset() {
		p1.setBackground(Color.yellow);
		p1.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
		p2.setBackground(Color.gray);
		p2.setBorder(null);
		
	}
	public void highlight(boolean b) {
		if(b) {
			p1.setBackground(Color.yellow);
			p1.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			p2.setBackground(Color.gray);
			p2.setBorder(null);
		}
		else {
			p2.setBackground(Color.yellow);
			p2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			p1.setBackground(Color.gray);
			p1.setBorder(null);
		}
	}
	public void setDiem(int p12, int p22) {
		this.diem1.setText(p12+"");
		this.diem2.setText(p22+"");
		
	}
	

}
