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

    // 데이터 삽입
    @Override
    public void insert(int index, E element) {
        if (!isInsertableIndex(index)) return;

        // 마지막 인덱스 다음 인덱스이면, 맨 마지막에 놓아지는 것
        if (index==size) {
            linkToTail(element);
        } else {
            linkToPrev(findNodeByIndex(index), element);
        }
        return;
    }

    // 데이터 삭제
    @Override
    public Optional<E> delete(int index) {
        if (!isAccessableIndex(index)) return Optional.empty();
        return Optional.ofNullable(unlink(findNodeByIndex(index)));
    }

    // 객체가 존재하는 index 반환
    @Override
    public int indexOf(Object o) {
        Node<E> node = head;
        if (o == null) {
            for (int i= 0; i<size; i++, node = node.next) {
                if (node.data == null) return i;
            }
        } else {
            for (int i= 0; i<size; i++, node = node.next) {
                if (node.data.equals(o)) return i;
            }
        }
        return -1;
    }

    // 객체를 포함하고 있는지 여부 반환
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0; // 찾아낸 index가 0 이상인가?
    }

    // 데이터를 삽입가능한 인덱스인가?
    private boolean isInsertableIndex (int index) {
        return 0 <= index && index <= this.size;
    }

    // 접근 가능한 인덱스인가? (데이터가 저장된 인덱스인가?)
    private boolean isAccessableIndex(int index) {
        return 0 <= index && index < this.size;
    }

    // 지정 Node의 자리를 대체하여 새로운 요소를 삽입한다.
    private void linkToPrev(Node<E> oldNode, E element) {
        Node<E> prev = oldNode.prev; // 기존 node의 앞 node
        Node<E> newNode = new Node<>(prev, element, oldNode); // 새 node 생성
        oldNode.prev = newNode; // 기존 node의 prev에 newNode 연결

        // 앞 node가 없다. -> 새 node는 head가 됨
        if (prev == null) {
            this.head = newNode;
        } else {
            // 앞 node가 있으면 앞 노드에 연결
            prev.next = newNode;
        }
        size ++;
        return;
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

    // 지정 index에 위치한 Node를 반환한다. (유효값이 입력됐을 때를 전제로 하는 메서드다.)
    private Node<E> findNodeByIndex(int index) {
        int middleIndex = size/2; // 2로 나누고 나머지를 버렸을 때의 인덱스를 기점으로 생각

        // 가운데보다 앞이면 맨 앞부터 탐색한다.
        if (index < middleIndex) {
            Node<E> node = this.head;
            for (int i=0; i<index; i++) { // 0번, 1번, ... index번 다음으로 넘어감.
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = this.tail;
            for (int i=size-1; i>index; i--) { // 끝에서부터 node를 탐색
                node = node.prev;
            }
            return node;
        }
    }

    // 지정 node의 연결을 끊는다. 앞과 뒤에 연결된 node가 존재하면 제거한다.
    private E unlink(Node<E> node) {
        E element = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        // unlink할 node의 앞 node의 연결관계를 재갱신
        if (prev == null) {
            this.head = next;
        } else {
            prev.next = next;
            node.prev = null; // prev node가 여전히 남아있으므로 제거
        }

        // unlink할 node의 뒷 node의 연결관계를 재갱신
        if (next == null) {
            this.tail = prev;
        } else {
            next.prev = prev;
            node.next = null; // next node가 여전히 남아있으므로 제거
        }

        node.data = null; // unlink할 node에 남아있는 data 제거
        size --;
        return element;
    }
}
