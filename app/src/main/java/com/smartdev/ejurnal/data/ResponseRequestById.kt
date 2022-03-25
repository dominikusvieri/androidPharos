package com.smartdev.ejurnal.data

import com.google.gson.annotations.SerializedName

data class ResponseRequestById(

	@field:SerializedName("data")
	val dataRequest: List<DataRequest?>? = null,

	@field:SerializedName("error")
	val error: Error8? = null
)

data class DataRequest(

	@field:SerializedName("attachments")
	val attachments: List<String?>? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("penerbit")
	val penerbit: String? = null,

	@field:SerializedName("abstrak")
	val abstrak: String? = null,

	@field:SerializedName("updated_by")
	val updatedBy: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("tahun_terbit")
	val tahunTerbit: Int? = null,

	@field:SerializedName("pembuat")
	val pembuat: String? = null
)

data class Error8(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)
