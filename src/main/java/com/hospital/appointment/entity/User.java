package com.hospital.appointment.entity;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date DateOfBirth;
    private String gender;
    /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

    // Many-to-Many relationship: A user can consult multiple doctors, but only one appointment at a time.
    @ManyToMany
    @JoinTable(
      name = "user_doctor", 
      joinColumns = @JoinColumn(name = "user_id"), 
      inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private Set<Doctor> doctors = new HashSet<>();

    // One-to-Many relationship: A user can have multiple reminders for appointments.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reminder> reminders = new HashSet<>();

    // Many-to-Many relationship: A user can book availability slots based on doctor's availability.
    @ManyToMany
    @JoinTable(
      name = "user_availability", 
      joinColumns = @JoinColumn(name = "user_id"), 
      inverseJoinColumns = @JoinColumn(name = "availability_slot_id"))
    private Set<AvailabilitySlot> availabilitySlots = new HashSet<>();*/
    public User() {
    }
    public User(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        DateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    public Long getId() {
        return userId;
    }
    public void setId(Long id) {
        this.userId = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getDateOfBirth() {
        return DateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
