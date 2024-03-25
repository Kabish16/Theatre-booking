import javax.xml.transform.Source;
import java.io.*;
import java.util.*;


public class Theatre {
    private static String[] rowOne = new String[12];
    public static String[] seatOne = new String[12];
    private static String[] rowTwo = new String[16];
    private static String[] seatTwo = new String[16];
    private static String[] rowThree = new String[20];
    private static String[] seatThree = new String[20];

    //private static ArrayList tickets = new ArrayList();
    protected static ArrayList<Ticket> ticketList = new ArrayList<>();
    private static int price;
    private static int totalPrice;




    private static String option;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the New Theatre");

        for(int i = 0; i<rowOne.length; i++){
            seatOne[i] = String.valueOf(i+1);
            rowOne[i] = "0";
        }

        for(int i = 0; i<rowTwo.length; i++){
            seatTwo[i] = String.valueOf(i+1);
            rowTwo[i] = "0";
        }

        for(int i = 0; i<rowThree.length; i++){
            seatThree[i] = String.valueOf(i+1);
            rowThree[i] = "0";
        }

        menu();
    }

    public static void menu() throws IOException {
        System.out.println("Enter 1 to Buy a Ticket: ");
        System.out.println("Enter 2 to Print Seating Area: ");
        System.out.println("Enter 3 to Cancel a ticket: ");
        System.out.println("Enter 4 to List Available Seats: ");
        System.out.println("Enter 5 to save to a file: ");
        System.out.println("Enter 6 to load from a file: ");
        System.out.println("Enter 7 to Print ticket information and total price: ");
        System.out.println("Enter 8 to sort tickets by price: ");
        System.out.println("Enter 0 to quit program: ");

        System.out.println(" ");
        System.out.print("Choose an option: ");

        option = input.next();
        switch ((option)){
            case "1":
                buyTicket();
                break;
            case "2":
                print_seating_area();
                break;
            case "3":
                cancel_ticket();
            case "4":
                show_available();
            case "5":
                save();
            case "6":
                load();
            case "7":
                show_tickets_info();
            case "8":
                sort_tickets();
        }
    }

    public static void buyTicket() throws IOException {
        System.out.println("Seats are shown below....:)");
        System.out.println("If the seats are labelled '0' it is free, if it is '1' it is not free.... ");

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Seats for Row One");
        System.out.println("Seats Number: " + Arrays.toString(seatOne));
        System.out.println("Availability.." + Arrays.toString(rowOne));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");



        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Seats for Row Two");
        System.out.println("Seats Number: " + Arrays.toString(seatTwo));
        System.out.println("Availability.." + Arrays.toString(rowTwo));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");


        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Seats for Row Three");
        System.out.println("Seats Number: " + Arrays.toString(seatThree));
        System.out.println("Availability.." + Arrays.toString(rowThree));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");





        System.out.println("Enter 1 to choose from row one: ");
        System.out.println("Enter 2 to choose from row two: ");
        System.out.println("Enter 3 to choose from row three: ");
        System.out.println(" ");

        System.out.print("Choose the Row you want: ");

        String chooseRow = input.next();
        System.out.print("Choose the seat number: ");
        int seatNumber = 0;

        if(chooseRow.equalsIgnoreCase("1")){
            seatNumber = input.nextInt()-1;
            for(int i = 0; i<rowOne.length; i++){
                if(rowOne[seatNumber].equalsIgnoreCase("0")){
                    seatNumber = seatNumber + 1;
                    System.out.println("You have chosen Seat Number: " + seatNumber + " from Row: " + chooseRow);
                    rowOne[seatNumber - 1] = "1";
                    price = 30;
                    totalPrice = totalPrice + 30;
                    break;
                }
                else if(rowOne[seatNumber].equalsIgnoreCase("1")){
                    System.out.println("Sorry.. This seat is already booked by someone else.. :((");
                    System.out.println("Please choose another seat.. Thank You..");
                    break;
                }

            }
        }
        else if(chooseRow.equalsIgnoreCase("2")){
            seatNumber = input.nextInt()-1;
            for(int i = 0; i<rowTwo.length; i++){
                if(rowTwo[seatNumber].equalsIgnoreCase("0")){
                    seatNumber = seatNumber + 1;
                    System.out.println("You have chosen Seat Number: " + seatNumber +" from Row: " + chooseRow);
                    rowTwo[seatNumber - 1] = "1";
                    price = 20;
                    totalPrice = totalPrice + 20;
                    break;
                }
                else if(rowTwo[seatNumber].equalsIgnoreCase("1")){
                    System.out.println("Sorry.. This seat is already booked by someone else.. :((");
                    System.out.println("Please choose another seat.. Thank You..");
                    break;
                }

            }
        }
        else if(chooseRow.equalsIgnoreCase("3")){
            seatNumber = input.nextInt()-1;
            for(int i = 0; i<rowThree.length; i++){
                if(rowThree[seatNumber].equalsIgnoreCase("0")){
                    seatNumber = seatNumber + 1;
                    System.out.println("You have chosen Seat Number: " + seatNumber + " from Row: " + chooseRow);
                    rowThree[seatNumber - 1] = "1";
                    price = 10;
                    totalPrice = totalPrice + 10;
                    break;
                }
                else if(rowThree[seatNumber].equalsIgnoreCase("1")){
                    System.out.println("Sorry.. This seat is already booked by someone else.. :((");
                    System.out.println("Please choose another seat.. Thank You..");
                    break;
                }

            }
        }
        //task 2 implementation of adding the details to the ticket list..
        System.out.println(" ");
        System.out.println("Please enter your personal details to confirm the booking..");
        System.out.print("Enter your First Name please: ");
        String name = input.next();
        System.out.print("Enter your surname please: ");
        String surName = input.next();
        System.out.print("Enter your mail please: ");
        String mail = input.next();
        String displayPrice = Integer.toString(price);
        String displayTotalPrice = Integer.toString(totalPrice);
        Ticket ticketDetails = new Ticket("Mr/Mrs: " + name,surName,"Mail ID: " + mail,"Row Number: " + chooseRow,"Seat Number: " + seatNumber,"$ :" + displayPrice, "Total $: " + displayTotalPrice);
        ticketList.add(ticketDetails);
        System.out.println("Booking Successful Completed.. :))");
        //---------------------------------------------------------------------------------------------------------
        System.out.println(" ");
        System.out.println(" ");
        menu();
    }

    public static void print_seating_area() throws IOException {
        String[] printRowOne = new String[12];
        String[] printRowTwo = new String[16];
        String[] printRowThree = new String[20];
        String joinedRowOne = " ";
        String joinedRowTwo = " ";
        String joinedRowThree = " ";
        for(int i = 0; i<rowOne.length; i++){
            if(rowOne[i].equalsIgnoreCase("0")){
                printRowOne[i] = "O";
                joinedRowOne = joinedRowOne + printRowOne[i];
            }
            else if(rowOne[i].equalsIgnoreCase("1")){
                printRowOne[i] = "X";
                joinedRowOne = joinedRowOne + printRowOne[i];
            }
        }
        System.out.println("Row One...");
        System.out.println("Availability.." + joinedRowOne);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");



        for(int i = 0; i<rowTwo.length; i++){
            if(rowTwo[i].equalsIgnoreCase("0")){
                printRowTwo[i] = "O";
                joinedRowTwo = joinedRowTwo + printRowTwo[i];
            }
            else if(rowTwo[i].equalsIgnoreCase("1")){
                printRowTwo[i] = "X";
                joinedRowTwo = joinedRowTwo + printRowTwo[i];
            }
        }
        System.out.println("Row Two");
        System.out.println("Availability.." + joinedRowTwo);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");


        for(int i = 0; i<rowThree.length; i++){
            if(rowThree[i].equalsIgnoreCase("0")){
                printRowThree[i] = "O";
                joinedRowThree = joinedRowThree + printRowThree[i];
            }
            else if(rowThree[i].equalsIgnoreCase("1")){
                printRowThree[i] = "X";
                joinedRowThree = joinedRowThree + printRowThree[i];
            }
        }
        System.out.println("Row Three");
        System.out.println("Availability.." + joinedRowThree);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");

        //------------------------------------------------------------------------------------------------------------//
        //printing availability in design form...
        System.out.println("         ***********     ");
        System.out.println("        *   STAGE   *");
        System.out.println("         ***********     ");
        String one = joinedRowOne.substring(0, 7);
        String two = joinedRowOne.substring(7,13);
        System.out.println("        " + one + " " + two + "     ");
        System.out.println(" ");
        String three = joinedRowTwo.substring(0,9);
        String four = joinedRowTwo.substring(9,17);
        System.out.println("      " + three + " " + four + "     ");
        System.out.println(" ");
        String five = joinedRowThree.substring(0,11);
        String six = joinedRowThree.substring(11,21);
        System.out.println("    " + five + " " + six + "     ");
        System.out.println(" ");


        menu();
    }

    public static void cancel_ticket() throws IOException {
        System.out.println("Seats are shown below to cancel: ....:)");
        System.out.println("If the seats are labelled '0' it is free, if it is '1' it is not free.... ");

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Seats for Row One");
        System.out.println("Seats Number: " + Arrays.toString(seatOne));
        System.out.println("Availability.." + Arrays.toString(rowOne));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");



        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Seats for Row Two");
        System.out.println("Seats Number: " + Arrays.toString(seatTwo));
        System.out.println("Availability.." + Arrays.toString(rowTwo));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");


        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Seats for Row Three");
        System.out.println("Seats Number: " + Arrays.toString(seatThree));
        System.out.println("Availability.." + Arrays.toString(rowThree));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");


        System.out.println("Enter 1 to choose from row one to cancel: : ");
        System.out.println("Enter 2 to choose from row two to cancel: : ");
        System.out.println("Enter 3 to choose from row three to cancel: : ");
        System.out.println(" ");

        System.out.print("Choose the Row you want to cancel: ");

        String chooseRow = input.next();
        System.out.print("Choose the seat number you want to cancel: ");
        int seatNumber = 0;

        if(chooseRow.equalsIgnoreCase("1")){
            seatNumber = input.nextInt()-1;
            for(int i = 0; i<rowOne.length; i++){
                if(rowOne[seatNumber].equalsIgnoreCase("1")){
                    seatNumber = seatNumber + 1;
                    System.out.println("Seat Number: " + seatNumber + " from Row: " + chooseRow + " has been cancelled..");
                    rowOne[seatNumber - 1] = "0";
                    totalPrice = totalPrice - 30;
                    for(Ticket ticket : ticketList){
                        if(ticket.getRow().contains(chooseRow)){
                            if(ticket.getSeat().contains(Integer.toString(seatNumber))) {
                                ticketList.remove(ticket);
                                System.out.println(" ");
                                System.out.println(ticket.getName() + " 's ticket was cancelled successfully.. :))");
                                System.out.println(" ");
                                System.out.println(" ");
                                menu();
                            }
                        }
                        else{
                            System.out.println(" ");
                            System.out.println(" ");
                            menu();
                        }
                    }
                    break;
                }
                else if(rowOne[seatNumber].equalsIgnoreCase("0")){
                    System.out.println("Sorry.. Cancellation unsuccessful..:((");
                    System.out.println("This seat is not occupied to cancel..");
                    break;
                }
                else{
                    System.out.println("You have entered an invalid input, please try again later..:((");
                }

            }
        }
        else if(chooseRow.equalsIgnoreCase("2")){
            seatNumber = input.nextInt()-1;
            for(int i = 0; i<rowTwo.length; i++){
                if(rowTwo[seatNumber].equalsIgnoreCase("1")){
                    seatNumber = seatNumber + 1;
                    System.out.println("Seat Number: " + seatNumber + " from Row: " + chooseRow + " has been cancelled..");
                    totalPrice = totalPrice - 20;
                    rowTwo[seatNumber - 1] = "0";
                    for(Ticket ticket : ticketList){
                        if(ticket.getRow().contains(chooseRow)){
                            if(ticket.getSeat().contains(Integer.toString(seatNumber))) {
                                ticketList.remove(ticket);
                                System.out.println(" ");
                                System.out.println(ticket.getName() + " 's ticket was cancelled successfully.. :))");
                                System.out.println(" ");
                                System.out.println(" ");
                                menu();
                            }
                        }
                        else{
                            System.out.println(" ");
                            System.out.println(" ");
                            menu();
                        }
                    }
                    break;
                }
                else if(rowTwo[seatNumber].equalsIgnoreCase("0")){
                    System.out.println("Sorry.. Cancellation unsuccessful..:((");
                    System.out.println("This seat is not occupied to cancel..");
                    break;
                }
                else{
                    System.out.println("You have entered an invalid input, please try again later..:((");
                }

            }
        }
        else if(chooseRow.equalsIgnoreCase("3")){
            seatNumber = input.nextInt()-1;
            for(int i = 0; i< rowThree.length; i++){
                if(rowThree[seatNumber].equalsIgnoreCase("1")){
                    seatNumber = seatNumber + 1;
                    System.out.println("Seat Number: " + seatNumber + " from Row: " + chooseRow + " has been cancelled..");
                    rowThree[seatNumber - 1] = "0";
                    totalPrice = totalPrice - 10;
                    for(Ticket ticket : ticketList){
                        if(ticket.getRow().contains(chooseRow)){
                            if(ticket.getSeat().contains(Integer.toString(seatNumber))) {
                                ticketList.remove(ticket);
                                System.out.println(" ");
                                System.out.println(ticket.getName() + " 's ticket was cancelled successfully.. :))");
                                System.out.println(" ");
                                System.out.println(" ");
                                menu();
                            }
                        }
                        else{
                            System.out.println(" ");
                            System.out.println(" ");
                            menu();
                        }
                    }
                    break;
                }
                else if(rowThree[seatNumber].equalsIgnoreCase("0")){
                    System.out.println("Sorry.. Cancellation unsuccessful..:((");
                    System.out.println("This seat is not occupied to cancel..");
                    break;
                }
                else{
                    System.out.println("You have entered an invalid input, please try again later..:((");
                }

            }
        }

    }

    public static void show_available() throws IOException {
        System.out.println(" ");
        System.out.println("Seats available in row 1: ");
        for(int i = 0; i<rowOne.length; i++){
            if(rowOne[i].equalsIgnoreCase("0")){
                System.out.print(seatOne[i] + ",");
            }
        }
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println("Seats available in row 2: ");
        for(int i = 0; i<rowTwo.length; i++){
            if(rowTwo[i].equalsIgnoreCase("0")){
                System.out.print(seatTwo[i] + ",");
            }
        }
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println("Seats available in row 3: ");
        for(int i = 0; i<rowThree.length; i++){
            if(rowThree[i].equalsIgnoreCase("0")){
                System.out.print(seatThree[i] + ",");
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        menu();
    }

    public static void save() throws IOException {
        System.out.println("Successfully stored to a text file");
        FileWriter fWriter = new FileWriter("Theatre_details.txt", true);//create a new text file
        try{
            fWriter.write("0 means 'Not Booked' & 1 means 'Booked' " + "\n");
            fWriter.write("Seats available in row 1: " + "\n");
            for(int i = 0; i < rowOne.length; i++){//goes through the array list which contains the details
                fWriter.write(rowOne[i] + ","); //writes them into the file
            }
            fWriter.write("\n");
            fWriter.write("Seats available in row 2: " + "\n");
            for(int i = 0; i < rowTwo.length; i++){//goes through the array list which contains the details
                fWriter.write(rowTwo[i] + ","); //writes them into the file
            }
            fWriter.write("\n");
            fWriter.write("Seats available in row 2: " + "\n");
            for(int i = 0; i < rowThree.length; i++){//goes through the array list which contains the details
                fWriter.write(rowThree[i] + ","); //writes them into the file
            }
            fWriter.write("\n");
            fWriter.write("\n");
            fWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        menu();
    }

    public static void load() throws IOException {
        int linecount = 1;
        try
        {
            File inputFile = new File("Theatre_details.txt");
            Scanner rf = new Scanner(inputFile);
            String fileLine;
            while(rf.hasNext())
            {
                fileLine = rf.nextLine();
                System.out.println(fileLine);
                linecount++;
            }
            rf.close();
        } catch (IOException e) {
            System.out.println("Error Occurred is: " + e);
        }


        System.out.println("Theatre List loaded Successfully");
        System.out.println(" ");
        System.out.println(" ");
        menu();
    }

    public static void show_tickets_info() throws IOException {
        for (Ticket ticket : ticketList) {//traversing through the list
            System.out.println(ticket.getName() + "\t" + //printing the list
                    ticket.getsurName() + "\t" +
                    ticket.getMail() + "\t" +
                    ticket.getRow() + "\t" +
                    ticket.getSeat() + "\t" +
                    ticket.getPrice() + "\t" +
                    ticket.getTotalPrice());
        }
        menu();
    }

    public static void sort_tickets() throws IOException {
        Collections.sort(ticketList, new Comparator<Ticket>() {
            public int compare(Ticket t1, Ticket t2) {
                return t1.getPrice().compareTo(t2.getPrice());
            }});
        System.out.println("Successfully Sorted... Printing the sorted List");
        for (Ticket ticket : ticketList) {//traversing through the list
            System.out.println(ticket.getName() + "\t" + //printing the list
                    ticket.getsurName() + "\t" +
                    ticket.getMail() + "\t" +
                    ticket.getRow() + "\t" +
                    ticket.getSeat() + "\t" +
                    ticket.getPrice() + "\t" +
                    ticket.getTotalPrice());
        }
        menu();
    }


}
