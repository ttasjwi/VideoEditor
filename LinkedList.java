import java.util.Optional;

public class LinkedList<E> implements List<E> {

    private int size = 0;

    private Node<E> head; // 첫번째 Node
    private Node<E> tail; // 마지막 Node

    private static class Node<E> {

        // 앞의 Node
        Node<E> prev;

        // 뒤의 Node
        Node<E> next;

        // 저장 데이터
        E data;

        Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

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

    // 데이터 추가(맨 끝)
    @Override
    public boolean add(E element) {
        linkToTail(element);
        return true;
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

    // 기존 tail에 element를 연결한다.
    private void linkToTail(E element) {
        Node<E> oldTail = this.tail; // 리스트의 마지막 노드를 가져옴
        Node<E> newTail = new Node<>(oldTail, element, null); // 삽입할 새로운 노드 생성
        this.tail = newTail; // 이제 이 노드가 tail이다.

        if (oldTail==null) { // 기존 Tail이 null 이다 : 원래 리스트에 아무 것도 존재하지 않는다.
            this.head = newTail; // 첫번째 요소이므로 head 지정
        } else {
            oldTail.next = newTail; // 기존 tail이 존재하므로, oldTail에 newTail을 next로 연결함.
        }
        size ++;
    }
}
