package pro.kuzdowicz.autoreply.store.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.jvm.Synchronized
import androidx.room.Room
import pro.kuzdowicz.autoreply.store.data.AppPackage
import pro.kuzdowicz.autoreply.store.data.ReplyLogs
import pro.kuzdowicz.autoreply.store.repository.AppPackageDao
import pro.kuzdowicz.autoreply.store.repository.ReplyLogsDao
import pro.kuzdowicz.autoreply.constants.Constants
import pro.kuzdowicz.autoreply.store.data.MessageLogs
import pro.kuzdowicz.autoreply.store.repository.MessageLogsDao

@Database(entities = [MessageLogs::class, ReplyLogs::class, AppPackage::class], version = 6)
abstract class MessageLogsDB : RoomDatabase() {

    abstract fun messageLogsDao(): MessageLogsDao?
    abstract fun replyLogsDao(): ReplyLogsDao?
    abstract fun appPackageDao(): AppPackageDao?

    companion object {
        private const val DB_NAME = pro.kuzdowicz.autoreply.constants.Constants.LOGS_DB_NAME
        private var _instance: MessageLogsDB? = null
        @JvmStatic
        @Synchronized
        fun getInstance(context: Context): MessageLogsDB? {
            if (_instance == null) {
                _instance = Room.databaseBuilder(context.applicationContext, MessageLogsDB::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return _instance
        }
    }
}