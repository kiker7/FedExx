package file_read_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args){
		File filename = new File(args[0]);
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String buffer;
		try {
			int c1 = 1;
			int c2 = 1;
			while ((buffer = input.readLine()) != null) {
				String parts[] = buffer.split("\\s+");
				if (parts[0].equals("#")){
					continue;
				}
				if (parts.length == 2)
					System.out.println(parts[0] + parts[1]);
				else if (parts.length == 3)
					System.out.println(parts[0] + parts[1] + parts[2]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}