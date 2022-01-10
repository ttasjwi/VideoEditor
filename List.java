import java.util.LinkedList;
import java.util.Optional;

public interface List<E> {

    // 추가
    boolean add(E element);

    // 삽입
    void insert(int index, E element);

    // 삭제
    Optional<E> delete(int index);

    // 데이터 반환
    Optional<E> get(int index);

    // 보존 데이터의 갯수
    int size();

    // 데이터가 존재하지 않는지 여부
    boolean isEmpty();

    // 지정 객체가 몇 번째에 위치해 있는지 여부 반환
    int indexOf(Object o);

    boolean contains(Object o);

}
