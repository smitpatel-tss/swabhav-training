package com.tss.VehicleManagement;

import static com.tss.VehicleManagement.VehiclesConstants.*;
import static com.tss.utils.Validate.*;

public class MainVehicle {

    static Vehicle[] vehicles = new Vehicle[MAX_VEHICLES];
    static int count = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Start a Vehicle");
            System.out.println("3. Stop a Vehicle");
            System.out.println("4. Charge a Battery");
            System.out.println("5. Play Horn");
            System.out.println("6. Play Music");
            System.out.println("7. Inspection");
            System.out.println("8. Get Fuel Status");
            System.out.println("9. Exit");

            System.out.print("\nEnter Choice: ");
            int choice = validatePositiveInt();
            while (!(choice >= 1 && choice <= 9)) {
                System.out.print("Enter valid Option: ");
                choice = validatePositiveInt();
            }

            switch (choice) {
                case 1:
                    if (count == MAX_VEHICLES) {
                        System.out.println("You can't add more than " + MAX_VEHICLES + ". Maximum Limit reached!");
                        break;
                    }
                    vehicles[count++] = makeVehicle();
                    System.out.println("\nVehicle Created\nVehicle: " + vehicles[count - 1].getClass().getSimpleName() + "\nID: " + vehicles[count - 1].getId());
                    break;
                case 2:
                    startVehicle();
                    break;
                case 3:
                    stopVehicle();
                    break;
                case 4:
                    charging();
                    break;
                case 5:
                    playHorn();
                    break;
                case 6:
                    playMusic();
                    break;
                case 7:
                    inspection();
                    break;
                case 8:
                    fuelStatus();
                    break;
                case 9:
                    System.out.println("EXITING...");
                    return;
            }
        }


    }

    private static void fuelStatus() {
        if (count == 0) {
            System.out.println("Add Vehicle first!");
            return;
        }
        Vehicle myVehicle = getVehicleById();
        if (myVehicle == null) {
            System.out.println("No Such Vehicle Found!");
            return;
        }
        myVehicle.getFuelStatus();
    }

    private static void inspection() {
        if (count == 0) {
            System.out.println("Add Vehicle first!");
            return;
        }
        Vehicle myVehicle = getVehicleById();
        if (myVehicle == null) {
            System.out.println("No Such Vehicle Found!");
            return;
        }
        Vehicle.inspection(myVehicle);
    }

    private static void playMusic() {
        if (count == 0) {
            System.out.println("Add Vehicle first!");
            return;
        }

        Vehicle newVehicle = getVehicleById();
        if (newVehicle == null) {
            System.out.println("No Such Vehicle Found!");
            return;
        }
        newVehicle.playMusic();
    }

    private static void playHorn() {
        if (count == 0) {
            System.out.println("Add Vehicle first!");
            return;
        }

        Vehicle newVehicle = getVehicleById();
        if (newVehicle == null) {
            System.out.println("No Such Vehicle Found!");
            return;
        }
        newVehicle.horn();
    }

    private static void charging() {
        if (count == 0) {
            System.out.println("Add Vehicle first!");
            return;
        }

        Vehicle newVehicle = getVehicleById();
        if (newVehicle == null) {
            System.out.println("No such Vehicle Found!");
            return;
        }
        newVehicle.charge();
    }

    private static void stopVehicle() {
        if (count == 0) {
            System.out.println("Add Vehicle first!");
            return;
        }

        Vehicle newVehicle = getVehicleById();
        if (newVehicle == null) {
            System.out.println("No Vehicle Found!");
            return;
        }
        newVehicle.stop();
    }

    private static void startVehicle() {
        if (count == 0) {
            System.out.println("Add Vehicle first!");
            return;
        }

        Vehicle newVehicle = getVehicleById();
        if (newVehicle == null) {
            System.out.println("No Vehicle Found!");
            return;
        }
        newVehicle.start();
    }

    private static Vehicle getVehicleById() {
        System.out.print("Enter id:");
        int id = validatePositiveInt();
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getId() == id) {
                return vehicles[i];
            }
        }
        return null;
    }

    private static Vehicle makeVehicle() {

        System.out.print("\nCan it play Horn?(true/false): ");
        boolean canPlayHorn = validateBoolean();

        System.out.print("Can play Music?(true/false):");
        boolean canPlayMusic = validateBoolean();

        System.out.println("1. Non Electrical");
        System.out.println("2. Electrical");
        System.out.print("Choose the type of Vehicle: :");
        int choice = validatePositiveInt();
        while (!(choice == 1 || choice == 2)) {
            System.out.print("Enter valid Choice:");
            choice = validatePositiveInt();
        }
        if (choice == 1) {
            return makeNonElectricVehicle(canPlayMusic, canPlayHorn);
        } else if (choice == 2) {
            return makeElectricVehicle(canPlayMusic, canPlayHorn);
        }
        return null;
    }

    private static Vehicle makeElectricVehicle(boolean canPlayMusic, boolean canPlayHorn) {

        System.out.println("1. Electric Bike");
        System.out.println("2. Electric Car");
        System.out.print("Choose the Vehicle: ");
        int choice = validatePositiveInt();
        while (!(choice == 1 || choice == 2)) {
            System.out.print("Enter valid Choice:");
            choice = validatePositiveInt();
        }
        Vehicle newElectricVehicle = null;

        if (choice == 1) {
            newElectricVehicle = new ElectricBike((count * 10), false, canPlayMusic, canPlayHorn);
        } else if (choice == 2) {
            newElectricVehicle = new ElectricCar((count * 10), false, canPlayMusic, canPlayHorn);
        }

        return newElectricVehicle;

    }

    private static Vehicle makeNonElectricVehicle(boolean canPlayMusic, boolean canPlayHorn) {

        System.out.println("1. Bike");
        System.out.println("2. Car");
        System.out.print("Choose the Vehicle: ");
        int choice = validatePositiveInt();
        while (!(choice == 1 || choice == 2)) {
            System.out.print("Enter valid Choice:");
            choice = validatePositiveInt();
        }
        Vehicle newElectricVehicle = null;

        if (choice == 1) {
            newElectricVehicle = new Bike((count * 10) + 1, false, canPlayMusic, canPlayHorn);
        } else if (choice == 2) {
            newElectricVehicle = new Car((count * 10) + 1, false, canPlayMusic, canPlayHorn);
        }

        return newElectricVehicle;

    }
}
