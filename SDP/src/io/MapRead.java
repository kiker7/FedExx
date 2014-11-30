package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import dijkstra.Map;

public class MapRead {

	public Map mapRead(File fileName) throws IOException {
		Map map = new Map();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(fileName));
			String buffer;
			while ((buffer = input.readLine()) != null) {
				String parts[] = buffer.split("//s+");
				if (parts[0] == "#" && (parts[1] == "miasta" || parts[1] == "polaczenia"))
					continue;
				if (parts.length == 2)
					map.addCity(parts[1]);
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
