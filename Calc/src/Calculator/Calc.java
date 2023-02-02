package Calculator;

import java.util.StringTokenizer;

public class Calc {
    public static String calc(String ex) throws TokenizerException, RimArifmeticException, RestrictionException, MuchException {
        if (ex.indexOf("*") < 0 & ex.indexOf("/") < 0 & ex.indexOf("-") < 0 & ex.indexOf('\u002B') < 0) {
            throw new TokenizerException();
        }

        StringTokenizer tokenizer = new StringTokenizer(ex, "*/-\\+");
        String array[] = new String[tokenizer.countTokens()];
        for (int i = 0; i < array.length; i++) {
            array[i] = tokenizer.nextToken();
            if (i > 1) {
                throw new MuchException();
            }
        }
        int first = 0;
        int second = 0;
        String result = null;
        if (array[0].indexOf("I") >= 0 || array[0].indexOf("V") >= 0 || array[0].indexOf("X") >= 0 & array[1].indexOf("I") >= 0 || array[1].indexOf("V") >= 0 || array[1].indexOf("X") >= 0) {
            Rim a = Rim.valueOf(array[0]);
            Rim b = Rim.valueOf(array[1]);

            int inRim = 0;
            first = a.getChislo();
            second = b.getChislo();

            if (first < 1 || first > 10 || second < 1 || second > 10) {
                throw new RestrictionException();
            }
            if (ex.indexOf("*") > 0) {
                inRim = first * second;
            } else if (ex.indexOf('\u002B') > 0) {
                inRim = first + second;
            } else if (ex.indexOf("-") > 0) {
                inRim = first - second;
            } else if (ex.indexOf("/") > 0) {
                inRim = first / second;
            }
            if (inRim < 0) {
                throw new RimArifmeticException();
            }
            Rim c = Rim.Cifra(inRim);
            result = c.name();


        } else {
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new RestrictionException();
            }
            int inInt = 0;
            if (ex.indexOf("*") > 0) {
                inInt = a * b;
            } else if (ex.indexOf('\u002B') > 0) {
                inInt = a + b;
            } else if (ex.indexOf("-") > 0) {
                inInt = a - b;
            } else if (ex.indexOf("/") > 0) {
                inInt = a / b;
            }
            result = Integer.toString(inInt);
        }
        return result;
    }
}
