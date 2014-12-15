package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import dijsktra.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class MapRead.
 */
public class MapRead {

	/**
	 * Map read.
	 *
	 * @param fileName the file name
	 * @return the map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Map mapRead(File fileName) throws IOException {
		BufferedReader input = null;
		Map map = null;
		try {
			input = new BufferedReader(new FileReader(fileName));
			String buffer;
			buffer = input.readLine();
			map = new Map(Integer.parseInt(buffer));
			while ((buffer = input.readLine()) != null) {
				String parts[] = buffer.split("\\s+");
				if (parts[0].equals("#"))
					continue;
				if (parts.length == 2)
					map.addCity(Integer.parseInt(parts[0]),parts[1]);
				else if (parts.length == 3)
					map.addEdge(Integer.parseInt(parts[0]),
							Integer.parseInt(parts[1]),
							Integer.parseInt(parts[2]));
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (input != null)
				input.close();
		}
		return map;
	}
}
