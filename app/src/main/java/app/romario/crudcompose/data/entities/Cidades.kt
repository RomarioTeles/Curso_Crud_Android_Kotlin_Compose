package app.romario.crudcompose.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="cidades")
@Parcelize
data class Cidades(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    var nome_cidade: String? = null,
    var cep_cidade: String? = null,
    var uf_cidade: String? = null
): Parcelable