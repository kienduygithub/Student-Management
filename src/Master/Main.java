package Master;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import View.QLSVView;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			new QLSVView();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
