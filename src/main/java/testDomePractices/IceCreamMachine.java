package testDomePractices;

import java.util.*;
import java.util.stream.Collectors;

/* implement the IceCreamMachine's scoops method so that
it returns all combinations of one ingredient and one topping. If there are no ingredients or toppings,
the method should return an empty list.
 */
public class IceCreamMachine {
    public String[] ingredients;
    public String[] toppings;

    public static class IceCream {
        public String ingredient;
        public String topping;

        public IceCream(String ingredient, String topping) {
            this.ingredient = ingredient;
            this.topping = topping;
        }
    }

    public IceCreamMachine(String[] ingredeints, String[] toppings) {
        this.ingredients = ingredeints;
        this.toppings = toppings;
    }

    public List<IceCream> scoops() {

        if (isEmpty(ingredients) || isEmpty(toppings)) {
            return Collections.emptyList();
        }

        return Arrays.stream(ingredients).flatMap(s1 -> Arrays.stream(toppings).map(s2 -> new IceCream(s1, s2))).collect(Collectors.toList());
    }

    private boolean isEmpty(String[] list) {
        return list == null || list.length == 0;
    }

    public static void main(String[] args) {
        IceCreamMachine machine = new IceCreamMachine(new String[]{"vanilla", "chocolate"}, new String[]{"chocolate sauce"});
        List<IceCream> scoops = machine.scoops();

        /*
         * Should print:
         * vanilla, chocolate sauce
         * chocolate, chocolate sauce
         */
        for (IceCream iceCream : scoops) {
            System.out.println(iceCream.ingredient + ", " + iceCream.topping);
        }
    }
}