package no.hiof.oleedvao.lecture16maven;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {

        /*
        Denne klassen kan bare importeres og benyttes dersom jackson-databind er blitt lagt til som en dependency
        i pom.xml. Se pom.xml og slides for hvordan dette gjøres.
         */
        ObjectMapper objectMapper = new ObjectMapper();

    }
}
