package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class Inhertance implements Shape, Cloneable {
	Point Shapeposition = new Point();
	Object Shapecolor = null;
	Object Shapefillcolor = null;
	Map<String, Double> map = null;

	@Override
	public abstract Object clone() throws CloneNotSupportedException;

	@Override
	public void setPosition(Object position) {
		// TODO Auto-generated method stub
		Shapeposition = new Point((Point) position);
	}

	@Override
	public Object getPosition() {
		// TODO Auto-generated method stub
		return (Object) Shapeposition;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		map = new HashMap<String, Double>(properties);
	}

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public void setColor(Object color) {
		// TODO Auto-generated method stub
		Shapecolor = color;
	}

	@Override
	public Object getColor() {
		// TODO Auto-generated method stub
		return  Shapecolor;
	}

	@Override
	public void setFillColor(Object color) {
		// TODO Auto-generated method stub
		Shapefillcolor= color;
	}

	@Override
	public Object getFillColor() {
		// TODO Auto-generated method stub
		return  Shapefillcolor;
	}

	@Override
	public abstract void draw(Object canvas);

	
	

}
