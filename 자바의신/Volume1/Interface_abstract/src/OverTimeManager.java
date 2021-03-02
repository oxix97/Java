public class OverTimeManager {
    public int getOverTimeAmount(OverTimeValues values) {
        int amount = 0;
        System.out.println(values);

        switch (values) {
            case THREE_HOURS: amount = 18000; break;
            case FIVE_HOURS: amount = 30000; break;
            case WEEKEND_FOUR_HOUR: amount = 40000; break;
            case WEEKEND_EIGHT_HOUR: amount = 60000; break;
        }
        return amount;
    }

    public static void main(String[] args) {
        OverTimeManager manager = new OverTimeManager();
        int myAmount = manager.getOverTimeAmount(OverTimeValues.THREE_HOURS);
        System.out.println(myAmount);
    }
}
