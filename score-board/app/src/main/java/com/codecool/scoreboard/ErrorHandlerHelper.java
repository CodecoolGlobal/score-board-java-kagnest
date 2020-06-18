package com.codecool.scoreboard;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.HttpException;

public class ErrorHandlerHelper {

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static String getErrorMessage(Throwable error) {
        String errorMessage = "";
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_NOT_FOUND:
                    errorMessage = "Page not found";
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    errorMessage = "Internal Server Error";
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    errorMessage = "Bad Request";
                    break;
                case HttpsURLConnection.HTTP_CLIENT_TIMEOUT:
                    errorMessage = "Request Timeout";
                    break;
                case API_STATUS_CODE_LOCAL_ERROR:
                    errorMessage = "No Internet Connection";
                    break;
                default:
                    errorMessage = error.getLocalizedMessage();
            }
        } else {
            errorMessage = error.getMessage();
        }
        return errorMessage;
    }
}
