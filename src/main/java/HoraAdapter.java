import java.util.HashMap;

public class HoraAdapter extends HoraUTC {

    private IHora horaTZ;
    private HashMap<String, Integer> timezoneHours = new HashMap<>();


    public HoraAdapter(IHora horaTZ) {
        this.horaTZ = horaTZ;
        timezoneHours.put("america/sao_paulo", -3);
    }

    public String getHoraTZ(String timezone) {
        int increment = timezoneHours.get(timezone);

        String[] arrayHoraUTC = this.getHora().split("TZ");
        String[] horaMinutoSegundo = arrayHoraUTC[0].split(":");

        int horaInt = Integer.parseInt(horaMinutoSegundo[0]);
        String horaConvertidaTZ = Integer.toString(horaInt+increment);
        horaConvertidaTZ = horaConvertidaTZ + ":" + horaMinutoSegundo[1] + ":" + horaMinutoSegundo[2];

        String strIncrement = Integer.toString(increment);

        if(Math.abs(increment) < 10){
            strIncrement = strIncrement.length() == 2 ? strIncrement.charAt(0) + "0" + strIncrement.charAt(1) : "0"+strIncrement;
        }

        horaConvertidaTZ = horaConvertidaTZ + "TZ"+strIncrement+":00:00";

        horaTZ.setHora(horaConvertidaTZ);

        return horaTZ.getHora();
    }

    public void salvarHora() {
        String[] arrayHoraTZ = horaTZ.getHora().split("TZ");
        String[] horaMinutoSegundo = arrayHoraTZ[0].split(":");
        String[] timeIncrement = arrayHoraTZ[1].split(":");

        int horaInt = Integer.parseInt(horaMinutoSegundo[0]);
        int timeIncrementInt = Integer.parseInt(timeIncrement[0])*-1;

        String horaConvertidaUTC = Integer.toString(horaInt+timeIncrementInt);
        horaConvertidaUTC = horaConvertidaUTC + ":" + horaMinutoSegundo[1] + ":" + horaMinutoSegundo[2];
        horaConvertidaUTC = horaConvertidaUTC + "TZ00:00:00";

        this.setHora(horaConvertidaUTC);
    }
}
