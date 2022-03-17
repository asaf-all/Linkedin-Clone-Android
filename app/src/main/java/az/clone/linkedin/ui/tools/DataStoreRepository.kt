package az.clone.linkedin.ui.tools

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


val Context._dataStore by preferencesDataStore(name = "app_data_store")

class DataStoreRepository @Inject constructor(
    @ApplicationContext context: Context
) {

    private val dataStore = context._dataStore

    private object PreferencesKeys {
        const val SYNC_STATE = "sync_local_db_state"
    }


}