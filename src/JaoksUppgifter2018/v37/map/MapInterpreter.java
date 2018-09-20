package JaoksUppgifter2018.v37.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import JaoksUppgifter2018.v37.blocks.Block;
import JaoksUppgifter2018.v37.blocks.ClosedBlock;
import JaoksUppgifter2018.v37.blocks.GoalBlock;
import JaoksUppgifter2018.v37.blocks.OpenBlock;
import JaoksUppgifter2018.v37.blocks.StartBlock;

public class MapInterpreter {

	public static Map interpretMap(File f) {
		try {
			Scanner fileReader = new Scanner(f);
			Map map = new Map();

			int row = 0;
			int col = 0;
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();

				for (col = 0; col < line.length(); col++) {
					char c = line.charAt(col);
					Block b;

					if (c == '*') {
						b = new ClosedBlock();
					} else if (c == 'S') {
						b = new StartBlock();
						map.setStartX(col);
						map.setStartY(row);
					} else if (c == 'G') {
						b = new GoalBlock();
					} else {
						b = new OpenBlock();
					}
					b.setTranslateX(col * Block.SIZE);
					b.setTranslateY(row * Block.SIZE);
					map.add(b, row);
				}
				row++;
			}
			fileReader.close();
			return map;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

}
