import java.util.ArrayList;
import java.util.Scanner;

// Класс Студент
class Car {

    private int id;             // Уникальный идентифиактор
    private String marc;   // Модель
    private String model;  // Марка
    private String color;   // Цвет
    private int Date;   // Дата выпуска
    private String idNumber;     // Рег. Номер
    private int cost;         // Цена

    // Конструктор класса автомобиль
    public Car(String marc, String model, String color) {
        this.id = 1;
        this.marc = marc;
        this.model = model;
        this.color = color;
        this.Date = 0;
        this.idNumber = "";
        this.cost = 0;
    }
    
    // Установить студенту идентифиактор
    public void setId(int id) {
        this.id = id;
    }
    
    // Привести объект класса Студент к строковому виду
    public String toString() {
        return marc + " " + model + " " + color;
    }

    //Установить модель 
    public void setModel(String model) {
        this.model = model;
    }
    
    //Получить модель
    public String getModel() {
        return model;
    }

    //Установить марку
    public void setMarc(String marc) {
        this.model = marc;
    }
    
    //Получить марку
    public String getMarc() {
        return marc;
    }

    // Установить студенту факультет
    public void setidNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    // Получить факультет студента
    public String getidNumber() {
        return idNumber;
    }
    
    // Установить цену
    public void setcost(int cost) {
        this.cost = cost;
    }
    
    // Получить цену
    public int getcost() {
        return cost;
    }
    
    // Установить год выпуска
    public void setDate(int Date) {
        this.Date = Date;
    }
    
    // Получить год выпуска
    public int getDate() {
        return Date;
    }
    
}



// Класс Хранилище автомобилей
class CarsStorage {
    
    private ArrayList<Car> storage; // Массив хранилище автомобилей
    
    // Конструктор Хранилища
    public CarsStorage() {
        storage = new ArrayList<>();
    }
    
    // Добавить автомобиль в хранилище
    public void addCar(Car Car) {
        int id = storage.size() + 1;
        Car.setId(id);
        storage.add(Car);
    }
    
    // Привидение объекта хранилища к строковому виду
    public String toString() {
        String res = "\n";
        for (int i = 0; i < storage.size(); i++) {
            Car Car = storage.get(i); 
            if ( !(i == storage.size() - 1) ) {
                res += Car.getMarc();
                res += "\n";
            } else {
                res += Car.getMarc();
            }            
        }
        res += "\n";
        return res;
    }
    
    // Получить автомобили по маркам (а)
    public String getCarsByidNumber(String marc) {
        Scanner in = new Scanner(System.in);
        marc = in.next().toString();
        String res = "";

        for (int i = 0; i < storage.size(); i++) {
            Car Car = storage.get(i);
            String test = Car.getMarc();
            if (test == marc) {
                res += Car + "; ";
            }

        }
        in.close();
        return res;
    }
    
    // Получить автомобили по модели и эксплуатация больше n лет (b)
    public String getCarsByYear(int year, String marc) {
        String res = "";

        for (int i = 0; i < storage.size(); i++) {
            Car Car = storage.get(i);
            

            if (((2021 - Car.getDate()) > year) && (Car.getMarc() == marc)) {
                res += Car + "; ";
            }
        }

        return res;
    }
    
    // Получить автомобили заданного года выпуска, цена которых больше указанной (с)
    public String getCarsByGroup(int year, int cost) {
        String res = "";

        for (int i = 0; i < storage.size(); i++) {
            Car Car = storage.get(i);

            if ((Car.getDate() == year) && (Car.getcost() > cost)){
                res += Car + "; ";
            }
        }

        return res;
    }

}

class Main {
    public static void main(String[] args) {

        CarsStorage storage = new CarsStorage();

        Car s1 = new Car("Mercedes-Benz", "S600", "Gray");
        s1.setidNumber("ju 2004");
        s1.setcost(400000);
        s1.setDate(2005);

        Car s2 = new Car("Toyota", "Cavalier", "Gray");
        s2.setidNumber("tc 879");
        s2.setcost(150000);
        s2.setDate(1999);

        Car s3 = new Car("Alfa Romeo", "Giulia", "Red");
        s3.setidNumber("aw 458");
        s3.setcost(2500000);
        s3.setDate(1962);

        Car s5 = new Car("Dodge",  "Challenger |||",  "Gray");
        s5.setidNumber("as 556");
        s5.setcost(3000000);
        s5.setDate(2016);

        storage.addCar(s1);
        storage.addCar(s2);
        storage.addCar(s3);
        storage.addCar(s5);

        Scanner in = new Scanner(System.in);
        System.out.print("Cписок автомобилей марки ");	
        System.out.println(storage.getCarsByidNumber(""));

        System.out.println("==============================================================================================================================");
        System.out.println("Cписок автомобилей марки Mercedes-Benz, которые эксплуатируются больше 10 лет: " + storage.getCarsByYear(10, "Mercedes-Benz"));
				
        System.out.println("==============================================================================================================================");
        System.out.println("Список автомобилей 2016 года выпуска, цена которых больше 200 000: " + storage.getCarsByGroup(2016, 200000));
        in.close();

    }
}