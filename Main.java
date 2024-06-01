import java.util.Scanner;

class Nikita
{
   static String [] rimAll = {
            "N","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };
    public static String checkZnak (String _input)
    {
        if(_input.contains("+")) return "+";
        else if(_input.contains("-")) return "-";
        else if (_input.contains("*")) return "*";
        else if (_input.contains("/")) return "/";
        else return null;

    }
     static int calc (int x,int y, String _znak)
     {
         if (_znak.equals("+")) return x + y;
         else if (_znak.equals("-")) return x - y;
         else if (_znak.equals("*")) return x * y;
         else if (_znak.equals("/")) return x / y;
         else return 0;
     }
     public static boolean RimOrArab(String value)
     {
         for (int i = 0; i<rimAll.length; i++)
         {
             if (value.equals(rimAll[i])) return true;
         }
         return false;
     }
     public static int ConvertArab (String rim)
     {
         for (int i = 0;i<rimAll.length;i++)
         {
             if (rim.equals(rimAll[i])) return i;

         }
          return -1312;
     }
     public static String ConvertRim (int x)
     {
         return rimAll[x];
     }



    public static void main(String [] args) throws Exception {

        while (true) {
             int num1;
             int num2;
             String result;
               boolean Rim;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите выражение");
            String input = scanner.nextLine();

            String numbers [] = input.split("[+\\-*/]");
            if (numbers.length!=2) throw new Exception("Неверное выражение");
            String znak = checkZnak(input);
            if (RimOrArab(numbers[0])&&RimOrArab(numbers[1]))
            {
                num1 = ConvertArab(numbers[0]);
                num2 = ConvertArab(numbers[1]);
                Rim = true;
            }
            else if (!RimOrArab(numbers[0])&&!RimOrArab(numbers[1]))
            {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);
                Rim = false;
            }
            else throw new Exception("Error");

            // теперь проверочки
             if (num1>10 || num2>10) throw new Exception("Числа должны быть не больше десяти.");
             int predict = calc(num1,num2,znak);
             if (Rim)
             {
                 result = ConvertRim(predict);
                 System.out.println(result);
             }
             else
             {
                 System.out.println(predict);
             }
        }


    }
}
