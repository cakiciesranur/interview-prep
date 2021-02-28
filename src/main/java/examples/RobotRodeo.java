package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotRodeo {
    public static void main(String[] args) {
        List<String> result = doesCircleExist(Arrays.asList("RG"));
        result.forEach(System.out::println);
    }

    public static List<String> doesCircleExist(List<String> commands) {
        List<String> result = new ArrayList<>();

        for (String command : commands) {
            if (isCircular(command.toCharArray())) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        }
        return result;
    }

    static boolean isCircular(char path[]) {
        // Initialize starting
        // point for robot as
        // (0, 0) and starting
        // direction as N North
        int x = 0, y = 0;
        int dir = 0;

        // Traverse the path given for robot
        for (int i = 0; i < path.length; i++) {
            // Find current move
            char move = path[i];

            // If move is left or
            // right, then change direction
            if (move == 'R')
                dir = (dir + 1) % 4;
            else if (move == 'L')
                dir = (4 + dir - 1) % 4;

                // If move is Go, then
                // change  x or y according to
                // current direction
            else // if (move == 'G')
            {
                if (dir == 0)
                    y++;
                else if (dir == 1)
                    x++;
                else if (dir == 2)
                    y--;
                else // dir == 3
                    x--;
            }
        }

        // If robot comes back to
        // (0, 0), then path is cyclic
        return (x == 0 && y == 0);
    }
}
