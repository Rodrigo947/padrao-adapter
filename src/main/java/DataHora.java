public class DataHora {

    IHora horaTZ;
    HoraAdapter persistencia;

    public DataHora() {
        horaTZ = new HoraTZ();
        persistencia = new HoraAdapter(horaTZ);
    }

    public void setHora(String stringHoraTZ) {
        horaTZ.setHora(stringHoraTZ);
        persistencia.salvarHora();
    }

    public String getHoraUTC() {
        return persistencia.getHora();
    }

    public String getHoraTZ(String timezone) {
        return persistencia.getHoraTZ(timezone);
    }

}
