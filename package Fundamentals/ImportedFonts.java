package Kofi_Co_Fundamentals;

import java.awt.*;
import java.io.*;

public class ImportedFonts {
	Font Baloo, Gugi, Advent;

	public void Fonts() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

			Font newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("Baloo-Regular.ttf"));
			Baloo = newfont1.deriveFont(30f);
			ge.registerFont(newfont1);

			Font newfont2 = Font.createFont(Font.TRUETYPE_FONT, new File("Gugi-Regular.ttf"));
			Gugi = newfont2.deriveFont(30f);
			ge.registerFont(newfont2);
			
			Font newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("AdventPro-VariableFont_wdth,wght.ttf"));
			Advent = newfont3.deriveFont(30f);
			ge.registerFont(newfont3);

		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
	}
}