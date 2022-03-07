package com.smartdev.ejurnal.data

import com.google.gson.annotations.SerializedName

data class ResponsePostJurnal(

	@field:SerializedName("data")
	val data: List<DataItemPost?>? = null,

	@field:SerializedName("error")
	val error: Error2? = null
)

data class Error2(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataItemPost(

	@field:SerializedName("topik")
	val topik: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null
)

data class TransferMethod(
	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("topik")
	val topik: String? = null
)
