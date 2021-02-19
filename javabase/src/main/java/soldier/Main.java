package soldier;


import java.util.Objects;
import java.util.Scanner;

/**
 * @author ezreal
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        long min = 0;
        String[] split = a.split(",");

        if (split.length == 0 || split.length == 1) {
            min = a.length() == 0 ? 0 : 1;
            System.out.println(min);
        }
        int[] ripple = new int[split.length];
        for (int i = 0; i < split.length - 1; i++) {
            int compare = compare(split[i + 1], split[i]);
            ripple[i] = compare;
        }
        Long n = 2L;
        Long k = n;
        boolean flag = false;
//        print(ripple);
        for (int i = 0; i < ripple.length - 2; i++) {
            if (ripple[i + 1] == ripple[i]) {
                if (flag) {
                    k = n;
                    flag = false;
                }
                k++;
            } else {
                n = 1L;
                flag = true;
            }
            if (i == ripple.length - 3) {
                flag = true;
            }
            if (ripple[i] != 0 && flag) {
                min = add(k) + min;
            }else if (flag){
                min = add(k) + min;
            }
        }
        if (ripple[ripple.length - 2] == 1 && ripple[ripple.length - 2] != ripple[ripple.length - 3]) {
            min = min + 2;
        } else if (ripple[ripple.length - 2] == -1 && ripple[ripple.length - 2] != ripple[ripple.length - 3]) {
            min = min + 1;
        }
        System.out.println(min);
    }

    public static int compare(String a, String b) {
        return Objects.compare(Long.parseLong(a), Long.parseLong(b), Long::compareTo);
    }

    public static Long add(Long n) {
        return (1 + n) * n / 2;
    }


    public static void print(int[] ripple) {
        for (int i = 0; i < ripple.length - 1; i++) {
            System.out.print(ripple[i] + " ");
        }
    }
}