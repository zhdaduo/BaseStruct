package com.example.bill.basestruct.model.api;

import com.example.bill.basestruct.model.bean.Token;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Bill on 2017/8/1.
 */

public interface UserService {

  @POST("https://www.diycode.cc/oauth/token") @FormUrlEncoded
  Observable<Token> getToken(
      @Field("client_id") String client_id, @Field("client_secret") String client_secret,
      @Field("grant_type") String grant_type, @Field("username") String username,
      @Field("password") String password);
}
