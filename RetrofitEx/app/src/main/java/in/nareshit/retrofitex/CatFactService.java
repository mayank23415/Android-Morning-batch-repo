package in.nareshit.retrofitex;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CatFactService {

    @GET("?count=10")
    Call<Source> getCatFact();

}
