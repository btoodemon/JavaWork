public class MethodTest01 {
    public static void main(String[] args) {
        test1();
        test2();
        String mm2 = "test3 ";
        test3(mm2);

        String nassvm = test4("test4");
        System.out.println(nassvm);


    }

    private static int test1() {
        return 0;
    }

    private static void test2() {
    }

    /**
     *
     * @param mm
     */
    public static void test3(String mm) {
        System.out.println(mm);
    }

    /**
     * @param s
     * @return
     */
    private static String test4(String s) {
        s = s + "22";
        return s;
    }
}
