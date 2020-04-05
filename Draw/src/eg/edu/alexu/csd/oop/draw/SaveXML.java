package eg.edu.alexu.csd.oop.draw;

import java.awt.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SaveXML {
	File XML;
	Map<String, Double> map;
	public void XML(LinkedList<Shape> shape, String path) {
		// TODO Auto-generated catch block
		try {
			if (path.equals(null) ) {
				throw new UnsupportedOperationException("Error");
			}
			
			XML = new File(path);
			XML.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(XML);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("<Paint>");
			for (int i = 0; i < shape.size(); i++) {
				Class<? extends Shape> c = (Class<? extends Shape>) shape.get(i).getClass();
				if(shape.get(i).getProperties()!=null) {
				map = new HashMap<String, Double>(shape.get(i).getProperties());
				}
				printWriter.println("<Shape>");
				printWriter.println("ID : "  + c);
				if((shape.get(i).getPosition()) != null) {
				printWriter.println("<Position>");
				printWriter.println("<x = " + ((Point) shape.get(i).getPosition()).getX()+">");
				printWriter.println("<y = " + ((Point) shape.get(i).getPosition()).getY()+">");
				printWriter.println("</Position>");
				}
				if(shape.get(i).getProperties()!=null) {
				printWriter.println("<Properties>");
				Set<Map.Entry<String, Double>> st = map.entrySet();
				for (Map.Entry<String, Double> me : st) {
                   printWriter.println("<"+me.getKey()+" : "+me.getValue()+">");
				}
				printWriter.println("</Properties>");
				}
				if (shape.get(i).getColor() != null) {
					printWriter.println("<Color>");
					printWriter.println("<Color : " + shape.get(i).getColor()+">");
					printWriter.println("</Color>");
				}
				if (shape.get(i).getFillColor() != null) {
					printWriter.println("<Fillcolor>");
					printWriter.println("<Fillcolor : " + shape.get(i).getFillColor()+">");
					printWriter.println("</Fillcolor>");
				}
				printWriter.println("</Shape>");
			}
			printWriter.println("</Paint>");
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
