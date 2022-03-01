package com.smartdev.ejurnal.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseJurnal(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("error")
	val error: Error? = null
) : Parcelable

@Parcelize
data class Error(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("attachments")
	val attachments: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

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
) : Parcelable
