package com.projectChess;

import java.util.Scanner;

public class InputCoordinates {
    private static Scanner scanner = new Scanner(System.in);

    public static Coordinates input(){
        while (true){
            System.out.println("Please enter coordinates (ex. a1)");
            String line = scanner.nextLine();

            if(line.length() != 2){
                System.out.println("Invalid format");
                continue;
            }

            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if(!Character.isLetter(fileChar)){
                System.out.println("Invalid format");
                continue;
            }

            if(!Character.isDigit(rankChar)){
                System.out.println("Invalid format");
                continue;
            }

            int rank = Character.getNumericValue(rankChar);
            if(rank < 1 || rank > 8){
                System.out.println("Invalid format");
                continue;
            }

            File file = File.fromChar(fileChar);
            if (file == null){
                System.out.println("Invalid format");
                continue;
            }

            return new Coordinates(file, rank);
        }


    }        public static void main(String[] args){
        Coordinates coordinates = input();

        System.out.println("coordinates = " + coordinates);
    }
}
