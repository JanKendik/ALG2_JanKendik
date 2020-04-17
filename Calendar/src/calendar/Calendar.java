package calendar;

public class Calendar {

    private int day;
    private int month;
    private int year;

    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    private int validDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Dny v měsíci mohou být pouze v rozmezí 1 až 31 dní!");
        }
        return day;
    }

    private int validMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Měsíce v roce mohou být pouze v rozmezí 1 až 12 měsíců!");
        }
        return month;
    }

    public static boolean prechodnyR(int y) {
        if (y % 4 != 0) {
            return false;
        }
        if (y % 4 != 0) {
            return true;
        }
        return y % 400 == 0;
    }

    public static int dniVRoce(int y) {
        return prechodnyR(y) ? 366 : 365;
    }

    private static int[] dniVMesici(int y) {
        int[] dni = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        dni[1] = prechodnyR(y) ? 29 : 28;
        return dni;
    }

    public int getDayZeller() {
        int q = this.day;
        int m = this.month;
        int y = this.year;
        int K = y % 100;
        int J = y / 100;
        if (m == 1) {
            m = 13;
            y--;
        }
        if (m == 2) {
            m = 14;
            y--;
        }
        //zelleruv algoritmus uvažuje 13. mesic jako leden a 14. jako unor 
        int h;
        h = q + ((13 * (m + 1)) / 5) + K + (K / 4) + (J / 4) + 5 * J; // Zellerův algoritmus je u dělení obohacen závorkami, které nám vrací pouze celočíselný výsledek a desetinnou část výsledku neuvažujeme, ale pokud pracujeme s datovým typem "int" tak tyto závorky nemusíme řešit a vypočty nám sami vrací celočíselné vysledky.
        h = h % 7;
        int d = ((h + 5) % 7) + 1;
        return d;
    }

    public String viewCalendar() {
        StringBuilder C = new StringBuilder();
        C.append(String.format("%s %4d %n", whichMonth(this.month), this.year));
        C.append("Po Út St Čt Pá So Ne %n");
        int tempD = this.day;
        this.day = 1;
        int firstD = getDayZeller();

        for (int i = 0; i < firstD - 1; i++) {
            C.append("   ");
        }
        for (int i = 0; i < dniVMesici(this.year)[this.month - 1]; i++) {
            C.append(String.format("%2d ", this.day));
            if (getDayZeller() == 7) {
                C.append("%n");
                
            }
            this.day++;
        }

        int lastD = getDayZeller();
        for (int i = 0; i < 7 - lastD + 1; i++) {
            C.append("   ");
        }
        C.append("%n");
        this.day = tempD;
        return C.toString();
    }

   private static String whichMonth(int month) {
        switch (month) {
            case 1:
                return "Leden";
            case 2:
                return "Únor";
            case 3:
                return "Březen";
            case 4:
                return "Duben";
            case 5:
                return "Květen";
            case 6:
                return "Červen";
            case 7:
                return "Červenec";
            case 8:
                return "Srpen";
            case 9:
                return "Zaři";
            case 10:
                return "Říjen";
            case 11:
                return "Listopad";
            case 12:
                return "Prosinec";
        }
        return null;
    }
    
    public void previousM() {
        this.day = 1;
        if (this.month == 1) {
            this.month = 12;
            this.year--;
        } else {
            this.month--;
        }
    }
    
    public void nextM() {
        this.day = 1;
        if (this.month == 12) {
            this.year++;
            this.month = 1;
        } else {
            this.month++;
        }
    }

}
