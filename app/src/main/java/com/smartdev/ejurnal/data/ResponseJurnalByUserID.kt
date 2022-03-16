package com.smartdev.ejurnal.data

import com.google.gson.annotations.SerializedName

data class ResponseJurnalByUserID(

	@field:SerializedName("data")
	val dataReqId: List<DataJurnal?>? = null,

	@field:SerializedName("error")
	val error: Error4? = null
)

data class DataJurnal(

	@field:SerializedName("topik")
	val topik: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("last_update")
	val lastUpdate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null
)

data class Error4(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)
