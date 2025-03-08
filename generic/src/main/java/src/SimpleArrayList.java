package src;

public class SimpleArrayList<T> implements SimpleList<T> {
    private Object[] values;

    public SimpleArrayList(Object... values) {
        this.values = values;
    }

    public SimpleArrayList() {
        this.values = new String[0];
    }

    @Override
    public boolean add(T value) {
        Object[] updated = new Object[values.length + 1];
        for (int i = 0; i < values.length; i++) {
            updated[i] = values[i];
        }
        updated[values.length] = value;
        values = updated;
        return true;
    }

    @Override
    public void add(int index, T value) {
        validateAddIndex(index);
        Object[] updated = new Object[values.length + 1];
        for (int i = 0; i < index; ++i) {
            updated[i] = values[i];
        }
        updated[index] = value;
        for (int i = values.length; i > index; --i) {
            updated[i] = values[i-1];
        }
        values = updated;
    }

    @Override
    public T set(int index, T value) {
        validateIndex(index);
        T old = (T) values[index];
        values[index] = value;
        return old;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) values[index];
    }

    @Override
    public boolean contains(T value) {
        for (Object s : values) {
            if (value.equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }

    @Override
    public boolean remove(T value) {
        int index = -1;
        for (int i = 0; i < values.length; i++) {
            if (value.equals((T) values[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T old = (T) values[index];
        Object[] updated = new Object[values.length - 1];
        for (int i = 0; i < index; ++i) {
            updated[i] = values[i];
        }
        for (int i = index; i < values.length - 1; ++i) {
            updated[i] = values[i+1];
        }
        values = updated;
        return old;
    }

    @Override
    public void clear() {
        values = new String[0];
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= values.length) {
            throw new IllegalArgumentException("인덱스 범위가 올바르지 않습니다.");
        }
    }

    private void validateAddIndex(int index) {
        if (index < 0 || index > values.length) {
            throw new IllegalArgumentException("인덱스 범위가 올바르지 않습니다.");
        }
    }
}
