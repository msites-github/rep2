package secondpraktika;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main {

    public static void main(String[] args) {






        // объявление переменных
        double a;
        double resultY, resultS, n;
        String finalY, finalS;

        // проверка числа a, если возвращает некорректное число, то просит ввести заново
        // таккже проверки есть в inputDigitA
        while ((a = inputDigitA()) == -100001) {
            System.out.println("Введено неверное число!");
        }

        // нахождение значения y
        System.out.println("Значение промежуточное+ " + a);

        resultY = findY();

        // проверка на то, является ли первое значение суммы равным 0.5/-0.5
        // от этого зависит шаг либо 1, либо 0.5
        n = stepCheck(resultY, a);

        // нахождение значения S
        resultS = findS(n, resultY, a);

        // округление числа для более удобного формата
        DecimalFormat dcForm = new DecimalFormat("#.######");
        finalY = dcForm.format(resultY);
        finalS = dcForm.format(resultS);

        // вывод результатов в консоль
        outputResultsCons(finalY, finalS);

        // вывод результатов в окно
        FormResult app = new FormResult("Lol", finalY, finalS);
        app.setVisible(true);
        app.setSize(300, 75);
    }



    // генерация случайного числа в определенном диапазоне
    public static int rndDigit(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    // вычисление факториала
    public static int calcFact(int n){
        int res = 1;
        for (int i = 1; i <=n; i ++){
            res = res*i;
        }
        return res;
    }

    // ввод числа в переменную a + проверка на вводимое число
    public static double inputDigitA() {
        try {
            double digit;
            Scanner firstDigit = new Scanner(System.in);
            System.out.println("Введите число a: ");
            digit = firstDigit.nextDouble();
// ограничение на размер вводимого числа
            if (digit < -100000 || digit > 100000) {
                System.out.println("Введено слишком большое или маленькое число, Попробуйте снова!");
                return -100001;
            } else {
                System.out.println("Введено корректное число!");
                return digit;
            }
        } catch (InputMismatchException err) {
            System.out.println("Введено некорректное число, Попробуйте снова!");
        }
        return -100001;
    }

    public static double findY() {
        double Yres = 0;
        for (int i = 3; i <= 12; i = i + 3) {
            Yres = Math.log(2*i/3)/Math.log(3) + Math.cos(1+i*i);
        }
        return Yres;
    }

    // проверка на то, является ли первое значение суммы равным 0.5/-0.5, от этого зависит шаг
    public static double stepCheck(double Yres, double a) {
        double Sres = 0;
        double n = 0;
        Sres = (2.3*(Math.pow(Yres, 5/3))*(Math.pow(a, -21)) - 0.2*(Math.abs(Yres)));
        if (Math.abs(Sres) == 0.5) {
            n = 0.5;
            return n;
        } else {
            n = 1;
            return n;
        }
    }

    // поиск итогового значения S
    public static double findS(double n, double resY, double a) {
        double resultS = 0;
        for (double i = -20; i <= 10; i = i + n) {
            resultS = resultS + (2.3*(Math.pow(resY, 5/3))*(Math.pow(a, i - 1)) - 0.2*(Math.abs(resY)));
        }
        return resultS;
    }

    // вывод результатов в консоль
    public static void outputResultsCons(String resY, String resS) {
        System.out.println("Итоговое значение Y: " + resY + "\n" +
                "Итоговое значение S: " + resS);
    }

}