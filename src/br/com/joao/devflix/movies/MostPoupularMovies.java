package br.com.joao.devflix.movies;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;


public class MostPoupularMovies extends Exception {
    public static void main(String[] args ) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        JsonParser parser = new JsonParser();
        List<Map<String, String>> mostPopularMovies = parser.parse(body);
        for(Map<String, String> popularMovies : mostPopularMovies){
            System.out.print("\u001b[1mFilme: ");
            System.out.println(popularMovies.get("title"));
            System.out.print("Capa: ");
            System.out.println(popularMovies.get("image"));
            System.out.print("Nota: ");
            System.out.print(popularMovies.get("imDbRating"));
            System.out.println(" \u2605");
            System.out.println("--------------------------------");
        }



    }



}
