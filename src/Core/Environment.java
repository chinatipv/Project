package Core;

import java.awt.Color;
import java.util.ArrayList;

public class Environment {

	protected double[][] location = new double[4][2];
	private double intensity;
	private double density;
	private double refectionIndex;
	private ArrayList<Point> point = new ArrayList<Point>();
	private String property;
	private double movingSpeed;
	private double rotateSpeed;
	private double angle;// right is 0
	private double opacity;
	private Color color;

	public Environment(double x1, double y1, double x2, double y2, double x3,
			double y3, double x4, double y4, String property) {
		/*
		 * (x1,y2) (x2,y2) ----------------------------- | | | | | | | | | |
		 * ----------------------------- (x3,y3) (x4,y4)
		 */
		this.location[0][0] = x1;
		this.location[0][1] = y1;
		this.location[1][0] = x2;
		this.location[1][1] = y2;
		this.location[2][0] = x3;
		this.location[2][1] = y3;
		this.location[3][0] = x4;
		this.location[3][1] = y4;
		this.property = property;
		this.point.add(new Point(x1, y1));
		this.point.add(new Point(x2, y2));
		this.point.add(new Point(x3, y3));
		this.point.add(new Point(x4, y4));
	}

	public Environment(double x1, double y1, double width, double height) {
		this.location[0][0] = x1;
		this.location[0][1] = y1;
		this.location[1][0] = x1 + width;
		this.location[1][1] = y1;
		this.location[2][0] = x1;
		this.location[2][1] = y1 + height;
		this.location[3][0] = x1 + width;
		this.location[3][1] = y1 + height;
		this.point.add(new Point(x1, y1));
		this.point.add(new Point(x1 + width, y1));
		this.point.add(new Point(x1, y1 + height));
		this.point.add(new Point(x1 + width, y1 + height));
	}

	public double[][] getLocation() {
		return location;
	}

	public void setLocation(double[][] location) {
		this.location = location;
	}
	public ArrayList<Point> getPoint(){
		return point;
	}

	public boolean isIntercept2D(double x, double y) {
		double[][] thisLocation = this.getLocation();
		if (x >= location[0][0] && y >= location[0][1] && x <= location[1][0]
				&& y >= location[1][1] && x >= location[2][0]
				&& y <= location[2][1] && x <= location[3][0]
				&& y <= location[3][1])
			return true;
		return false;
	}
	public boolean isIntercept2D(Environment other) {
		for(int i=0;i<other.getPoint().size();i++){
			if(isIntercept2D(other.getPoint().get(i).getX(),other.getPoint().get(i).getY())){
				return true;
			}
		}
		return false;
	}
	public boolean isIntercept2D(Point p) {
		double[][] thisLocation = this.getLocation();
		if (p.getX() >= location[0][0] && p.getY() >= location[0][1]
				&& p.getX() <= location[1][0] && p.getY() >= location[1][1]
				&& p.getX() >= location[2][0] && p.getY() <= location[2][1]
				&& p.getX() <= location[3][0] && p.getY() <= location[3][1])
			return true;
		return false;
	}

	public void setMoingSpeed(double movingSpeed) {
		this.movingSpeed = movingSpeed;
	}

	public void addMovingSpeed(double movingSpeed) {
		this.movingSpeed += movingSpeed;
	}

	public void setRotateSpeed(double rotateSpeed) {
		this.rotateSpeed = rotateSpeed;
	}

	public void addRotateSpeed(double rotateSpeed) {
		this.rotateSpeed += rotateSpeed;
	}

	public double getMoingSpeed() {
		return this.movingSpeed;
	}

	public double getRotateSpeed() {
		return this.rotateSpeed;
	}

	public void setAngle(double angle) {
		this.angle = angle % 360;
	}

	public double getDirection() {
		return this.angle;
	}

	public void addAngle(double angle) {
		this.angle = (this.angle + angle) % 360;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void move() {
		for (int i = 0; i < point.size(); i++) {
			point.get(i).x += Math.cos(angle * Math.PI / 180);
			point.get(i).y += Math.sin(angle * Math.PI / 180);
		}
	}
	public void move(double mutiply) {
		for (int i = 0; i < point.size(); i++) {
			point.get(i).x +=mutiply*Math.cos(angle * Math.PI / 180);
			point.get(i).y +=mutiply*Math.sin(angle * Math.PI / 180);
		}
	}

}
