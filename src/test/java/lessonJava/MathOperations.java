package lessonJava;

public class MathOperations {

    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        double c = 4.1;
        float d;

//        применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int
        System.out.println("Сумма чисел a+b равно " + (a+b));
        System.out.println("Разность чисел a-b равно " + (a-b));
        System.out.println("Произведение чисел a*b равно " + (a*b));
        System.out.println("Частное чисел a/b равно " + (a/b));
        System.out.println();

//        применить несколько арифметических операций над int и double в одном выражении
        System.out.println("Сумма чисел a+с равно " + (a+c));
        System.out.println("Разность чисел a-c равно " + (a-c));
        System.out.println("Произведение чисел b*c равно " + (b*c));
        System.out.println("Частное чисел b/c равно " + (b/c));
        System.out.println();

//        применить несколько логических операций ( < , >, >=, <= )
        System.out.println("A>B " + (a>b));
        System.out.println("A<B " + (a<b));
        System.out.println("A>=C " + (a>=c));
        System.out.println("B<=C " + (b<=c));
        System.out.println();

//        прочитать про диапазоны типов данных для вещественных / чисел с плавающей точкой (какие максимальные и минимальные значения есть, как их получить)
//        и переполнение
        System.out.println("Максимальное значение float: " + Float.MAX_VALUE);  //3.4028235E38
        System.out.println("Минимальное положительное значение float: " + Float.MIN_VALUE);  //1.4E-45
        System.out.println("Максимальное значение double: " + Double.MAX_VALUE);  //1.7976931348623157E308
        System.out.println("Минимальное положительное значение double: " + Double.MIN_VALUE);  //4.9E-324
        System.out.println();

        d = Float.MAX_VALUE * 2;

//        получить переполнение при арифметической операции
        System.out.println("Выход за пределы диапазона int в большую сторону " + (Integer.MAX_VALUE + 1));
        System.out.println("Выход за пределы диапазона int в меньшую сторону " + (Integer.MAX_VALUE - 1));
    }
}