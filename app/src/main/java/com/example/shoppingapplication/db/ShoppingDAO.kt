import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppingapplication.model.ShoppingItem


//Interface because we would like to access numerous classes here
//DAO (Data Access Objects) for defining interactions with database
@Dao
interface ShoppingDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)
    @Delete
    suspend fun delete(item: ShoppingItem)
    @Query("SELECT * from localshopdatabase")
    fun getAllShoppingItems():LiveData<List<ShoppingItem>>

}