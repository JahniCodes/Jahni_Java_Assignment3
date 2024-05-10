import utility.*;
import objects.*;
import java.util.Scanner;

public class Adopt_a_pet {
  private static Scanner input = new Scanner(System.in);
  private static Ink ink = new Ink();
  private static User user;
  private static Shelter shelter = new Shelter();
  private static Pet pet;

  private static int choice;
  private static boolean isDone = false;
  private static boolean goBack = false;

  public static void main(String[] args) {

    createUser(); // create the user
    createPets(); // helper pets

    while(!isDone) {
      choice = ink.validateMainMenu();

      switch (choice) {
        case 1: // print available pets
          ink.printAvailablePets(shelter.getPets());
          while(!goBack) {
            int pick = input.nextInt();
            if(pick != 0) {
              ink.printPetDetails(shelter.getPet(pick - 1));
              String answer = input.next();
              if(answer.equalsIgnoreCase("Y")) {
                shelter.adopt(pick - 1, user.getName());
                goBack = !goBack;
              }
              else {
                goBack = !goBack;
              }
            }
            else {
              goBack = !goBack;
            }
          } // while
          break;
        case 2: // print shelter details
          ink.printShelterDetails(shelter);
          while(!goBack) {
            input.nextLine();
            goBack = !goBack;
          } // while
          break;
        case 3: // book an appointment menu
          ink.printAppointmentTimes(shelter);
          while (!goBack) {
            int date = 0;
            boolean valid = false;
            while (!valid) {
              date = input.nextInt();
              switch (date) {
                case 1:
                  user.setAppointmentDate("Monday");
                  valid = !valid;
                  break;
                case 2:
                  user.setAppointmentDate("Tuesday");
                  valid = !valid;
                  break;
                case 3:
                  user.setAppointmentDate("Wednesday");
                  valid = !valid;
                  break;
                case 4:
                  user.setAppointmentDate("Thursday");
                  valid = !valid;
                  break;
                case 5:
                  user.setAppointmentDate("Friday");
                  valid = !valid;
                  break;
                default:
                  System.out.println("Please select a valid date.");
                  break;
              }

            }
            ink.printAppointmentConfirmation(user);
            if (date > 0 && date <= 5) {
              goBack = !goBack;
            }
          }
          break;
        case 4:
          while (!goBack) {
            ink.printAppointmentValidation(user);

            if (user.getAppointmentDate().equalsIgnoreCase("Please Book")) {
              goBack = !goBack;
            }
          }
          break;
        case 5:
          isDone = true;
          break;
      } // switch
      goBack = !goBack; // seems wrong but it is NOT wrong
    } // while(main)

    ink.printGoodday();
  } // main()

  // 100% for test data!
  public static void createPets() {
    pet = new Pet("spot", "dog",
      3, "black", "hound");
    shelter.addPet(pet);
    pet = new Pet("cleveland", "dog",
      7, "brown", "boxer");
    shelter.addPet(pet);
    pet = new Pet("monster", "cat",
      1, "calico", "calico");
    shelter.addPet(pet);
  } // createPets()

  public static void createUser() {
    String name, email;
    int phone;
    System.out.println("What is your name? ");
    name = input.nextLine();
    System.out.println("What is your email? ");
    email = input.nextLine();
    System.out.println("What is your phone? ");
    phone = input.nextInt();
    user = new User(name, email, phone);
  } // createUser()

} // class