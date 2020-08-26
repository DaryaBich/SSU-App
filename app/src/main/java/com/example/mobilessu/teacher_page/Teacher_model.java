package com.example.mobilessu.teacher_page;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mobilessu.entities.Teacher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

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
            List result = myAsyncTask.get();
            Thread.sleep(500);
            return result;
        } catch (ExecutionException | InterruptedException e) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        }
    }

    private static class MyAsyncTask extends AsyncTask<String, Void, List<Teacher>> {

        @Override
        protected List<Teacher> doInBackground(String... strings) {
            String url = "https://scribabot.tk/api/v1.0/teacher/word";
            final List<Teacher> teacherList = new LinkedList<>();
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), strings[0]);
            Request request = new Request.Builder().url(url).post(requestBody).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }
                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    assert response.body() != null;
                    String responseBody = response.body().string();
                    String jsonList = responseBody.substring(responseBody.indexOf("[") + 1,
                            responseBody.indexOf("}]") + 1);
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    while(jsonList.indexOf("id") > 0){
                        String jsonTeacher = jsonList.substring(jsonList.indexOf("{"),
                                jsonList.indexOf("}") + 1);
                        jsonList = jsonList.replace(jsonTeacher,"");
                        Teacher teacher = gson.fromJson(jsonTeacher, Teacher.class);
                        teacherList.add(teacher);
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
