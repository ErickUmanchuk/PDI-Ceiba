package co.com.ceiba.mobile.pruebadeingreso.core

import android.app.Application
import android.content.Context
import androidx.room.Room
import co.com.ceiba.mobile.pruebadeingreso.data.db.AppDatabase
import co.com.ceiba.mobile.pruebadeingreso.core.Constants.Companion.DATABASE_NAME
import co.com.ceiba.mobile.pruebadeingreso.data.db.Migrations
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appInstance: App

        val appContext: Context by lazy {
            appInstance.applicationContext
        }
    }

    val db by lazy {
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).addMigrations(
         Migrations.MIGRATION_1_2,
         Migrations.MIGRATION_2_3
        ).build()
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
}