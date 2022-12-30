package testDomePractices;

/*
* User interface contains two types of user input controls: TextInput, which accepts all characters and NumericInput, which accepts only digits.

Implement the class TextInput that contains:

Public method void add(char c) - adds the given character to the current value
Public method String getValue() - returns the current value
Implement the class NumericInput that:

Inherits from TextInput
Overrides the add method so that each non-numeric character is ignored
For example, the following code should output "10":

TextInput input = new NumericInput();
input.add('1');
input.add('a');
input.add('0');
System.out.println(input.getValue());
*/
public class UserInput {

    private static String currentValue;

    public static class TextInput {
        public TextInput() {
            currentValue = "";
        }

        void add(char c) {
            currentValue = currentValue + c;
        }

        public String getValue() {
            return currentValue;
        }
    }

    public static class NumericInput extends TextInput {
        public NumericInput() {
            super();
        }

        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                currentValue = currentValue + c;
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
