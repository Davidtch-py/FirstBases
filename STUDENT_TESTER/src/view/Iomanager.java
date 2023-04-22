package view;

import java.util.Scanner;

public class Iomanager {
    private Scanner scanner = new Scanner(System.in);
    public int count;  
    public void showMessage(String message) {
        System.out.println(message);

    }
    public String readString(String message) {
        this.showMessage(message);
        return scanner.nextLine();
    }

    public int readInt(String message) {
        this.showMessage(message);
        return scanner.nextInt();
    }

    public double readDouble(String message) {
        this.showMessage(message);
        return scanner.nextDouble();
    }

    public float readFloat(String message) {
        this.showMessage(message);
        return scanner.nextFloat();
    }

    public byte readByte(String message) {
        this.showMessage(message);
        return scanner.nextByte();
    }

    public short readShort(String message) {
        this.showMessage(message);
        return scanner.nextShort();
    }
    public char readChar(String message) {
        this.showMessage(message);
        return scanner.next().charAt(0);
    }
}
