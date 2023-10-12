
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        RickAndMortyApi api = retrofit.create(RickAndMortyApi.class);

        try {
            Call<Result> call = api.getEpisodes();
            Response<Result> response = call.execute();
            if (response.isSuccessful()) {
                Result result = response.body();
                Info info = result.getInfo();
                List<Episode> episodes = result.getEpisodes();
                Episode episodeWithMaxCharacters = episodes.stream()
                        .max(Comparator.comparingInt(ep -> ep.getCharacters().size()))
                        .orElse(null);

                System.out.println("Объект info:");
                System.out.println("Count: " + info.getCount());
                System.out.println("Pages: " + info.getPages());
                System.out.println("Next: " + info.getNext());
                System.out.println("Prev: " + info.getPrev());
                if (episodeWithMaxCharacters != null) {
                    System.out.println("Quantity of characters: " + episodeWithMaxCharacters.getCharacters().size());
                    System.out.println("Episode ID: " + episodeWithMaxCharacters.getId());
                    System.out.println("Episode Name: " + episodeWithMaxCharacters.getName());
                    System.out.println("Episode Air Date: " + episodeWithMaxCharacters.getAirDate());
                    System.out.println("Episode Episode: " + episodeWithMaxCharacters.getEpisode());
                    System.out.println("Character URLs: " + episodeWithMaxCharacters.getCharacterUrls());
                    System.out.println("URL: " + episodeWithMaxCharacters.getUrl());
                    System.out.println("Created: " + episodeWithMaxCharacters.getCreated());
                }
            } else {
                System.out.println("Не удалось найти эпизоды.");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}