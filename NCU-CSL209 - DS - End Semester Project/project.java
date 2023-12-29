/*

Project 8: 
Build a calendar app that saves appointments and reminders for things like birthdays, to do lists.
DoD:
1. Find the day
2. Print calendar of a month.
3. Add reminders or notes
4. Use array for calendar days and then make a linked list of tasks for corresponding days.

*/

// importing required libraries
import java.util.*;
import java.io.*;

class calender {

    static class date {
        int day;
        int month;
        int year;
        LinkedList<toDo> toDo;
        LinkedList<birthday> birthdays;
        LinkedList<reminder> reminders;

        date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.toDo = new LinkedList<toDo>();
            this.birthdays = new LinkedList<birthday>();
            this.reminders = new LinkedList<reminder>();
        }

        int getYear() {
            return this.year;
        }

        int getMonth() {
            return this.month;
        }

        int getDay() {
            return this.day;
        }
    }

    static class month {
        int month;
        int year;
        date[] dates;

        month(int month, int year) {
            this.month = month;
            this.year = year;
            this.dates = new date[31];
            for (int i = 0; i < 31; i++) {
                this.dates[i] = new date(i + 1, month, year);
            }
        }

        int getYear() {
            return this.year;
        }

        int getMonth() {
            return this.month;
        }

        date getDate(int day) {
            return this.dates[day - 1];
        }

    }

    static class year {
        int year;
        month[] months;

        year(int year) {
            this.year = year;
            this.months = new month[12];
            for (int i = 0; i < 12; i++) {
                this.months[i] = new month(i + 1, year);
            }
        }

        month getMonth(int month) {
            return this.months[month - 1];
        }

        date getDate(int day, int month) {
            return this.months[month - 1].dates[day - 1];
        }

    }

    static class birthday {
        int year;
        int month;
        int date;
        String name;

        birthday(int year, int month, int date, String name) {
            this.year = year;
            this.month = month;
            this.date = date;
            this.name = name;
        }

        int getYear() {
            return this.year;
        }

        int getMonth() {
            return this.month;
        }

        int getDate() {
            return this.date;
        }
    }

    static class toDo {
        int year;
        int month;
        int date;
        String toDo;

        toDo(int year, int month, int date, String toDo) {
            this.year = year;
            this.month = month;
            this.date = date;
            this.toDo = toDo;
        }

        int getYear() {
            return this.year;
        }

        int getMonth() {
            return this.month;
        }

        int getDate() {
            return this.date;
        }

        String getToDo() {
            return this.toDo;
        }
    }

    static class reminder {
        int year;
        int month;
        int date;
        String reminder;

        reminder(int year, int month, int date, String reminder) {
            this.year = year;
            this.month = month;
            this.date = date;
            this.reminder = reminder;
        }

        int getYear() {
            return this.year;
        }

        int getMonth() {
            return this.month;
        }

        int getDate() {
            return this.date;
        }

        String getReminder() {
            return this.reminder;
        }
    }

    static String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October",
            "November", "December" };
    static int[] numberOfDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static year[] years;

    calender() {
        years = new year[100];
        for (int i = 0; i < 100; i++) {
            years[i] = new year(i + 2000);
        }
    }

    static void writeYearsDataToFile() {
        try {
            FileOutputStream file = new FileOutputStream("yearsData.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            for (int i = 0; i < 100; i++) {
                out.writeObject(years[i]);
            }
            out.close();
            file.close();
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }
    }

    static void readYearsDataFromFile() {
        try {
            FileInputStream file = new FileInputStream("yearsData.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            for (int i = 0; i < 100; i++) {
                years[i] = (year) in.readObject();
            }
            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    void addBirthday(String name, int year, int month, int day) {
        years[year - 2000].months[month - 1].dates[day - 1].birthdays.add(new birthday(year, month, day, name));
        System.out.println("\nBirthday added successfully!\n");
    }

    void printBirthdays(int year, int month, int day) {
        LinkedList<birthday> birthdays = years[year - 2000].months[month - 1].dates[day - 1].birthdays;
        for (birthday b : birthdays) {
            System.out.println(b.name + " " + b.date + " " + months[b.month - 1] + " " + b.year);
        }
    }

    int countBirthdays(int year, int month, int day) {
        LinkedList<birthday> birthdays = years[year - 2000 - 1].months[month - 1].dates[day - 1].birthdays;
        return birthdays.size();
    }

    void printBirthdaysInAMonth(int year, int month) {
        for (int i = 0; i < numberOfDays[month - 1]; i++) {
            LinkedList<birthday> birthdays = years[year - 2000].months[month - 1].dates[i].birthdays;
            System.out.println("Birthdays on " + (i + 1) + " " + months[month - 1] + " " + year);
            for (birthday b : birthdays) {
                System.out.println(b.name + " " + b.date + " " + months[b.month - 1] + " " + b.year);
            }
            System.out.println();
        }
    }

    void addReminder(int year, int month, int day, String reminder) {
        years[year - 2000 - 1].months[month - 1].dates[day - 1].reminders.add(new reminder(year, month, day, reminder));
        System.out.println("\nReminder added successfully!\n");
    }

    void printReminders(int year, int month, int day) {
        LinkedList<reminder> reminders = years[year - 2000 - 1].months[month - 1].dates[day - 1].reminders;
        if (reminders.size() == 0) {
            System.out.println("\nNo reminders on this day");
        } else {
            System.out.println("\nReminders on this day are:");
            for (reminder r : reminders) {
                System.out.println(r.reminder);
            }
        }
    }

    int countReminders(int year, int month, int day) {
        LinkedList<reminder> reminders = years[year - 2000 - 1].months[month - 1].dates[day - 1].reminders;
        return reminders.size();
    }

    void addToDo(int year, int month, int day, String toDo) {
        years[year - 2000 - 1].months[month - 1].dates[day - 1].toDo.add(new toDo(year, month, day, toDo));
        System.out.println("\nTo do added successfully!\n");
    }

    void printToDos(int year, int month, int day) {
        LinkedList<toDo> toDos = years[year - 2000 - 1].months[month - 1].dates[day - 1].toDo;
        if (toDos.size() == 0) {
            System.out.println("\nNo toDos on this day");
        } else {
            System.out.println("\nToDos on this day are:");
            for (toDo t : toDos) {
                System.out.println(t.toDo);
            }
        }
    }

    int countToDos(int year, int month, int day) {
        LinkedList<toDo> toDos = years[year - 2000 - 1].months[month - 1].dates[day - 1].toDo;
        return toDos.size();
    }

    boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    int getDay(int year, int month, int day) {
        int dayNumber = 0;
        for (int i = 2000; i < year; i++) {
            if (isLeapYear(i)) {
                dayNumber += 366;
            } else {
                dayNumber += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            if (i == 2 && isLeapYear(year)) {
                dayNumber += 29;
            } else {
                dayNumber += numberOfDays[i - 1];
            }
        }
        dayNumber += day;
        return dayNumber % 7;
    }

    void printMonthCalender(int year, int month) {
        int day = getDay(year, month, 1);
        System.out.println("\n");
        System.out.println("   " + months[month - 1] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int spaces = day * 3;
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= numberOfDays[month - 1]; i++) {
            if (i < 10) {
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }
            if ((i + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    void printYearCalender(int year) {
        for (int i = 1; i <= 12; i++) {
            printMonthCalender(year, i);
        }
    }

}

/**
 * project
 */
public class project {
    static Scanner sc = new Scanner(System.in);

    public static int inputYear() {
        System.out.print("Enter the Year(YYYY): ");
        int year = sc.nextInt();
        if (year < 1000 || year > 9999) {
            System.out.println("Invalid year");
            inputYear();
        }
        return year;
    }

    public static int inputMonth() {
        System.out.print("Enter the Month(MM): ");
        int month = sc.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Invalid month");
            inputMonth();
        }
        return month;
    }

    public static int inputDay() {
        System.out.print("Enter the Day(DD): ");
        int day = sc.nextInt();
        if (day < 1 || day > 31) {
            System.out.println("Invalid day");
            inputDay();
        }
        return day;
    }

    public static String inputName() {
        System.out.print("Enter the Name: ");
        String name = sc.next();
        return name;
    }

    public static String inputReminder() {
        System.out.print("Enter the Reminder: ");
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        String reminder = sc.nextLine();
        return reminder;
    }

    public static String inputToDO() {
        System.out.print("Enter the ToDO: ");
        String toDo = sc.next();
        return toDo;
    }

    public static void printCurrentDate() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        System.out.printf("""
                --------------------------------
                Today's date is: %d/%d/%d
                --------------------------------
                """, day, month, year);
    }

    public static void printMenu() {
        System.out.println("\n");
        printCurrentDate();
        System.out.println("""
                ==============================
                1. Print the calendar for a month
                2. Print the calendar for a year
                3. Add a reminder
                4. Print all reminders for a day
                5. Add a toDo
                6. Print all toDos for a day
                7. Add a Birthday
                8. Print all Birthdays for a day
                9. Print all Birthdays for a Month
                10. Exit
                ==============================
                """);
    }

    public static void main(String[] args) {
        calender cal = new calender();
        // calender.readYearsDataFromFile();
        while (true) {
            printMenu();
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    cal.printMonthCalender(inputYear(), inputMonth());
                    break;
                case 2:
                    cal.printYearCalender(inputYear());
                    break;
                case 3:
                    cal.addReminder(inputYear(), inputMonth(), inputDay(), inputReminder());
                    break;
                case 4:
                    cal.printReminders(inputYear(), inputMonth(), inputDay());
                    break;
                case 5:
                    cal.addToDo(inputYear(), inputMonth(), inputDay(), inputName());
                    break;
                case 6:
                    cal.printToDos(inputYear(), inputMonth(), inputDay());
                    break;
                case 7:
                    cal.addBirthday(inputName(), inputYear(), inputMonth(), inputDay());
                    break;
                case 8:
                    cal.printBirthdays(inputYear(), inputMonth(), inputDay());
                    break;
                case 9:
                    cal.printBirthdaysInAMonth(inputYear(), inputMonth());
                    break;
                case 10:
                    // calender.writeYearsDataToFile();
                    System.exit(0);
                    break;
            }
        }
    }
}