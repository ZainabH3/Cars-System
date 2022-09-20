package carssystem;

public class LargeCar extends Car {

    private double voice;

    public LargeCar() {
    }

    
    public LargeCar(double voice) {
        this.voice = voice;
    }

    public LargeCar(double voice, int id, String color, int speed, int doors, int windows, double width, double hieght) {
        super(id, color, speed, doors, windows, width, hieght);
        this.voice = voice;
    }

    public double getVoice() {
        return voice;
    }

    public void setVoice(double voice) {
        this.voice = voice;
    }
    
    

    @Override
    public String toString() {
        return "Car { " + "id = " + getId() + ", color = " + getColor() + ", speed=" + getSpeed() + ", doors=" + getDoors() + ", windows=" + getWindows() + ",  width = " + getWidth() + ",  hieght = " + getHieght() + " voice = " + voice + " }";
    }

}
