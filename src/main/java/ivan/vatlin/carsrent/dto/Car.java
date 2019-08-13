package ivan.vatlin.carsrent.dto;

public class Car {
    private long id;
    private String model;
    private String registrationNumber;
    private double pricePerDay;

    public Car(long id, String model, String registrationNumber, double pricePerDay) {
        this.id = id;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.pricePerDay = pricePerDay;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
