package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {

    public void largestNumber() {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        double input;
        double largestNr = 0;

        while (scan.hasNext()) {
            System.out.printf("Number %d: ", ++counter);
            input = scan.nextDouble();

            if (input > largestNr) {
                largestNr = input;
            }

            if (input < 0) {
                if (counter == 1) {
                    System.out.println("No number entered.");
                    break;
                }
                System.out.printf("The largest number is %.2f%n", largestNr);
                break;
            }
        }
        scan.close();
    }

    public void stairs() {
        Scanner scan = new Scanner(System.in);
        int counter = 1;
        System.out.print("n: ");
        int input = scan.nextInt();

        if (input < 0) {
            System.out.println("Invalid number!");
        } else {
            for (int i = 1; i < input + 1; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(counter++ + " ");
                }
                System.out.println();
            }
        }
        scan.close();
    }

    public void printPyramid() {
        int rows = 6;

        for (int i = 1; i <= rows; i++) {
            //for loop for drawing blanks, always 1 less than the number of rows
            for (int blanks = rows - i ; blanks > 0; blanks--) {
                System.out.print(" ");
            }
            //for loop for drawing stars
            for (int stars = 1; stars < i * 2 ; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printRhombus() {
        Scanner scan = new Scanner(System.in);
        System.out.print("h: ");
        int height = scan.nextInt();

        System.out.print("c: ");
        char mainChar = scan.next().charAt(0);

        if (height % 2 == 0) {
            System.out.println("Invalid number!");
            return;
        }

        //draw upper half
        for (int i = 0; i < height / 2 + 1; i++) {
            for (int blanks = height / 2 - i; blanks > 0; blanks--) {
                System.out.print(" ");
            }
            for (int ch = mainChar - i; ch <= mainChar; ch++) {
                System.out.print((char) ch);
            }
            for (int ch = mainChar - 1; ch > mainChar - i - 1; ch--) {
                System.out.print((char) ch);
            }
            System.out.println();
        }

        //draw bottom half
        for (int i = height / 2; i > 0; i--) {
            for (int blanks = 0; blanks < height / 2 - i + 1; blanks++) {
                System.out.print(" ");
            }
            for (int ch = mainChar - i + 1; ch <= mainChar; ch++) {
                System.out.print((char) ch);
            }
            for (int ch = mainChar - 1; ch > mainChar - i; ch--) {
                System.out.print((char) ch);
            }
            System.out.println();
        }
        scan.close();
    }

    public void marks() {
        Scanner scan = new Scanner(System.in);
        int mark;
        int negativeMarks = 0;
        int counter = 1;
        float sum = 0f;

        while (true) {
            System.out.printf("Mark %d: ", counter);
            mark = scan.nextInt();

            if (mark == 0) {
                //counter starts from 1, therefore we need to
                //reduce the counter by 1 when we end the loop after several marks
                if (counter != 1) counter--;
                break;
            }

            if (mark < 0 || mark > 5) {
                System.out.println("Invalid mark!");
                continue;
            }
            if (mark == 5) {
                negativeMarks++;
            }

            sum += mark;
            counter++;
        }

        float average = sum / counter;

        System.out.printf("Average: %.2f", average);
        System.out.println();
        System.out.printf("Negative marks: %d", negativeMarks);
        System.out.println();

        scan.close();
    }

    public void happyNumbers() {
        Scanner scan = new Scanner(System.in);
        System.out.print("n: ");
        int input = scan.nextInt();
        int sum = 0;
        int temp = input;
        boolean isHappy = false;

        while (sum != 4) {
            //reset the sum to 0 in every new loop
            sum = 0;

            //calculate the sum of the squares of the temp input's digits
            while (temp > 0) {
                int lsd = temp % 10;
                temp = temp / 10;
                sum += lsd * lsd;
            }

            //set the temp input to the current sum
            temp = sum;

            if (sum == 1) {
                isHappy = true;
                break;
            }
        }

        if (isHappy) System.out.println("Happy number!");
        else System.out.println("Sad number!");

        scan.close();
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}