package com.kakapo.network.model.response


import com.google.gson.annotations.SerializedName



data class PortfolioResponse(
    @SerializedName("data")
    var data: List<Data> = emptyList(),
    @SerializedName("type")
    var type: String? = null
) {
    data class Data(
        @SerializedName("data")
        var `data`: List<Data> = emptyList(),
        @SerializedName("label")
        var label: String? = null,
        @SerializedName("percentage")
        var percentage: String? = null
    ) {
        data class Data(
            @SerializedName("nominal")
            var nominal: Int? = null,
            @SerializedName("trx_date")
            var trxDate: String? = null
        )
    }
}