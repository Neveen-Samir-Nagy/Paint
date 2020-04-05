package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javafx.util.Pair;

public class Draw implements DrawingEngine {

	LinkedList<Shape> ShapeList = new LinkedList<Shape>();
	Stack<Shape> UndoRedo = new Stack<Shape>();
	LinkedList<Pair<Shape, Shape>> updates = new LinkedList<Pair<Shape, Shape>>();
	Stack<LinkedList<Shape>> undo = new Stack<LinkedList<Shape>>();
	Stack<LinkedList<Shape>> redo = new Stack<LinkedList<Shape>>();

	@Override
	public void refresh(Object canvas) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < ShapeList.size(); i++) {
			ShapeList.get(i).draw(canvas);
		}
	}

	@Override
	public void addShape(Shape shape) {
		// TODO Auto-generated method stub
		if (redo.size() == 20) {
			undo.clear();
		}
		if (ShapeList.size() != 0) {
			undo.push(new LinkedList<Shape>(ShapeList));
		}
		ShapeList.add(shape);
	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		if (redo.size() == 20) {
			undo.clear();
		}
		for (int i = 0; i < ShapeList.size(); i++) {
			if (ShapeList.get(i).equals(shape)) {
				undo.push(new LinkedList<Shape>(ShapeList));
				ShapeList.remove(i);
				return;
			}
		}
		throw new UnsupportedOperationException("Error");
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		if (redo.size() == 20) {
			undo.clear();
		}
		for (int i = 0; i < ShapeList.size(); i++) {
			if (ShapeList.get(i).equals(oldShape)) {
				undo.push(new LinkedList<Shape>(ShapeList));
				
				ShapeList.set(i, newShape);
				return;
			}
		}
		throw new UnsupportedOperationException("Error");
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		Shape[] shape;
		shape = new Shape[ShapeList.size()];
		for (int i = 0; i < ShapeList.size(); i++) {
			shape[i] = ShapeList.get(i);
		}
		return shape;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		List<Class<? extends Shape>> shapes = new ArrayList<Class<? extends Shape>>();
		File pathToJar = new File(
				"C:\\Users\\EL-hamd\\git\\paint\\Draw\\RoundRectangle.jar");

		JarFile jarFile;
		try {
			jarFile = new JarFile(pathToJar);
			Enumeration<JarEntry> e = jarFile.entries();

			URL[] urls = { new URL("jar:file:" + pathToJar + "!/") };
			URLClassLoader cl = URLClassLoader.newInstance(urls);

			while (e.hasMoreElements()) {
				JarEntry je = e.nextElement();
				if (je.isDirectory() || !je.getName().endsWith(".class")) {
					continue;
				}
				// -6 because of .class
				String className = je.getName().substring(0, je.getName().length() - 6);
				className = className.replace('/', '.');
				try {
					Class c = cl.loadClass(className);
					shapes.add(c);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return shapes;

	}

	@Override
	public void undo() {
		if (redo.size() == 20) {
			redo.remove(0);
			if (undo.size() != 0 && ShapeList.size() != 1) {
				redo.push(new LinkedList<Shape>(ShapeList));
				ShapeList = new LinkedList<Shape>(undo.pop());
			} else if (ShapeList.size() == 1) {
				redo.push(new LinkedList<Shape>(ShapeList));
			}
		} else {
			if (undo.size() != 0) {
				redo.push(new LinkedList<Shape>(ShapeList));
				ShapeList = new LinkedList<Shape>(undo.pop());
			} else if (undo.size() == 0) {
				redo.push(new LinkedList<Shape>(ShapeList));
				ShapeList = new LinkedList<Shape>();
			}
		}
	}

	@Override
	public void redo() {
		{
			undo.push(new LinkedList<Shape>(ShapeList));
			ShapeList = new LinkedList<Shape>(redo.pop());
		}
	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub
		if (path.toLowerCase().contains("xml")) {
			SaveXML xml = new SaveXML();
			xml.XML(ShapeList, path);
		} else {
			saveJson json = new saveJson();
			json.Json(ShapeList, path);
		
		}
	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		if (path.toLowerCase().contains("xml")) {
			LoadXML xml = new LoadXML();
			ShapeList = new LinkedList<Shape>(xml.loadXML(path));
		} else {
			LoadJson json = new LoadJson();
			ShapeList = new LinkedList<Shape>(json.loadjson(path));
		}
	}

}