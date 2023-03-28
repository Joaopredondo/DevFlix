package br.com.joao.devflix.movies;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class MoviesList extends Exception {
    public static void main(String[] args) throws Exception {
    // fazer uma conexacao http e buscar os top 250 moviess
    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    URI endereco = URI.create(url);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    String body = response.body();
    // pegar somente os dados que precisa via Regex(Expressoes regulares)(titulo,poster, classificao)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);
    // exibir e manipular dados
    for(Map<String, String> movies : moviesList){
        System.out.print("\u001b[1mFilme: ");
        System.out.println(movies.get("title"));
        System.out.print("Capa: ");
        System.out.println(movies.get("image"));
        System.out.print("Nota: ");
        System.out.print(movies.get("imDbRating"));
        System.out.println(" \u2605");
        System.out.println("--------------------------------");
    }
    }
}