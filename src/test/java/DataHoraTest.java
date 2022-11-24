import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataHoraTest {

    @Test
    void deveRetornarHoraUTC() {
        DataHora dataHora = new DataHora();
        dataHora.setHora("20:15:23TZ-03:00:00");
        Assertions.assertEquals("23:15:23TZ00:00:00", dataHora.getHoraUTC());
    }

    @Test
    void deveRetornarHoraTZ() {
        DataHora dataHora = new DataHora();
        dataHora.setHora("20:15:23TZ-03:00:00");
        Assertions.assertEquals("20:15:23TZ-03:00:00", dataHora.getHoraTZ("america/sao_paulo"));
    }
}
