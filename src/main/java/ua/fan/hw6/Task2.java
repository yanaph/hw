package ua.fan.hw6;

public class Task2 {
    public static void main(String[] args) {
        int[][] triangle = new int[5][];
        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) { //ошибка была здесь
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/* вылетает Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
	at ua.fan.hw6.Task2.main(Task2.java:22)
    поставив отладчик на строку 22, мы проходимся поэтапно по вложенному циклу for и замечаем, что это происходит при i=0 j=1
	Это случается из-за того, что мы пытаемся получить значение элемента triangle[0][1], которого не существует,
	так как triangle[0].length = 1
	Чтоб это исправить, нам нужно сравнивать не i с triangle[i].length, а переменную j
	*/