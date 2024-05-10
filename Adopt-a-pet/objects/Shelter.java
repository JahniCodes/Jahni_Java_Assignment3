package objects;
import java.util.ArrayList;

public class Shelter {

  private String address = "123 Scoopers Lane";
  private String[] hours = {
    "Mon: 8am - 4pm",
    "Tues: 8am - 4pm",
    "Wed: 8am - 4pm",
    "Thurs: 8am - 4pm",
    "Fri: 8am - 4pm",
    "Sat/Sun: closed"
  };
  // composition: a class made up of other classes
  private ArrayList<Pet> pets = new ArrayList<>();

  public Shelter() {
    // do nothing
  }

  //=============>>
  // GETTERS
  public String getAddress() {
    return this.address;
  }
  public String[] getHours() {
    return this.hours;
  }
  public ArrayList<Pet> getPets() {
    return this.pets;
  }
  public Pet getPet(int idx) {
    return pets.get(idx);
  }

  //=============>>
  // SETTERS
  public void setAddress(String address) {
    this.address = address;
  }
  public void setHours(String[] hours) {
    this.hours = hours;
  }
  public void adopt(int idx, String owner) {
    pets.get(idx).setIsAdopted();
    pets.get(idx).setOwner(owner);
    System.out.printf("%s is now yours!", pets.get(idx).getName());
    pets.remove(idx); // takes the pet from the shelter
  }
  public void addPet(Pet pet) {
    pets.add(pet);
  }
} // class