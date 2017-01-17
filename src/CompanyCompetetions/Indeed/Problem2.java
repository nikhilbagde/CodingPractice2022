package CompanyCompetetions.Indeed;

/**
 * Created by Nikhi on 12/11/2016 11:14 AM.
 */
public class Problem2 {
    public static void main(String[] args) {
        String[] command = {"GRGL"};
        doesCircleExist(command);
    }
    static String[] doesCircleExist(String[] commands) {
        String[] result = new String [commands.length];
        int North = 0;
        int East = 1;
        int South = 2;
        int West = 3;
        int index = 0;

        int x =0, y = 0, direction = North;
        for (String command : commands) {
            char[] array = command.toCharArray();
            for (char move : array) {
                if (move == 'R') {
                    direction = (direction + 1) % 4;
                } else if (move == 'L') {
                    direction = (4 + direction - 1) % 4;
                } else {
                    if (direction == North) {
                        y++;
                    } else if (direction == East) {
                        x++;
                    } else if (direction == South) {
                        y--;
                    } else {
                        x--;
                    }
                }
            }
            if (x == 0 && y == 0) {
                result[index++] = "YES";
            } else {
                result[index++] = "NO";
            }
        }
        return result;
    }
}
