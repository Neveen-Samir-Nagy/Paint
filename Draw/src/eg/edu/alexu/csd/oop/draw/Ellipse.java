package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Ellipse extends Inhertance {

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Ellipse clone = new Ellipse();
		Point z = new Point();
		Point b=(Point)getPosition();
		z.x = b.x+7;
		z.y = b.y+7;
		
		clone.setPosition(z);
		Map<String,Double> cm = getProperties();
		clone.setProperties(cm);
		Object color = getColor();
		clone.setColor(color);
		Object Fillcolor = getFillColor();
		clone.setFillColor(Fillcolor);
		
		return clone;
	}

	@Override
	public void draw(Object canvas) {
		// TODO Auto-generated method stub
		GraphicsContext g = (GraphicsContext) canvas;
		Point b = (Point) getPosition();
		g.setStroke(Paint.valueOf(getColor().toString()));
		g.setFill(Paint.valueOf(getFillColor().toString()));
		g.fillOval(b.getX(), b.getY(), getProperties().get("Major Axis"), getProperties().get("Minor Axis"));
		g.strokeOval(b.getX(), b.getY(), getProperties().get("Major Axis"), getProperties().get("Minor Axis"));
	}

}