package src;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class PrinterTest {
    @Test
    void test() {
        final var laserPrinter = new LaserPrinter();

        final SimpleList<Printer> printers = new SimpleArrayList<Printer>();
        final SimpleList<LaserPrinter> laserPrinters = new SimpleArrayList<LaserPrinter>(laserPrinter);

        SimpleList.copy(laserPrinters, printers); // 첫 번째 값을 두 번째 값으로 복사

        assertSoftly(
                (softly) -> softly.assertThat(printers.get(0) == laserPrinter).isTrue()
        );
    }
}
