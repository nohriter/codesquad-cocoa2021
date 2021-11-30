package contents.week4.exception.example3;

import java.util.List;

public class IllegalIndexException extends IndexOutOfBoundsException{
    public static final String message = "범위를 벗어났습니다. ";

    public IllegalIndexException(List<?> target, int index) {
        super(message + "size: " + target.size() + " index: " + index);
    }
}
