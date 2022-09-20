package carssystem;

public class MeduimCar extends Car{
    private boolean isConditioning;

    public MeduimCar() {
    }

    
    public MeduimCar(boolean isConditioning) {
        this.isConditioning = isConditioning;
    }

    public MeduimCar(boolean isConditioning, int id, String color, int speed, int doors, int windows, double width, double hieght) {
        super(id, color, speed, doors, windows, width, hieght);
        this.isConditioning = isConditioning;
    }

    public boolean getIsConditioning() {
        return isConditioning;
    }

    public void setIsConditioning(boolean isConditioning) {
        this.isConditioning = isConditioning;
    }

   
    
    
    
     @Override
    public String toString() {
        return "Car { " + "id = " + getId() + ", color = " + getColor() + ", speed=" + getSpeed() + ", doors=" + getDoors() + ", windows=" + getWindows() + ",  width = " + getWidth() + ",  hieght = " + getHieght() + " isConditioning = "  + isConditioning + " }";
    }
    
}
