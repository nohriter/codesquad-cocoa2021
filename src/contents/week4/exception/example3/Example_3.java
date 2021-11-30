package contents.week4.exception.example3;

import java.util.ArrayList;
import java.util.List;

public class Example_3 {
    public static void main(String[] args) {
        DataList dataList = new DataList();

        dataList.getList(5);
    }
}

class DataList {
    List<Integer> list = new ArrayList<>(3);

    public DataList() {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public Integer getList(int index) {
        if(index >= list.size()) {
            throw new IndexOutOfBoundsException("index : "+ index +" list : "+list.size());
        }
        return list.get(index);
    }
}
