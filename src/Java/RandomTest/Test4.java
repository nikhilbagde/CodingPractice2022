package Java.RandomTest;

/**
 * Created by Nikhil on 1/4/2017 5:09 AM.
 */
class Shape {
    public void drawShape() {//code to draw a shape
        System.out.println("In Shape");
    }
}

class Circle extends Shape {
    public void drawShape() {//code to draw a circle
        System.out.println("In Circle");
    }
}

class Square extends Shape {
    public void drawShape() {//code to draw a square
        System.out.println("in Sqare");
    }
}

public class Test4 {
    public static void main(String[] args) {
        Shape shape;
        shape = (Shape) (new Circle());
        shape.drawShape();

    }
}
