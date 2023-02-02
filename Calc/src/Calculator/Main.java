package Calculator;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner example = new Scanner(System.in);
        System.out.println("Введите пример");
        String ex = example.nextLine();
        try {
            System.out.println(Calc.calc(ex));
        }catch (TokenizerException t) {
            System.out.println("Введено неверное действие");
        } catch (RimArifmeticException r) {
            System.out.println("В римской системе счислния нет отрицательных чисел");
        } catch (IllegalArgumentException er) {
            System.out.println("Используются разные системы счисления");
        }catch (RestrictionException re){
            System.out.println("Числа должны лежать в диапазоне от 1 до 10");
        }catch (MuchException m){
            System.out.println("Вы ввели более двух операндов");
        }
    }
}
