package contents.week4.exception.example3;

import java.util.ArrayList;
import java.util.List;

public class Example_3_1 {
    public static void main(String[] args) {
        DataList2 dataList2 = new DataList2();

        dataList2.getList(3);
    }
}

class DataList2 {
    List<Integer> list = new ArrayList<>(3);

    public DataList2() {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public Integer getList(int index) {
        if(index >= list.size()) {
            throw new IllegalIndexException(list, index);
        }
        return list.get(index);
    }
}
