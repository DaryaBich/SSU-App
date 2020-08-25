package com.example.mobilessu.teacher_page;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mobilessu.entities.Teacher;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Teacher_model implements Teacher_interface.Model {
    @NotNull
    @Override
    public List<Teacher> getTeachers(@NotNull String inputName) {
        try {
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(inputName);
            return myAsyncTask.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        }
    }

    private static class MyAsyncTask extends AsyncTask<String, Void, List<Teacher>> {
        List<Teacher> teacherList = new LinkedList<>();

        @Override
        protected List<Teacher> doInBackground(String... strings) {
            String url = "https://scribabot.tk/api/v2/api-docs/v1.0/teacher/" +strings[0];
            OkHttpClient okHttpClient = new OkHttpClient();
            
            Request request = new Request.Builder().url(url).build();

            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(json).getJSONObject("value");
                        teacherList = (List<Teacher>) jsonObject.get("teachers");
                    } catch (JSONException e) {
                        Log.d("ERROR", "Problem with response");
                    }
                }
            });
            return teacherList;
        }

        @Override
        protected void onPostExecute(List<Teacher> teachers) {
            super.onPostExecute(teachers);
        }
    }
}
