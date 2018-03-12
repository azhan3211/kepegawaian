package com.example.clown.first.Service;

import com.example.clown.first.DokumenP.Dokumen;
import com.example.clown.first.DokumenP.DokumenApi;
import com.example.clown.first.Jabatan.Jabatan;
import com.example.clown.first.Jabatan.JabatanApi;
import com.example.clown.first.Pegawai.Pegawai;
import com.example.clown.first.Pegawai.PegawaiApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by cLown on 3/7/2018.
 */

public interface InterfaceKepegawaian {

    @GET("dokumen")
    Call<DokumenApi> getDokumenApi();

    @GET("jabatan")
    Call<JabatanApi> getJabatanApi();

    @GET("pegawai")
    Call<PegawaiApi> getPegawaiApi();

    @POST("jabatan")
    Call<Jabatan> setJabatan(@Body Jabatan jabatan);

    @POST("pegawai")
    Call<Pegawai> setPegawai(@Body Pegawai pegawai);

    @POST("dokumen")
    Call<Dokumen> setDokumen(@Body Dokumen dokumen);

    @PUT("jabatan/{id}")
    Call<JabatanApi> editJabatan(@Path("id") String id, @Field("Nama_jabatan") String Nama_jabatan);

    @DELETE("jabatan/{id}")
    Call<ResponseBody> deleteJabatan(@Path("id") String id);

    @DELETE("dokumen/{id}")
    Call<ResponseBody> deleteDokumen(@Path("id") String id);

}
