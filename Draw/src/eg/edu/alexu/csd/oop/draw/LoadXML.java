package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import eg.edu.alexu.csd.oop.test.DummyShape;


public class LoadXML {
	LinkedList<Shape> shapelist = new LinkedList<Shape>();
	Point position ;
	Map<String, Double> map=null;
	Color color = null;
	Color fillcolor = null;
	Class<?> clazz;
	Constructor<?> ctor;
	Class<? extends Shape> object1 ;
	Shape object ;
	

	public LinkedList<Shape> loadXML(String path) {
		File XML = new File(path);
		if (XML.length() == 0) {
			throw new UnsupportedOperationException("Error");
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(XML));
			String st = "";
			String get = "";
			while ((st = br.readLine()) != null) {
	
				if(st.equals("{") || st.equals("}")|| st.equals("},")) {
               	 continue;
                }else if(st.contains("ID")) {
               	 
               	 if(st.contains("Circle")) {
               		 object = new Circle();
               	 }else if(st.contains("Square")) {
               		 object = new Square();
               	 }else if(st.contains("Rectangle")) {
               		 object = new Rectangle();
               	 }else if(st.contains("Ellipse")) {
               		 object = new Ellipse();
               	 }else if(st.contains("Triangle")) {
               		 object = new Triangle();
               	 }else if(st.contains("LineSegment")) {
               		 object = new LineSegment();
               	 }else {
               		 object = new DummyShape();
               	 }
                }else if(st.contains("/Shape")) {
                	 shapelist.add(object);
                 }else if(st.contains("/Paint")) {
                	 break;
                 }else if(st.contains("Fillcolor")&&!st.contains("/Fillcolor")) {
                	 st=br.readLine();
                	 
                	 get=new String(st.substring(13, st.length()-1));
                	 if(get.contains("awt")) {
                	 object.setFillColor(Color.getColor(get));
                	 }
                	 else {
                		 object.setFillColor(get);
                	 }
                 }else if(st.contains("Position")&&!st.contains("/Position")) {
                	 st=br.readLine();
                	 get = new String(st.substring(5, st.length()-1));
                	 
                	 Double x = Double.parseDouble(get);
                	 st=br.readLine();
                	 get = new String(st.substring(5, st.length()-1));
                	
                	 Double y = Double.parseDouble(get);
                	 object.setPosition(new Point(x.intValue(),y.intValue()));
                 }else if(st.contains("Properties")&&!st.contains("/Properties")) {
                	 map = new HashMap<String,Double>();
                	 while(!st.contains("/Properties")) {
                		 st=br.readLine();
                		 if(st.contains("/Properties")) {
                			 break;
                		 }
                		 String key ="";
                		 int index = st.indexOf(':');
                		 if(index>1) {
                		  key = new String(st.substring(1, index-1));
                		  
                		 }else {
                			 key=null;
                		 }
                		 get = new String(st.substring(index+2, st.length()-1));
                		 
                		
                		 map.put(key, Double.parseDouble(get));
                		 
                	 }
                	 object.setProperties(map);
                 }else if(st.contains("Color")&&!st.contains("/Color")) {
                	 st=br.readLine();
                	 get=new String(st.substring(9, st.length()-1));
                	 if(get.contains("awt")) {
                	 object.setColor(Color.getColor(get));
                	 }
                	 else {
                		 object.setColor(get);
                	 }
                 }else {
                	 continue;
                 }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shapelist;
	}
}
