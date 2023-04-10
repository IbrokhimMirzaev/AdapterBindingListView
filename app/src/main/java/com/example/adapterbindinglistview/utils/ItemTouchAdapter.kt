package com.example.adapterbindinglistview.utils

interface ItemTouchAdapter {

    fun onItemMove(fromPosition: Int, toPosition: Int)

    fun onItemDismiss(position: Int)
}