import java.util.Optional;

public class LinkedList<E> implements List<E> {

    private int size = 0;

    // 저장 데이터 갯수
    @Override
    public int size() {
        return this.size;
    }

    // 비어있는 지의 여부
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    //TODO : 데이터 추가
    @Override
    public boolean add(E element) {
        return false;
    }

    //TODO : 데이터 삽입
    @Override
    public void insert(int index, E element) {

    }

    //TODO : 데이터 삭제
    @Override
    public Optional<E> delete(int index) {
        return Optional.empty();
    }

    // TODO : 객체가 존재하는 index 반환
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    // TODO : 객체를 포함하고 있는지 여부 반환
    @Override
    public boolean contains(Object o) {
        return false;
    }
}
