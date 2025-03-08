package src;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SimpleArrayListTest {
    @DisplayName("ArrayList 테스트")
    @Test
    void arrayListTest() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.get(1)).isEqualTo("second"); // 두 번째 값을 찾는다.
        assertThat(values.get(2)).isEqualTo("third"); // 세 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        // TODO values에 담긴 모든 값을 출력한다.
        for (String value : values) {
            System.out.println(value);
        }

        assertThat(values.set(0, "first")).isEqualTo("second"); // "first", "third"
        assertThat(values.get(0)).isEqualTo("first");

        values.add(1, "second"); // 중간에 값을 추가할 수 있는지 확인 - "first", "second", "third"
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(1)).isEqualTo("second");
        assertThat(values.indexOf("first")).isEqualTo(0);
        assertThat(values.indexOf("second")).isEqualTo(1);
        assertThat(values.indexOf("third")).isEqualTo(2);

        assertThat(values.remove("third")).isTrue(); // "first", "second"
        assertThat(values.remove("fourth")).isFalse();
        assertThat(values.size()).isEqualTo(2);
        assertThat(values.indexOf("first")).isEqualTo(0);

        assertThat(values.remove(0)).isEqualTo("first"); // "second"
        assertThat(values.get(0)).isEqualTo("second");

        values.add(1, "third"); // "second", "third"
        values.add(0, "first"); // "first", "second", "third"
        values.add(3, "fourth"); // "first", "second", "third", "fourth"
        assertThat(values.size()).isEqualTo(4);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.get(1)).isEqualTo("second");
        assertThat(values.get(2)).isEqualTo("third");

        assertThat(values.remove(1)).isEqualTo("second"); // "first", "third", "fourth"
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.get(1)).isEqualTo("third");
        assertThat(values.get(2)).isEqualTo("fourth");

        values.clear();
        assertThat(values.isEmpty()).isTrue();
        assertThat(values.size()).isEqualTo(0);
    }

    @DisplayName("SimpleList 테스트")
    @Test
    void simpleListTest() {
        SimpleList<String> values = new SimpleArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.get(1)).isEqualTo("second"); // 두 번째 값을 찾는다.
        assertThat(values.get(2)).isEqualTo("third"); // 세 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.contains("second")).isTrue(); // "second" 값이 포함되어 있는지를 확인한다.
        assertThat(values.contains("third")).isTrue(); // "third" 값이 포함되어 있는지를 확인한다.
        assertThat(values.contains("fourth")).isFalse(); // "fourth" 값이 포함되어 있지 않은지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        assertThat(values.set(0, "first")).isEqualTo("second"); // "first", "third"
        assertThat(values.get(0)).isEqualTo("first");

        values.add(1, "second"); // 중간에 값을 추가할 수 있는지 확인 - "first", "second", "third"
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(1)).isEqualTo("second");
        assertThat(values.indexOf("first")).isEqualTo(0);
        assertThat(values.indexOf("second")).isEqualTo(1);
        assertThat(values.indexOf("third")).isEqualTo(2);

        assertThat(values.remove("third")).isTrue(); // "first", "second"
        assertThat(values.remove("fourth")).isFalse();
        assertThat(values.size()).isEqualTo(2);
        assertThat(values.indexOf("first")).isEqualTo(0);

        assertThat(values.remove(0)).isEqualTo("first"); // "second"
        assertThat(values.get(0)).isEqualTo("second");

        values.add(1, "third"); // "second", "third"
        values.add(0, "first"); // "first", "second", "third"
        values.add(3, "fourth"); // "first", "second", "third", "fourth"
        assertThat(values.size()).isEqualTo(4);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.get(1)).isEqualTo("second");
        assertThat(values.get(2)).isEqualTo("third");
        assertThat(values.get(3)).isEqualTo("fourth");

        assertThat(values.remove(1)).isEqualTo("second"); // "first", "third", "fourth"
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.get(1)).isEqualTo("third");
        assertThat(values.get(2)).isEqualTo("fourth");

        values.clear();
        assertThat(values.isEmpty()).isTrue();
        assertThat(values.size()).isEqualTo(0);
    }

    @DisplayName("SimpleLinkedList 테스트")
    @Test
    void simpleLinkedListTest() {
        SimpleList<String> values = new SimpleLinkedList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.get(1)).isEqualTo("second"); // 두 번째 값을 찾는다.
        assertThat(values.get(2)).isEqualTo("third"); // 세 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.contains("second")).isTrue(); // "second" 값이 포함되어 있는지를 확인한다.
        assertThat(values.contains("third")).isTrue(); // "third" 값이 포함되어 있는지를 확인한다.
        assertThat(values.contains("fourth")).isFalse(); // "fourth" 값이 포함되어 있지 않은지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        assertThat(values.set(0, "first")).isEqualTo("second"); // "first", "third"
        assertThat(values.get(0)).isEqualTo("first");

        values.add(1, "second"); // 중간에 값을 추가할 수 있는지 확인 - "first", "second", "third"
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(1)).isEqualTo("second");
        assertThat(values.indexOf("first")).isEqualTo(0);
        assertThat(values.indexOf("second")).isEqualTo(1);
        assertThat(values.indexOf("third")).isEqualTo(2);

        assertThat(values.remove("third")).isTrue(); // "first", "second"
        assertThat(values.remove("fourth")).isFalse();
        assertThat(values.size()).isEqualTo(2);
        assertThat(values.indexOf("first")).isEqualTo(0);

        assertThat(values.remove(0)).isEqualTo("first"); // "second"
        assertThat(values.get(0)).isEqualTo("second");

        values.add(1, "third"); // "second", "third"
        values.add(0, "first"); // "first", "second", "third"
        values.add(3, "fourth"); // "first", "second", "third", "fourth"
        assertThat(values.size()).isEqualTo(4);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.get(1)).isEqualTo("second");
        assertThat(values.get(2)).isEqualTo("third");
        assertThat(values.get(3)).isEqualTo("fourth");

        assertThat(values.remove(1)).isEqualTo("second"); // "first", "third", "fourth"
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.get(1)).isEqualTo("third");
        assertThat(values.get(2)).isEqualTo("fourth");

        values.clear();
        assertThat(values.isEmpty()).isTrue();
        assertThat(values.size()).isEqualTo(0);
    }

    @DisplayName("integer 타입도 사용할 수 있다.")
    @Test
    void 제네릭_테스트() {
        SimpleList<Integer> values = new SimpleArrayList<>();
        values.add(1);
        values.add(2);

        Integer first = values.get(0);
        Integer second = values.get(1);

        assertThat(first).isEqualTo(1);
        assertThat(second).isEqualTo(2);
    }

    @DisplayName("배열로 객체를 생성할 수 있다.")
    @Test
    void 배열로_객체를_생성할_수_있다() {
        final String[] arrays = {"first", "second"};
        SimpleList<String> values = SimpleList.<String>fromArrayToList(arrays);

        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.get(1)).isEqualTo("second");
    }


    @DisplayName("제네릭의 타입을 제한할 수 있다.")
    @Test
    void 제네릭_타입_제한() {
        final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(1, 2);

        final double doubleTotal = SimpleList.sum(doubleValues); // 1.2
        final double intTotal = SimpleList.sum(intValues);  // 3

        assertAll(
                () -> assertThat(doubleTotal).isEqualTo(1.2),
                () -> assertThat(intTotal).isEqualTo(3)
        );
    }

    @DisplayName("음수를 제외한 값들을 반환할 수 있다.")
    @Test
    void 음수_제외_반환() {
        final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(-0.1, 0.5, 0.7); // 0.5, 0.7
        final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(-10, 1, 2); // 1, 2

        final SimpleList<Double> filteredDoubleValues = SimpleList.<Double>filterNegative(doubleValues);
        final SimpleList<Integer> filteredIntValues = SimpleList.<Integer>filterNegative(intValues);

        SoftAssertions.assertSoftly(soft -> {
        });
        assertAll(
                () -> assertThat(filteredDoubleValues.contains(0.5)).isTrue(),
                () -> assertThat(filteredDoubleValues.contains(0.7)).isTrue(),
                () -> assertThat(filteredDoubleValues.contains(-0.1)).isFalse(),

                () -> assertThat(filteredIntValues.contains(1)).isTrue(),
                () -> assertThat(filteredIntValues.contains(2)).isTrue(),
                () -> assertThat(filteredIntValues.contains(-10)).isFalse()
        );
    }
}
