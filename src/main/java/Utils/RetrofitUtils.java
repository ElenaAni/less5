package Utils;

import java.time.Duration;
import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@UtilityClass
public class RetrofitUtils {
    HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
    public Retrofit getRetrofit(){
        OkHttpClient client;
        client = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofMinutes(15))
                .addInterceptor(loggin.setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl("http://80.78.248.82:8189/market/api/v1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
