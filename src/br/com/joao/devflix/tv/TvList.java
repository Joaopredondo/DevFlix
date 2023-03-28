package br.com.joao.devflix.tv;
import br.com.joao.devflix.movies.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class TvList extends Exception {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        JsonParser parser = new JsonParser();
        List<Map<String, String>> tvList = parser.parse(body);
        for(Map<String, String> tvProgram : tvList) {
            System.out.print("\u001b[1mPrograma: ");
            System.out.println(tvProgram.get("title"));
            System.out.print("Capa: ");
            System.out.println(tvProgram.get("image"));
            System.out.print("Nota: ");
            System.out.print(tvProgram.get("imDbRating"));
            System.out.println(" \u2605");
            System.out.println("--------------------------------");
        }
    }

}
