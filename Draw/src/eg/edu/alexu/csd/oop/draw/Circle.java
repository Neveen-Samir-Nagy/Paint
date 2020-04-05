package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Circle extends Inhertance {

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Circle clone = new Circle();
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
		GraphicsContext g = (GraphicsContext)canvas;
		Point b = (Point)getPosition();
		g.setFill(Paint.valueOf(getFillColor().toString()));
		g.setStroke(Paint.valueOf(getColor().toString()));
		g.fillOval(b.getX(), b.getY(), getProperties().get("Radius"), getProperties().get("Radius"));
		g.strokeOval(b.getX(), b.getY(), getProperties().get("Radius"), getProperties().get("Radius"));
	}
}
