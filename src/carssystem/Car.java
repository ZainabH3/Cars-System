package carssystem;

abstract class Car {

    private int id;
    private String color;
    private int speed;
    private int doors;
    private int windows;
    private double width;
    private double hieght;

    public Car() {
    }

    
    public Car(int id, String color, int speed, int doors, int windows, double width, double hieght) {
        this.id = id;
        this.color = color;
        this.speed = speed;
        this.doors = doors;
        this.windows = windows;
        this.width = width;
        this.hieght = hieght;
    }

    
    
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDoors(int doors){
        this.doors = doors;
    }
    
    public int getDoors(){
        return doors;
    }
    
    public void setWindows(int windows){
        this.windows = windows;
    }
    
    public int getWindows(){
        return windows;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHieght() {
        return hieght;
    }

    public void setHieght(double hieght) {
        this.hieght = hieght;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    
    
    
}
