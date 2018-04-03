/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelproject_arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author vinay
 */
public class Hotelproject_arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        Scanner exit = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Room[] myHotel = new Room[11];

        initialise(myHotel);
        System.out.println("Press 1 to enter the menu.");
        int exit1 = exit.nextInt();
        while (exit1 != 11) {
            System.out.println("Enter 'V' to view all rooms ");
            System.out.println("Enter 'A' to add customer to a room");
            System.out.println("Enter 'E' to to view all empty rooms");
            System.out.println("Enter 'D' to delete customer from the room");
            System.out.println("Enter 'F' to find the room number of the customer");
            System.out.println("Enter 'O' to arrange the rooms in assending order");
            System.out.println("Enter 'L' to load data");
            System.out.println("Enter 'S' to save data");
            System.out.println("Enter 'Q' to exit the menu");
            String menu = in.next();
            char menu1 = menu.charAt(0);
            if (menu1 == 'Q') {
                exit1 = 11;
                continue;
            }

            switch (menu) {
                case "V": {
                    View(myHotel);
                    break;
                }

                case "E": {
                    Empty(myHotel);
                    break;
                }

                case "A": {
                    ADD(myHotel);
                    break;
                }

                case "D": {
                    DELETE(myHotel);
                    break;
                }

                case "F": {
                    Find(myHotel);
                    break;
                }

                case "L": {
                    LoadFile(myHotel);
                    break;
                }

                case "S": {
                    StoreFile(myHotel);
                    break;
                }

            }
        }

    }

    private static void initialise(Room hotelRef[]) {
        for (int i = 0; i < 10; i++) {
            hotelRef[i] = new Room();
            hotelRef[i].setName("Empty");
            hotelRef[i].setRoom(i + 1);
        }
    }

    private static void View(Room hotelRef[]) {
        for (int x = 0; x < 10; x++) {
            System.out.println("Room " + x + " occupied by " + hotelRef[x].getName());
        }
    }

    private static void Empty(Room hotelRef[]) {
        for (int x = 0; x < 10; x++) {
            if (hotelRef[x].getName() == "Empty") {
                System.out.println("Room " + x + " is empty");
            }
        }
    }

    private static void ADD(Room hotelRef[]) {
        Scanner input = new Scanner(System.in);
        int roomNum = 0;
        String roomName;
        while (roomNum < 4) {
            for (int x = 0; x < 10; x++) {
                if (hotelRef[x].getName() == "Empty") {
                    System.out.println("Room " + x + " is empty");
                }
            }
            System.out.println("Enter room number (0-9) or 10 to stop:");
            roomNum = input.nextInt();
            if (roomNum == 10) {
                roomNum = 10;
                continue;
            }
            System.out.println("Enter name for room " + roomNum + ":");
            roomName = input.next();
            hotelRef[roomNum].setName(roomName);
            for (int x = 0; x < 10; x++) {

                System.out.println("room " + x + " occupied by " + hotelRef[x].getName());
            }
        }
    }

    private static void DELETE(Room hotelRef[]) {
        Scanner delete = new Scanner(System.in);
        for (int x = 0; x < 10; x++) {
            System.out.println("Room " + x + " occupied by " + hotelRef[x].getName());
        }
        int delete1;
        int x;
        System.out.println("Select the room");
        delete1 = delete.nextInt();
        x = delete1;
        hotelRef[x].setName("Empty");

    }

    private static void Find(Room hotelRef[]) {
        Scanner find = new Scanner(System.in);
        String find1;
        System.out.println("Enter the name of the customer:");
        find1 = find.next();
        for (int x = 0; x < 10; x++) {
            // System.out.println("Room " + x + " occupied by " + hotel[x]);
            if (find1.equals(hotelRef[x].getName())) {
                System.out.println("The customer " + hotelRef[x].getName() + " is in the room " + x);
            }
        }

    }

    private static void LoadFile(Room hotelRef[]) throws IOException {
        Scanner console = new Scanner(System.in);

        int linecount = 0;
        System.out.println("Input file name: ");
        String inputFileName = console.next();

        String fileLine;
        Scanner in = new Scanner(new File(inputFileName));
        while (in.hasNext()) {
            fileLine = in.nextLine();
            hotelRef[linecount].setName(fileLine);
            System.out.println(linecount + " " + fileLine);
            linecount++;
        }
        in.close();
    }

    private static void StoreFile(Room hotelRef[]) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Output file: ");
        String outputFileName = console.next();
        try (PrintWriter outputFile = new PrintWriter(outputFileName)) {
            for (int j = 0; j < 10; j++) {
                outputFile.println(hotelRef[j].getName());
            }
        }
    }

}
