package no.hiof.oleedvao.lecture23;

import no.hiof.oleedvao.lecture23.model.Album;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    /*
    Konstanter benyttet til databasekoblinger
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/albumdb";
    private static final String USERNAME = "..."; //Skriv inn brukernavnet for databasen din
    private static final String PASSWORD = "..."; //Skriv inn passordet for databasen din

    public static void main(String[] args) {

        Album newAlbum = new Album("Demon Days", "Gorillaz", 2005);
        addAlbum(newAlbum);

        ArrayList<Album> allAlbums = getAllAlbums();

        for (Album album : allAlbums) {
            System.out.println(album);
        }
    }

    /*
    Legger til et album i databasen
     */
    public static void addAlbum(Album album) {

        /*
        Oppretter en databasekobling. Merk at dette krever tilgang til en en MySQL-driver. Se pom.xml for tilgang til
        denne, spesifikt mysql.mysql-connector-java. Merk også at Connections kan medføre exceptions og bør lukkes, så
        bruk av try-with-resources er anbefalt.
         */
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {

            /*
            Vi definerer her en SQL for å legge til et nytt album. Merk at verdiene for Title, Artist og Year ikke
            defineres direkte i SQL-strengen, men markes med tegnet ?. Disse må settes inn med egne metoder gjennom
            PreparedStatement.
             */
            String sql = "insert into album (Title, Artist, Year) values (?, ?, ?)";

            /*
            For å kjøre uttrykket oppretter vi en PraparedStatement. Merk at dette objektet må ha en feilhåndtering og
            lukkes etter bruk.
             */
            try (PreparedStatement prepStatement = connection.prepareStatement(sql)) {

                /*
                Vi definerer her verdiene markert med ? basert på posisjon/rekkefølge og datatype. Merk at posisjon med
                PreparedStatements starter på 1 og går oppover. Verdiene vi setter hentes ut fra Album-objektet
                definert som parameter.
                 */
                prepStatement.setString(1, album.getTitle());
                prepStatement.setString(2, album.getArtist());
                prepStatement.setInt(3, album.getYear());

                /*
                Kjører uttrykket. Merk at vi benytter executeUpdate() når vi skal utføre en handling uten å motta
                data tilbake.
                 */
                prepStatement.executeUpdate();
            }

        }
        catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

    }


    /*
    Henter alle album fra databasen og returnerer disse som en liste med Album-objekter.
     */
    public static ArrayList<Album> getAllAlbums() {

        ArrayList<Album> allAlbums = new ArrayList<>();

        /*
        Oppretter en databasekobling. Merk at dette krever tilgang til en en MySQL-driver. Se pom.xml for tilgang til
        denne, spesifikt mysql.mysql-connector-java. Merk også at Connections kan medføre exceptions og bør lukkes, så
        bruk av try-with-resources er anbefalt.
         */
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {

            // SQL som skal kjøres. Her at vi henter alt fra tabellen kalt album.
            String sql = "select * from album";

            /*
            For å gjøre SQL-spørringen kjørbar lager vi et PreparedStatement via Connection-objektet.
            Hvis SQL-spørringen skal returnerer et resultat benytter vi metoden executeQuery() som vil returnere
            et ResultSet-objekt. Merk at både PreparedStatement og ResultSet kan gi exceptions som må håndteres og
            bør lukkes etter bruk.
             */
            try (PreparedStatement prepStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = prepStatement.executeQuery();) {

                /*
                Den følgende løkken vil gjennomgå hver rad i resultatet, som hver representerer ett album.
                 */
                while (resultSet.next()) {

                    /*
                    For hver rad kan vi hente ut individuelle kolonne-verdier og benytte disse som vi ønsker.
                    For eksempel for å opprette objekter. Her vil hver rad representere et album, så vi henter ut og
                    benytter de individuelle verdiene nøvendig for å opprette et Album-objekt. Kolonne-verdiene er
                    avhengig av hvordan disse er definert i databasen.
                     */
                    String albumTitle = resultSet.getString("Title");
                    String albumArtist = resultSet.getString("Artist");
                    int albumYear = resultSet.getInt("Year");

                    /*
                    Benytter de uthentede verdiene til å opprette et Album-objekt og legger det til i listen som skal
                    returneres
                     */
                    Album fetchedAlbum = new Album(albumTitle, albumArtist, albumYear);
                    allAlbums.add(fetchedAlbum);
                }
            }
        }
        catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return allAlbums;
    }
}
