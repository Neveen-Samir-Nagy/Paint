package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import eg.edu.alexu.csd.oop.test.DummyShape;

public class LoadJson {
	LinkedList<Shape> shapelist = new LinkedList<Shape>();
	Point position ;
	Map<String, Double> map;
	Color color = null;
	Color fillcolor = null;
	Class<?> clazz;
	Constructor<?> ctor;
	Shape object ;
	public LinkedList<Shape> loadjson(String path) {
		File json = new File(path);
		if(json.length()==0) {
			throw new UnsupportedOperationException("Error");
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(json));
			String st = "";
			String get = "";
			while ((st = br.readLine()) != null) {
				if(st.equals("{") || st.equals("}")|| st.equals("},")) {
                	 continue;
                 }if(st.contains("shape")) {
                	 st=br.readLine();
				 if(st.contains("ID")) {
                	 
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
                	 st=br.readLine();
                 } if(st.contains("position")) {
                	 get=new String();
                	 int j=14;
                	 for(j=14; !(st.charAt(j)==' ');j++) {
                		 get+=st.charAt(j);
                	 }
                	 Double x = Double.parseDouble(get);
                	 get = new String();
                	 for(j=j+1;!(st.charAt(j)=='"');j++) {
                		 get+=st.charAt(j);
                	 }
                	 Double y = Double.parseDouble(get);
                	 object.setPosition(new Point(x.intValue(),y.intValue()));
                	 st=br.readLine();
                 } if(st.contains("color")) {
                	 get = new String(st.substring(11, st.length()-2));
                	if(get.contains("awt")) {
                	 object.setColor(Color.getColor(get));}
                	else {
                		object.setColor(get);
                	}
                	 st=br.readLine();
                 }if(st.contains("fill color")) {
                	 get = new String(st.substring(16, st.length()-2));
                		if(get.contains("awt")) {
                       	 object.setFillColor(Color.getColor(get));}
                       	else {
                       		object.setFillColor(get);
                       	}
                		st=br.readLine();
                 }
                 if(st.contains("Properties")) {
                	 map = new HashMap<String,Double>();
                	 while(!st.equals("},")) {
                		  {
                	     st=br.readLine();
                	     if(st.equals("},")) {
                	    	 break;
                	     }
                		 int index = st.indexOf(':');
                		 String key="";
                		 if(index>2) {
                		  key =  new String(st.substring(1, index-2));
                		  
                		 }else {
                			 key=null;
                		 }
                		 if(st.charAt(st.length()-1)==',') {
                			 if(st.length()>3) {
                       		  get =  new String(st.substring(index+3, st.length()-2));
                       		  
                       		 }
                		 }else {
                			 if(st.length()>2) {
                       		  get =  new String(st.substring(index+3, st.length()-1));
                       		  
                       		 }
                		 }
                		 {
                    		
                    		 map.put(key, Double.parseDouble(get));
                		 }
                	 }
                	 }
                	 object.setProperties(map);
                	 
                 }
                 
                 
 					shapelist.add(object);
 				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shapelist;
	}
}
