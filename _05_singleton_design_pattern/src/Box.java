public class Box {
    private static Box box;

    private Box()
    {
    //
    }

    public static Box getInstance()
    {
        if(box == null) {
            box = new Box();
        }

        return box;
    }
}
