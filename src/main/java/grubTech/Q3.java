package grubTech;
/**You are planning a trip by car and want to estimate fuel costs.
 * The fuel price is approximately $1.30 per litre. Your car consumes around 1 liter for every 8 kilometres traveled.
 * You have a list of destination to visit. They are given in the following format:
 * */
public class Q3 {
    public static void main(String[] args) {
        String[] s = new String[]{"Vienna-Prague 312","Prague-Zurich 676"};
        calculator(s);
    }
    public static String calculator( String[] distancesList ) {
        final double perLitre= 1.30;
        final int consumption = 8;
        int totalDistance = 0;

        int maxDistance = 0;
        int max = 0;

        int[] distances = new int[distancesList.length];
        for(int i = 0; i < distancesList.length; i++) {
            String item = distancesList[i];
            String[] words = item.split(" ");
            String distInKm = words[words.length-1];
            distances[i] = Integer.parseInt(distInKm);
        }

        for(int i = 0; i < distances.length; i++) {
            if(distances[i] > maxDistance) {
                totalDistance += distances[i];
                maxDistance = distances[i];
                max = i;
            }
        }
        Double totalExpences = totalDistance/consumption * perLitre;

        int endOfTitle = distancesList[max].indexOf("" + maxDistance);
        String distanceTitle = new String();
        if(endOfTitle != -1) {
            distanceTitle = distancesList[max].substring(0, endOfTitle);
        }
        StringBuffer sb = new StringBuffer();

        String format = String.format("%.2f", totalExpences);
        sb.append("Total expenses:$").
                append(format).
                append(";Longest distance:").append(distanceTitle).append(" ");
        return sb.toString();
    }
}
