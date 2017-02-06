package experiment;

/**
 * Created on 02.02.2017.
 */
public class CodePoint {
    public static void main(String[] args) {
        int[] arr = {0x11280, 0x1000, 0x1F770};
        String str1 = new String(arr, 0, arr.length);
        for (int i : arr) {
            System.out.println(i);
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println();

        System.out.println("Byte[] size " + str1.getBytes().length);
        for (byte i : str1.getBytes()) {
            System.out.println(i);
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println();

        System.out.println("char[] size " + str1.toCharArray().length);
        for (char i : str1.toCharArray()) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("String size " + str1.length());
        System.out.println(str1);
        System.out.println();

        System.out.println("0 " + str1.codePointAt(0));
        System.out.println("1 " + str1.codePointAt(1));
        System.out.println("2 " + str1.codePointAt(2));
        System.out.println("3 " + str1.codePointAt(3));
        System.out.println("4 " + str1.codePointAt(4));
        System.out.println("0,5 " + str1.codePointCount(0,5));
        System.out.println("" + Character.isHighSurrogate(str1.toCharArray()[0]));
        System.out.println("" + Character.isLowSurrogate(str1.toCharArray()[1]));
        System.out.println();

        System.out.println("0 " + (int)str1.toCharArray()[0]);
        System.out.println("1 " + (int)str1.toCharArray()[1]);
        System.out.println("2 " + (int)str1.toCharArray()[2]);
        System.out.println("3 " + (int)str1.toCharArray()[3]);


    }
}
