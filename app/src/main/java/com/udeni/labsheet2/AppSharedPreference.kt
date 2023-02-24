package com.udeni.labsheet2

import android.content.Context

class AppSharedPreference(context: Context) {
    private val appSharedPreference=context.getSharedPreferences(R.string.shared_pref_name.toString(), Context.MODE_PRIVATE)
    private val editor=appSharedPreference.edit()

    fun saveLikes(likeCount:Int)=editor.putInt(R.string.likecount.toString(),likeCount).commit()
    fun getLikes():Int=appSharedPreference.getInt(R.string.likecount.toString(),0)

    fun saveDislikes(likeCount:Int)=editor.putInt(R.string.dislikecount.toString(),likeCount).commit()
    fun getDislikes():Int=appSharedPreference.getInt(R.string.dislikecount.toString(),0)
}