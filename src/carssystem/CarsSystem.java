package carssystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CarsSystem {

    static Scanner input;
    static int selected;
    static ArrayList<SmallCar> smallCars;
    static ArrayList<MeduimCar> meduimCars;
    static ArrayList<LargeCar> largeCars;
    static String directory = "C:\\Users\\HP-250-G7\\Documents\\NetBeansProjects\\Cars-System\\";
    static String smallCarsData = directory + "SmallCarsData.text";
    static String meduimCarsData = directory + "MeduimCarsData.text";
    static String largeCarsData = directory + "LargeCarsData.text";

    public static void main(String[] args) {
        while (true) {
            try {
                if (mainFunction() == 5) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\n\nSomething error, try agin!\n\n\n");
            }
        }

    }

    public static int mainFunction() {
        input = new Scanner(System.in);
        smallCars = new ArrayList<>();
        meduimCars = new ArrayList<>();
        largeCars = new ArrayList<>();
        readDataFromFile();

        welcoming();
        do {
            selected = selection(textFirstSelection());
            switch (selected) {
                case 1 ->
                    showAllCars();
                case 2 ->
                    addCar();
                case 3 ->
                    deleteCar();
                case 4 ->
                    saveDataInFile();

            }
            System.out.println("\n\n---------------------------------------------\n\n");
        } while (selected != 5);
        return selected;
    }

    public static void welcoming() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("------------------ Welcome in Cars System App ------------------");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("\n\n\n");
    }

    public static int selection(String text) {
        System.out.println(text);

        int s = input.nextInt();
        System.out.println("\n\n");
        return s;
    }

    public static void showAllCars() {
        System.out.println("-------------------------------------- Small Car --------------------------------------\n");
        if (smallCars.size() > 0) {
            for (SmallCar smallCar : smallCars) {
                System.out.println(smallCar.toString());
            }
        } else {
            System.out.println("Not available any small car.");
        }
        System.out.println("\n\n");

        System.out.println("-------------------------------------- Meduim Car --------------------------------------\n");
        if (meduimCars.size() > 0) {
            for (MeduimCar meduimCar : meduimCars) {
                System.out.println(meduimCar.toString());
            }
        } else {
            System.out.println("Not available any meduim car.");

        }
        System.out.println("\n\n");
        System.out.println("-------------------------------------- Large Car --------------------------------------\n");
        if (largeCars.size() > 0) {
            for (LargeCar largeCar : largeCars) {
                System.out.println(largeCar.toString());
            }
        } else {
            System.out.println("Not available any large car.");
        }
        System.out.println("\n\n");
    }

    public static void addCar() {
        int selectAddCar = 0;
        do {
            selectAddCar = selection(textSelectionTypeCar());
            switch (selectAddCar) {
                case 1 ->
                    createCar(1);
                case 2 ->
                    createCar(2);
                case 3 ->
                    createCar(3);

            }
        } while (selectAddCar != 4);
    }

    public static void createCar(int type) {

        System.out.println("Enter id car: ");
        int id = input.nextInt();
        System.out.println("Enter color at car: ");
        String color = input.next();
        System.out.println("Enter speed car(km/h): ");
        int speed = input.nextInt();
        System.out.println("Enter number door of car");
        int door = input.nextInt();
        System.out.println("Enter number windows of car");
        int windows = input.nextInt();
        System.out.println("Enter width car: ");
        double width = input.nextDouble();
        System.out.println("Enter hieght car ");
        double hieght = input.nextDouble();

        input.nextLine();
        if (type == 1) {
            System.out.println("Enter description bag car: ");
            String bag = input.nextLine();
            System.out.println("Enter status of steering car");
            String steering = input.nextLine();
            SmallCar smallCar = new SmallCar(bag, steering, id, color, speed, door, windows, width, hieght);
            smallCars.add(smallCar);
        } else if (type == 2) {
            System.out.println("Enter 1 or 0 for status condition: ");
            int conditioning = input.nextInt();
            boolean isConditioning;
            if (conditioning == 1) {
                isConditioning = true;
            } else {
                isConditioning = false;
            }
            MeduimCar meduimCar = new MeduimCar(isConditioning, id, color, speed, door, windows, width, hieght);
            meduimCars.add(meduimCar);
        } else if (type == 3) {
            System.out.println("Enter level voice: ");
            double voice = input.nextDouble();
            LargeCar largeCar = new LargeCar(voice, id, color, speed, door, windows, width, hieght);
            largeCars.add(largeCar);
        }

        System.out.println("Created Car successfully.\n\n");

    }

    public static int deleteCar() {
        System.out.println("\n\n");
        System.out.println("Enter id of car you need deleted: ");
        int id = input.nextInt();
        System.out.println("\n");
        for (SmallCar smallCar : smallCars) {
            if (smallCar.getId() == id) {
                smallCars.remove(smallCar);
                System.out.println("Deleted Succesfully.");
                return 0;
            }
        }

        for (MeduimCar meduimCar : meduimCars) {
            if (meduimCar.getId() == id) {
                meduimCars.remove(meduimCar);
                System.out.println("Deleted Succesfully.");
                return 0;
            }
        }

        for (LargeCar largeCar : largeCars) {
            if (largeCar.getId() == id) {
                largeCars.remove(largeCar);
                System.out.println("Deleted Successfully.");
                return 0;
            }
        }

        System.out.println("Not found this id, try again!");
        System.out.println("\n");
        return 0;

    }

    public static String textSelectionTypeCar() {
        return """
                                                  Second Page 2
                           1. Small Cars.
                           2. Meduim Cars.
                           3. Large Cars.
                           4. Exit.
                           Please select your choice[1, 2, 3 or 4]:""";
    }

    public static String textFirstSelection() {
        return """
                                                  First Page 1
               
                           1. Show Cars.
                           2. Add Cars.
                           3. Delete Cars.
                           4. Save Data.
                           5. Exit.
                           Please select your choice[1, 2, 3 or 4]:""";
    }

    public static void saveDataInFile() {
        try {
            Path path = Paths.get(directory);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            saveSmallCars();
            saveMeduimCars();
            saveLargeCars();
            System.out.println("\n\n Save data successfully \n\n");

        } catch (IOException ex) {
            Logger.getLogger(CarsSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveSmallCars() throws IOException {
        String fileDirectory = smallCarsData;
        FileWriter fileWriter = new FileWriter(fileDirectory, false);
        PrintWriter printWriter = new PrintWriter(fileWriter, true);
        printWriter.println("Id, Color, Width, Hieght, Doors, Windows, Speed, Bag, Steering");

        for (SmallCar smallCar : smallCars) {
            printWriter.println(smallCar.getId() + "," + smallCar.getColor() + "," + smallCar.getWidth()
                    + "," + smallCar.getHieght() + "," + smallCar.getDoors() + ","
                    + smallCar.getWindows() + "," + smallCar.getSpeed() + "," + smallCar.getBag() + ","
                    + smallCar.getSteering());
        }
        printWriter.close();
    }

    public static void saveMeduimCars() throws IOException {
        String fileDirectory = meduimCarsData;
        FileWriter fileWriter = new FileWriter(fileDirectory, false);
        PrintWriter printWriter = new PrintWriter(fileWriter, true);
        printWriter.println("Id, Color, Width, Hieght, Doors, Windows, Speed, IsConditioning");

        for (MeduimCar meduimCar : meduimCars) {
            printWriter.println(meduimCar.getId() + "," + meduimCar.getColor() + "," + meduimCar.getWidth()
                    + "," + meduimCar.getHieght() + "," + meduimCar.getDoors() + ","
                    + meduimCar.getWindows() + "," + meduimCar.getSpeed() + "," + meduimCar.getIsConditioning());
        }
        printWriter.close();
    }

    public static void saveLargeCars() throws IOException {
        String fileDirectory = largeCarsData;
        FileWriter fileWriter = new FileWriter(fileDirectory, false);
        PrintWriter printWriter = new PrintWriter(fileWriter, true);
        printWriter.println("Id, Color, Width, Hieght, Doors, Windows, Speed, voice");

        for (LargeCar largeCar : largeCars) {
            printWriter.println(largeCar.getId() + "," + largeCar.getColor() + "," + largeCar.getWidth()
                    + "," + largeCar.getHieght() + "," + largeCar.getDoors() + ","
                    + largeCar.getWindows() + "," + largeCar.getSpeed() + "," + largeCar.getVoice());
        }
        printWriter.close();
    }

    public static void readDataFromFile() {
        try {
            readSmallCarsData();
            readMeduimCarsData();
            readLargeCarsData();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarsSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readSmallCarsData() throws FileNotFoundException {
        File myObj = new File(smallCarsData);
        if (myObj.exists() && !myObj.isDirectory()) {
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] carLine = data.split(",");
                SmallCar smallCar = new SmallCar();
                smallCar.setId(Integer.parseInt(carLine[0]));
                smallCar.setColor(carLine[1]);
                smallCar.setWidth(Double.parseDouble(carLine[2]));
                smallCar.setHieght(Double.parseDouble(carLine[3]));
                smallCar.setDoors(Integer.parseInt(carLine[4]));
                smallCar.setWindows(Integer.parseInt(carLine[5]));
                smallCar.setSpeed(Integer.parseInt(carLine[6]));
                smallCar.setBag(carLine[7]);
                smallCar.setSteering(carLine[8]);
                smallCars.add(smallCar);
            }
            myReader.close();
        }
    }

    public static void readMeduimCarsData() throws FileNotFoundException {
        File myObj = new File(meduimCarsData);
        if (myObj.exists() && !myObj.isDirectory()) {
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] carLine = data.split(",");
                MeduimCar meduimCar = new MeduimCar();
                meduimCar.setId(Integer.parseInt(carLine[0]));
                meduimCar.setColor(carLine[1]);
                meduimCar.setWidth(Double.parseDouble(carLine[2]));
                meduimCar.setHieght(Double.parseDouble(carLine[3]));
                meduimCar.setDoors(Integer.parseInt(carLine[4]));
                meduimCar.setWindows(Integer.parseInt(carLine[5]));
                meduimCar.setSpeed(Integer.parseInt(carLine[6]));
                meduimCar.setIsConditioning(Boolean.parseBoolean(carLine[7]));
                meduimCars.add(meduimCar);
            }
            myReader.close();
        }

    }

    public static void readLargeCarsData() throws FileNotFoundException {
        File myObj = new File(largeCarsData);
        if (myObj.exists() && !myObj.isDirectory()) {
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] carLine = data.split(",");
                LargeCar largeCar = new LargeCar();
                largeCar.setId(Integer.parseInt(carLine[0]));
                largeCar.setColor(carLine[1]);
                largeCar.setWidth(Double.parseDouble(carLine[2]));
                largeCar.setHieght(Double.parseDouble(carLine[3]));
                largeCar.setDoors(Integer.parseInt(carLine[4]));
                largeCar.setWindows(Integer.parseInt(carLine[5]));
                largeCar.setSpeed(Integer.parseInt(carLine[6]));
                largeCar.setVoice(Double.parseDouble(carLine[7]));
                largeCars.add(largeCar);
            }
            myReader.close();
        }

    }

}
