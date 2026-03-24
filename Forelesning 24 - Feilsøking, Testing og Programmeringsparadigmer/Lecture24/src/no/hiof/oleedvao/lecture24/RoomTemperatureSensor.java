package no.hiof.oleedvao.lecture24;

/*
En enkel klasse som representerer en sensor for romtemperatur. I forbindelse med testing, og software engineering
generelt, kalles dette en "enhet". En enhet er typisk definert som en liten bit med kodefunksjonalitet, som har ett
isolert ansvar.
 */
public abstract class RoomTemperatureSensor {

    public static String getStatus(double temp) {
        if (temp >= 35) {
            return "Danger";
        }
        if (temp >= 25) {
            return "Hot";
        }
        return "Normal";
    }

}
