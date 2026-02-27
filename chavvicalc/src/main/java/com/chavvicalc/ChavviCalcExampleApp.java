package com.chavvicalc;

import java.util.*;

/*
 * chavvi calc calculator
 */
public class ChavviCalcExampleApp {

  // global variables
  private static double A = 0.0;
  private static double B = 0.0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Character command = '_';

    // loop until 'q' is pressed
    while (true) {
      // show menu with current values
      printMenu();

      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);

      // handle quitting
      if (command == 'q') {
        System.out.println("Thank you for using Chavvi Calc");
        break; // exit loop
      }

      // everything else still unimplemented
      executeCommand(scan, command);
    }

    scan.close();
  }

  //
  // menu functions
  //
  private static void printMenuLine() {
    System.out.println(
        "----------------------------------------------------------");
  }

  private static void printMenuCommand(Character command, String desc) {
    System.out.printf("%s\t%s\n", command, desc);
  }

  // prints the menu
  public static void printMenu() {
    printMenuLine();
    System.out.println("Chavvi Calc");
    printMenuLine();

    System.out.printf("A = %.3f\tB = %.3f\n", A, B);
    printMenuLine();

    printMenuCommand('a', "Enter a value for A");
    printMenuCommand('b', "Enter a value for B");
    printMenuCommand('+', "Add");
    printMenuCommand('-', "Subtract");
    printMenuCommand('*', "Multiply");
    printMenuCommand('/', "Divide");
    printMenuCommand('c', "Clear");
    printMenuCommand('q', "Quit");

    printMenuLine();
  }

  // get first character from input
  private static Character menuGetCommand(Scanner scan) {
    Character command = '_';

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      command = rawInput.charAt(0);
    }

    return command;
  }

  // calculator functions
  private static Boolean executeCommand(Scanner scan, Character command) {
    Boolean success = true;

    switch (command) {
      case 'a':
        System.out.print("Enter a value for A: ");
        A = scan.nextDouble();
        scan.nextLine();
        break;

      case 'b':
        System.out.print("Enter a value for B: ");
        B = scan.nextDouble();
        scan.nextLine();
        break;

      case '+':
        // A = A + B
        A = A + B;
        break;

      case '-':
        // A = A - B
        A = A - B;
        break;

      case '*':
        A = A * B;
        break;

      case '/':
        if (B == 0) {
          System.out.println("ERROR: Divide by zero");
          success = false;
        } else {
          A = A / B;
        }
        break;

      case 'c':
        A = 0.0;
        B = 0.0;
        break;

      case 'q':
        System.out.println("Thank you for using Chavvi Calc");
        break;
      default:
        System.out.println("ERROR: Unknown commmand");
        success = false;
    }

    return success;
  }
}
