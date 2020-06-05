package com.zicen.jetpackdemo.utils

import android.content.ComponentName
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import com.zicen.jetpackdemo.navigator.FixFragmentNavigator

/**
 * Author: zhenquan
 * Date: 2020/6/5 15:40
 */
object NavGraphBuilder {
    fun build(activity: FragmentActivity, fragmentManager: FragmentManager, controller: NavController, containerId: Int) {
        val provider = controller.navigatorProvider
        val navGraph = NavGraph(NavGraphNavigator(provider))
        val fixFragmentNavigator = FixFragmentNavigator(activity, fragmentManager, containerId)
        provider.addNavigator(fixFragmentNavigator)
        val activityNavigator = provider.getNavigator(ActivityNavigator::class.java)
        val iterator = AppConfig.getDestConfig().values.iterator()
        while (iterator.hasNext()) {
            val node = iterator.next()
            if (node.isFragment) {
                val destination = fixFragmentNavigator.createDestination()
                destination.id = node.id
                destination.className = node.className
                destination.addDeepLink(node.pageUrl)
                navGraph.addDestination(destination)
            } else {
                val destination = activityNavigator.createDestination()
                destination.id = node.id
                destination.setComponentName(ComponentName(AppGlobals.getApplication().packageName, node.className))
                destination.addDeepLink(node.pageUrl)
                navGraph.addDestination(destination)
            }

            if (node.asStarter) {
                navGraph.startDestination = node.id
            }
        }

        controller.graph = navGraph
    }
}