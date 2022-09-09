package in.nareshit.retrofitpost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

    // This is the second way of posting the data to server
   /* @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Body Post post);*/
}
