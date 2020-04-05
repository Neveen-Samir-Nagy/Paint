package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Triangle extends Inhertance{

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Triangle clone = new Triangle();
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
		g.setStroke(Paint.valueOf(getColor().toString()));
		g.setFill(Paint.valueOf(getFillColor().toString()));
		Point b = (Point)getPosition();
		Point b1 = new Point(getProperties().get("Point1X").intValue(),getProperties().get("Point1Y").intValue());
		Point b2 = new Point(getProperties().get("Point2X").intValue(),getProperties().get("Point2Y").intValue());
		Point b3 = new Point(getProperties().get("Point3X").intValue(),getProperties().get("Point3Y").intValue());
		g.strokeLine(b1.getX(), b1.getY(), b2.getX(), b2.getY());
		g.strokeLine(b2.getX(), b2.getY(), b3.getX(), b3.getY());
		g.strokeLine(b3.getX(), b3.getY(), b.getX(), b.getY());
			}

}
