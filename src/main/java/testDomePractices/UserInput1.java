package testDomePractices;

//it fails in testdome complier. Idk why?
public class UserInput1 {

    public abstract static class Input {
        String currentValue = "";

        abstract void add(char c);

        String getValue() {
            return this.currentValue;
        }
    }

    public static class TextInput extends Input {
        public TextInput() {
        }

        @Override
        void add(char c) {
            this.currentValue = this.currentValue + c;
        }
    }

    public static class NumericInput extends TextInput {
        public NumericInput() {
            super();
        }

        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                this.currentValue = this.currentValue + c;
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
