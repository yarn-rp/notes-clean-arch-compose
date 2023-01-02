import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Database table name for the notes.
 */
const val NOTE_TABLE_NAME = "notes"
/**
 * Domain representation of a note.
 * @param id The unique identifier of the note.
 * @param title The title of the note.
 * @param content The content of the note.
 * @param color The color of the note.
 * @param timestamp The timestamp of the note.
 */
@Entity(tableName = NOTE_TABLE_NAME)
class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String,
    val color: Int,
    val timestamp: Long
)
