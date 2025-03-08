package src;

public interface SimpleList<T> {

    // 정적 생성자를 여러 개 두면 되지 않을까? -> 원하는 구현체에 따라서 서로 다른 정적 생성자를 만든다.
    // -> 나였으면? 구현체 내부에서 정적 생성자를 만들 것 같다

    // 실제로 List의 경우에는 Collections 클래스의 구현체를 리턴하고 있음.
    // -> 이 케이스처럼 아주 간편한 구현체는 별도의 클래스로 분리할 수도 있을 듯.
    // :: 결국 어느 부분에 중점을 두냐에 따라서 인터페이스가 구현체에 의존할 수도 있고 의존하지 않을 수도 있다.
    // (실제 java 업데이트 과정에서도 두 의견(인터페이스는 구현체에 의존하면 안된다 vs 된다)이 섞여서 업데이트 되는 것을 볼 수 있음)
    static <T> SimpleList<T> fromArrayToList(T[] arrays) {
        return new SimpleArrayList<T>(arrays);
    }

    static <T extends Number> double sum(SimpleList<T> targets) {
        double sum = 0;
        for (int i = 0; i < targets.size(); ++i) {
            sum += targets.get(i).doubleValue();
        }
        return sum;
    }

    static <T extends Number> SimpleList<T> filterNegative(SimpleList<T> targets) {
        SimpleList<T> result = new SimpleArrayList<>();
        for (int i = 0; i < targets.size(); ++i) {
            if (targets.get(i).doubleValue() >= 0) {
                result.add(targets.get(i));
            }
        }
        return result;
    }

    static void copy(SimpleList<? extends Printer> from, SimpleList<? super Printer> to) {
        to.clear();
        for (int i = 0; i < from.size(); ++i) {
            to.add(from.get(i));
        }
    }

    boolean add(T value);

    void add(int index, T value);

    T set(int index, T value);

    T get(int index);

    boolean contains(T value);

    int indexOf(T value);

    int size();

    boolean isEmpty();

    boolean remove(T value);

    T remove(int index);

    void clear();
}

