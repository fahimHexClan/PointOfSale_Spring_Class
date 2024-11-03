package com.Pos.PointOfSale.Entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")

public class CustomerEntity implements Serializable {

    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 150)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Type(value = JsonType.class)  // Use the JsonType class directly
    @Column(name = "contact_numbers", columnDefinition = "json")
    private ArrayList<String> contactNumbers;

    @Column(name = "nic", length = 12, unique = true)
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "customer")
    private Set<OrderEntity> orders;

    // Default constructor
    public CustomerEntity() {
    }

    // Parameterized constructor
    public CustomerEntity(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList<String> contactNumbers, String nic, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeState = activeState;
    }

    public CustomerEntity(String customerName, String customerAddress, double customerSalary, ArrayList<String> contactNumbers, String nic, boolean activeState) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeState = activeState;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public ArrayList<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contactNumbers=" + contactNumbers +
                ", nic='" + nic + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}
