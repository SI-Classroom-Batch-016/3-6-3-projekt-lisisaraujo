//import com.mapbox.api.geocoding.v5.models.GeocodingResponse
//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Path
//import retrofit2.http.Query
//
//interface MapboxGeocodingService {
//    @GET("geocoding/v5/mapbox.places/{lng},{lat}.json")
//    fun getReverseGeocoding(
//        @Path("lng") lng: Double,
//        @Path("lat") lat: Double,
//        @Query("access_token") accessToken: String
//    ): Call<GeocodingResponse>
//}
