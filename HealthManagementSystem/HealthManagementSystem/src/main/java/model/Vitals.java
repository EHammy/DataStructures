package model;

import java.time.LocalDate;

public class Vitals {
    private LocalDate date;
    private int bloodPressure;
    private int heartRate;
    private double temperature;
    private double weight;

    public Vitals(int bloodPressure, int heartRate, double temperature, double weight) {
        this.date = LocalDate.now();
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.weight = weight;
    }

    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public int getBloodPressure() {
        return bloodPressure;
    }
    
    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    
    public int getHeartRate() {
        return heartRate;
    }
    
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
