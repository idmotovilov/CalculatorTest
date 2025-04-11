package Calc;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;


@Getter
@Setter
class ConsoleReader {
    private Scanner scanner = new Scanner(System.in);
    String readLine() {
        return scanner.nextLine();
    }
}