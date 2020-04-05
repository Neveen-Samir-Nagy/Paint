package eg.edu.alexu.csd.oop.draw;

import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class saveJson {
	File Json;

	public void Json(LinkedList<Shape> shape, String path) {
		try {
			if (path.equals(null) || shape.size() == 0) {
				throw new UnsupportedOperationException("Error");
			}
			
			Json = new File(path);
			System.out.println(path);
			Json.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(Json);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("{");
			for (int i = 0; i < shape.size(); i++) {
				printWriter.println("\"shape\": {");
				Class<? extends Shape> c = (Class<? extends Shape>) shape.get(i).getClass();
				printWriter.println("\"ID\" : \"" +  c + "\",");
				if((Point)(shape.get(i).getPosition())!=null) {
					printWriter.println("\"position\" : \"" +  ((Point) shape.get(i).getPosition()).getX()+" "+((Point) shape.get(i).getPosition()).getY() + "\",");
				}
				if(shape.get(i).getColor()!=null) {
					printWriter.println("\"color\" : \"" + shape.get(i).getColor() + "\",");
				}
				if(shape.get(i).getFillColor()!=null) {
					printWriter.println("\"fill color\" : \"" + shape.get(i).getFillColor() + "\",");
				}
				if(shape.get(i).getProperties()!=null) {
					printWriter.println("\"Properties\": {");
				Map<String, Double> map = new HashMap<String, Double>(shape.get(i).getProperties());

				Set<Map.Entry<String, Double>> st = map.entrySet();
				int temp = 0;
				for (Map.Entry<String, Double> me : st) {
					temp++;
					if (temp == map.size() - 1) {
						printWriter.println("\"" + me.getKey() + "\" : \"" + me.getValue() + "\"");
					} else {
						printWriter.println("\"" + me.getKey() + "\" : \"" + me.getValue() + "\",");
					}

				}
				printWriter.println("},");
			}
				printWriter.println("},");
			}
			printWriter.println("}");
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}