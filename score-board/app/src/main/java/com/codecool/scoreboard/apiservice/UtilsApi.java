package com.codecool.scoreboard.apiservice;

public class UtilsApi {

    public static DataApiService getApiService(){
        return RetrofitClient.getClient().create(DataApiService.class);
    }

}
