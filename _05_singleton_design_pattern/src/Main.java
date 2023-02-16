public class Main {
    public static void main(String[] args) {

        Box b1 = Box.getInstance();
        System.out.println(b1);

        Box b2 = Box.getInstance();
        System.out.println(b2);

        if(b1 == b2) {
            System.out.println("Same Object");
        } else {
            System.out.println("Different Object");
        }
    }
}