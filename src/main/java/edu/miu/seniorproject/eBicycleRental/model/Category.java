package edu.miu.seniorproject.eBicycleRental.model;

import javax.persistence.*;

import javax.validation.constraints.*;
import java.util.List;

import edu.miu.seniorproject.eBicycleRental.utility.VehicleType;

@Entity
@Table(name = "catagories")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

//    @Column(name = "category_name",nullable=false)
//    @NotBlank(message = "Please provide category name")
//    private String categoryName;
    
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;


    @Column(name = "rate_per_day",nullable=false)
//    @NotBlank(message = "Please provide rate per day")
    @DecimalMin(value = "0.00" , message = "Please provide rate per day")
    private Double ratePerDay;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;

    public Category() {
    }

    public Category(Long categoryId, String categoryName,
                    Double ratePerDay, VehicleType vehicleType) {
        this.categoryId = categoryId;
       // this.categoryName = categoryName;
        this.vehicleType=vehicleType;
        this.ratePerDay = ratePerDay;
    }

    public Category( String categoryName,
                    VehicleType vehicleType,
                    Double ratePerDay, List<Vehicle> vehicles) {
        //this.categoryName = categoryName;
        this.vehicleType=vehicleType;
        this.ratePerDay = ratePerDay;
        this.vehicles = vehicles;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

//    public String getCategoryName() {
//        return categoryName;
//    }

//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }

    

    public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Double getRatePerDay() {
        return ratePerDay;
    }

    public void setRatePerDay(Double ratePerDay) {
        this.ratePerDay = ratePerDay;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
//                ", categoryName='" + categoryName + '\'' +
                ", vehicleType=" + vehicleType +
                ", ratePerDay=" + ratePerDay +
                '}';
    }
}


