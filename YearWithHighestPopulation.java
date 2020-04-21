import java.util.Arrays;

public class YearWithHighestPopulation {

    public static int yearWithHighestPopulation(int[][] years) {
        if (years == null || years.length == 0 || years[0].length != 2) {
            return 0;
        }

        int[] birthYears = new int[years.length];
        int[] deathYears = new int[years.length];

        for (int i = 0; i < years.length; i++) {
            birthYears[i] = years[i][0];
            deathYears[i] = years[i][1];
        }

        Arrays.sort(birthYears);
        Arrays.sort(deathYears);

        int count = 0;
        int maxCount = 0;
        int year = 0;

        int endpoint = 0;
        for (int i = 0; i < birthYears.length; i++) {
            if (birthYears[i] < deathYears[endpoint]) {
                count ++;

                if (count > maxCount) {
                    maxCount = count;
                    year = birthYears[i];
                }
            } else {
                endpoint ++;
            }
            
        }
        return year;
    }


    public static void main(String[] args) {
        int[][] years = new int[][] { {2000, 2010}, {1975, 2005}, {1975, 2003}, {1803, 1809}, {1750, 1869}, {1840, 1935}, {1803, 1921}, {1894, 1921}};
        System.out.println(yearWithHighestPopulation(years));
    }
}