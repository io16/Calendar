
import java.time.*;

public class Calendar {
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        LocalDate date;

        try {
            date = LocalDate.of(LocalDate.now().getYear(), Integer.parseInt(args[0]), 1);
        } catch (Exception e) {
            date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        }

        System.out.println(date.getYear() + "\t" + date.getMonth());
        System.out.println("Mo Tu Wn Th Fr St Su");

        if (!date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            DayOfWeek day = DayOfWeek.MONDAY;

            while (!date.getDayOfWeek().equals(day)) {
                System.out.print("   ");

                day = day.plus(1);
            }
        }

        for (int day = 1; day < date.lengthOfMonth(); day++) {
            if (date.getDayOfWeek().equals(DayOfWeek.MONDAY) && day != 1) System.out.println();

            if (date.getDayOfMonth() < 10) System.out.print(" ");

            if (!date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                    && !date.equals(LocalDate.now())) {
                System.out.print(ANSI_WHITE + day + " ");

            } else if (date.equals(LocalDate.now())) {
                System.out.print(ANSI_YELLOW + day + " ");

            } else System.out.print(ANSI_RED + day + " ");

            date = date.plusDays(1);
        }
    }
}