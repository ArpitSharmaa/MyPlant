package com.example.myplant

import androidx.core.app.NotificationCompat.Action.SemanticAction
import com.google.gson.annotations.SerializedName
import java.util.IdentityHashMap
//
//data class fetcheddata(
//    val id:Long,
//    @SerializedName("suggestions")
//    val suggestions:List<sugestion>
//)
//data class sugestion(
//
//    val probability:Double,
//    val id:Long,
//    @SerializedName("plant_name")
//    val plantname:String,
//    @SerializedName("plant_details")
//    val details:plantdetails
//)
//data class plantdetails(
//    @SerializedName("common_names")
//    val commonnames:List<String>,
//    val taxonomy :taxanomy,
//    @SerializedName("wiki_description")
//    val wikidescription : description
//
//)
//data class taxanomy(
//    @SerializedName("class")
//    val clas: String,
//    val family : String,
//    val genus : String,
//    val kingdom: String,
//    val order : String,
//    val phylum : String
//
//)
//data class description(
//    val value : String
//)
//data class PlantIdResponse(
//    val id: String,
//    val name: String,
//    val probability: Double,
//    val confidence: String,
//    val common_names: List<String>,
//    val wiki_description: String,
//    val images: List<String>,
//    val sources: List<String>
//)
data class PlantNetResponse(
    @SerializedName("results") val results: List<PlantNetResult>
)

data class PlantNetResult(
    val score:Double,
    @SerializedName("species") val species: PlantNetSpecies
)

data class PlantNetSpecies(
    @SerializedName("commonNames") val commonNames: List<String>,
    @SerializedName("family") val family: family,
    @SerializedName("genus") val genus: genus,
    val scientificName:String

)
data class genus(
    val scientificName :String
)
data class family(
    val scientificName :String
)