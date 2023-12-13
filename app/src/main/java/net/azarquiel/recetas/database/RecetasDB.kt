package net.azarquiel.recetas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.azarquiel.recetas.model.Categoria
import net.azarquiel.recetas.model.Receta

@Database(entities = [Receta::class, Categoria::class], version = 1)
abstract class RecetasDB: RoomDatabase() {
    abstract fun recetaDao(): RecetaDao
    abstract fun categoriaDao(): CategoriaDao
    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE:  RecetasDB? = null

        fun getDatabase(context: Context): RecetasDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecetasDB::class.java,   "recetas.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
