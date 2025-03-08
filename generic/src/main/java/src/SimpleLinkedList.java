package src;

public class SimpleLinkedList<T> implements SimpleList<T> {
    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public SimpleLinkedList() {
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    @Override
    public boolean add(T value) {
        Node<T> newLastNode = new Node<>(value);
        if (size == 0) {
            firstNode = newLastNode;
        } else if (size == 1) {
            firstNode.setNext(newLastNode);
        } else {
            lastNode.setNext(newLastNode);
        }
        lastNode = newLastNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, T value) {
        validateAddIndex(index);
        Node<T> newNode = new Node<>(value);
        if (index == 0) {
            newNode.setNext(firstNode);
            firstNode = newNode;
            size++;
            return;
        }
        Node<T> found = firstNode;
        for (int i = 0; i < index - 1; ++i) {
            found = found.getNext();
        }
        newNode.setNext(found.getNext());
        found.setNext(newNode);
        size++;
    }

    @Override
    public T set(int index, T value) {
        validateIndex(index);
        Node<T> target = firstNode;
        for (int i = 0; i < index - 1; ++i) {
            target = target.getNext();
        }
        T old = target.getValue();
        target.setValue(value);
        return old;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        Node<T> target = firstNode;
        for (int i = 0; i < index; ++i) {
            target = target.getNext();
        }
        return target.getValue();
    }

    @Override
    public boolean contains(T value) {
        Node<T> current = firstNode;
        for (int i = 0; i < size; ++i) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        Node<T> current = firstNode;
        for (int i = 0; i < size; ++i) {
            if (current.getValue().equals(value)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(T value) {
        Node<T> prevNode = firstNode;
        for (int i = 0; i < size - 1; ++i) {
            Node<T> target = prevNode.getNext();
            if (target.getValue().equals(value)) {
                prevNode.setNext(target.getNext());
                target.setNext(null);
                size--;
                return true;
            }
            prevNode = prevNode.getNext();
        }
        return false;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        if (index == 0) {
            T old = firstNode.getValue();
            firstNode = firstNode.getNext();
            size--;
            return old;
        }
        Node<T> prev = firstNode;
        for (int i = 0; i < index - 1; ++i) {
            prev = prev.getNext();
        }
        Node<T> target = prev.getNext();
        T old = target.getValue();
        prev.setNext(target.getNext());
        target.setNext(null);
        size--;
        return old;
    }

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
        lastNode = null;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("인덱스 범위가 올바르지 않습니다.");
        }
    }

    private void validateAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("인덱스 범위가 올바르지 않습니다.");
        }
    }
}
