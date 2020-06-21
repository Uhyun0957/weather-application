package lib;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SetStyle {

	// 각 페이지에서 사용되는 투명 패널 스타일 지정 메서드
	public static void setPanelStyle(JPanel panel, int x, int y, int width, int height) {
		panel.setBounds(x, y, width, height);
		panel.setBackground(new Color(255, 255, 255, 100));
		Border border = BorderFactory.createRaisedBevelBorder();
		panel.setBorder(border);
	}
}