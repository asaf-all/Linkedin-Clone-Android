package az.clone.linkedin.data.di

import android.content.Context
import androidx.room.Room
import az.clone.linkedin.data.data_source.local.AppDatabase
import az.clone.linkedin.data.data_source.remote.services.PostApi
import az.clone.linkedin.ui.tools.Constants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): PostApi {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_V1)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(PostApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRoom(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "application_database"
        ).build()
    }
}