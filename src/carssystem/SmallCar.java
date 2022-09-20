package carssystem;
public class SmallCar extends Car{
    private String bag;
    private String steering;

    public SmallCar() {
    }

    public SmallCar(String bag, String steering) {
        this.bag = bag;
        this.steering = steering;
    }

    public SmallCar(String bag, String steering, int id, String color, int speed, int doors, int windows, double width, double hieght) {
        super(id, color, speed, doors, windows, width, hieght);
        this.bag = bag;
        this.steering = steering;
    }

    
    

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public String getSteering() {
        return steering;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }

    @Override
    public String toString() {
        return "Car { " + "id = " + getId() + ", color = " + getColor() + ", speed=" + getSpeed() + ", doors=" + getDoors() + ", windows=" + getWindows() + ",  width = " + getWidth() + ",  hieght = " + getHieght() + "  bag = " + bag + ",  steering = " + steering + " }";
    }
    
}
