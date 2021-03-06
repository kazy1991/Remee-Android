package com.github.kazy1991.remee.presenter

import com.github.kazy1991.remee.model.DrawerItem
import com.github.kazy1991.remee.view.MainView


class MainPresenter(val mainView: MainView) {

    fun onCreate() {
        val channelItems = listOf(DrawerItem("@101kaz", 0xffeeeeee.toInt(), '\uf02e'))
        mainView.setupChannelMenu(channelItems)
        val othersItems = listOf(DrawerItem("Settings", 0xffeeeeee.toInt(), '\uf013'))
        mainView.setupOthersMenu(othersItems)
    }
}
