package enderlej.utils;

/**
 * CREATED: 4/8/2017
 *
 * @author enderlej
 * @version 1
 */
public class Die {
    private final int SIDES = 6;

    public int roll() {
        return (int) (Math.random() * 6 + 1);
    }

    public static void main(String[] args) {
        Die die = new Die();
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        int other = 0;

        for(int i=0; i<100000; i++) {
            int test = die.roll();
            switch (test) {
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
                case 3:
                    threes++;
                    break;
                case 4:
                    fours++;
                    break;
                case 5:
                    fives++;
                    break;
                case 6:
                    sixes++;
                    break;
                default:
                    other++;
                    break;
            }
        }
        System.out.println("Ones: " + ones);
        System.out.println("Twos: " + twos);
        System.out.println("Threes: " + threes);
        System.out.println("Fours: " + fours);
        System.out.println("Fives: " + fives);
        System.out.println("Sixes: " + sixes);
        System.out.println("Other: " + other);

    }
}
