public class HoraUTC implements IHora {

    private String hora;

    @Override
    public String getHora() {
        return this.hora;
    }

    @Override
    public void setHora(String hora) {
        this.hora = hora;
    }
}
