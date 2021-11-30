package contents.week4.exception.example2;

public class Example_1 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(4, 0);
        calculator.divide();
    }
}

class Calculator {
    int left, right;

    public Calculator(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void divide() {
        if (this.right == 0) {
            try {
                throw new DivideException("산술조건이 부적합 합니다.");
            } catch (DivideException e) {
                e.printStackTrace();
            }
        }
        System.out.print(this.left / this.right);
    }
}


