package utility;
import objects.Shelter;
import objects.User;

import java.util.Scanner;
import java.util.ArrayList;

import objects.Pet;

public class Ink {
  private Scanner input = new Scanner(System.in);
  private int choice;
  private String greenText = "\u001B[32m";
  private String orangeText = "\u001B[34m";
  private String yellowText = "\u001B[33m";
  private String redText = "\u001B[31m";
  private String textReset = "\u001B[37m";

  public void printWelcome() {
    // do nothing yet...
  } // printWelcome()

  public void printHours(Shelter shelter) {
    String[] hours = shelter.getHours();
    for (int i = 0; i < hours.length; i++) {
      System.out.println(hours[i]);
    }
  }

  public void printGoodday() {
    System.out.println(orangeText + "Have a great day pet lover" + textReset);
  } // printGoodday()

  public int validateMainMenu() {
    boolean valid = false;

    while(!valid) {
      System.out.println(yellowText + "##### MAIN MENU #####");
      System.out.println("(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Confirm Appointment\n(5) Exit" + textReset);
      try {
        choice = input.nextInt();
        if(choice >= 1 && choice <=5) {
          valid = true; // escapes loop only if choice is correct dt and range
        }
        else {
          System.out.println("Please enter a 1 - 4");
        }
      }
      catch (Exception e) { // runs on exception
        System.out.println("That's not a number!");
      }
      finally { // always runs!
        input.nextLine();
      }
    } // while
    return choice;
  } // printMenu()

  public void printPetDetails(Pet pet) {
    System.out.printf("Name: %s\n", pet.getName());
    System.out.printf("Age: %d\n", pet.getAge());
    System.out.printf("Breed: %s\n", pet.getBreed());
    System.out.printf("Color: %s\n", pet.getColor());
    System.out.printf("Owner: %s\n", pet.getOwner());
    System.out.printf("Is Adopted: %b\n", pet.getIsAdopted());
    System.out.println("Adopt this pet? Y/N");
  } // printPetDetails()

  public void printAvailablePets(ArrayList<Pet> pets) {
    for(int i = 0; i < pets.size(); i++) {
      if(!pets.get(i).getIsAdopted()) {
        System.out.printf("%s(%d) Name: %s Type: %s Age: %d%s\n",orangeText, i + 1,
          pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getAge(),textReset);
      }
    } // for
    System.out.println(redText + "Enter 0 to go back" + textReset);
  } // printAvailablePets()

  public void printShelterDetails(Shelter shelter) {
    System.out.printf("%sShelter Address: %s\n",yellowText ,shelter.getAddress());
    printHours(shelter);// for
    System.out.println(greenText + "hit any key to go back" + textReset);
    input.nextLine();
  } // printShelterDetails

  public void printAppointmentTimes(Shelter shelter) {
    System.out.println(greenText + "The shelter is open:");
    printHours(shelter);
    System.out.println("Please select an available date:");
    System.out.println("(1) Monday\n(2) Tuesday\n(3) Wednesday\n(4) Thursday\n(5) Friday \n" + textReset);
  }

  public void printAppointmentConfirmation(User user) {
    System.out.printf("%s %s's appoint on %s confirmed \n%s",greenText,user.getName(),user.getAppointmentDate(),textReset);
  }

  public void printAppointmentValidation(User user){
    if (user.getAppointmentDate().equalsIgnoreCase("please book")) {
      System.out.println(redText + user.getAppointmentDate().toUpperCase() + textReset);
    } else {
        System.out.printf("%s Would you like to cancel your %s appointment? (Y/N)%s\n", redText,user.getAppointmentDate(),textReset);
        while (true) {
          String cancel = input.nextLine();
          if (cancel.equalsIgnoreCase("Y")) {
            user.setAppointmentDate("Please Book");
            System.out.println(redText + "Appointment has been cancelled" + textReset);
            break;
          } else if (cancel.equalsIgnoreCase("N")) {
            printAppointmentConfirmation(user);
            break;
          } else {
            System.out.println("Please enter Y or N");
          }
        }
    }
  }
} // class