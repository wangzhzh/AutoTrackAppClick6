/*
 * Created by wangzhuozhou on 2015/08/12.
 * Copyright 2015－2019 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sensorsdata.analytics.android.plugin

import jdk.internal.org.objectweb.asm.Opcodes

class SensorsAnalyticsHookConfig {
    public static final String SENSORS_ANALYTICS_API = "com/sensorsdata/analytics/android/sdk/SensorsDataAutoTrackHelper"

    /**
     * android.gradle 3.2.1 版本中，针对 Lambda 表达式处理
     */

    public final static HashMap<String, SensorsAnalyticsMethodCell> LAMBDA_METHODS = new HashMap<>()
    static {
        SensorsAnalyticsMethodCell onClick = new SensorsAnalyticsMethodCell(
                'onClick',
                '(Landroid/view/View;)V',
                'Landroid/view/View$OnClickListener;',
                'trackViewOnClick',
                '(Landroid/view/View;)V',
                1, 1,
                [Opcodes.ALOAD])
        LAMBDA_METHODS.put(onClick.parent + onClick.name + onClick.desc, onClick)
        SensorsAnalyticsMethodCell onCheckedChanged = new SensorsAnalyticsMethodCell(
                'onCheckedChanged',
                '(Landroid/widget/CompoundButton;Z)V',
                'Landroid/widget/CompoundButton$OnCheckedChangeListener;',
                'trackViewOnClick',
                '(Landroid/view/View;)V',
                1, 1,
                [Opcodes.ALOAD])
        LAMBDA_METHODS.put(onCheckedChanged.parent + onCheckedChanged.name + onCheckedChanged.desc, onCheckedChanged)

        SensorsAnalyticsMethodCell onRatingChanged = new SensorsAnalyticsMethodCell(
                'onRatingChanged',
                '(Landroid/widget/RatingBar;FZ)V',
                'Landroid/widget/RatingBar$OnRatingBarChangeListener;',
                'trackViewOnClick',
                '(Landroid/view/View;)V',
                1, 1,
                [Opcodes.ALOAD])
        LAMBDA_METHODS.put(onRatingChanged.parent + onRatingChanged.name + onRatingChanged.desc, onRatingChanged)


        SensorsAnalyticsMethodCell onStopTrackingTouch = new SensorsAnalyticsMethodCell(
                'onStopTrackingTouch',
                '(Landroid/widget/SeekBar;)V',
                'Landroid/widget/SeekBar$OnSeekBarChangeListener;',
                'trackViewOnClick',
                '(Landroid/view/View;)V',
                1, 1,
                [Opcodes.ALOAD])
        LAMBDA_METHODS.put(onStopTrackingTouch.parent + onStopTrackingTouch.name + onStopTrackingTouch.desc, onStopTrackingTouch)

        SensorsAnalyticsMethodCell onCheckedChanged1 = new SensorsAnalyticsMethodCell(
                'onCheckedChanged',
                '(Landroid/widget/RadioGroup;I)V',
                'Landroid/widget/RadioGroup$OnCheckedChangeListener;',
                'trackRadioGroup',
                '(Landroid/widget/RadioGroup;I)V',
                1, 2,
                [Opcodes.ALOAD, Opcodes.ILOAD])
        LAMBDA_METHODS.put(onCheckedChanged1.parent + onCheckedChanged1.name + onCheckedChanged1.desc, onCheckedChanged1)

        SensorsAnalyticsMethodCell onClick1 = new SensorsAnalyticsMethodCell(
                'onClick',
                '(Landroid/content/DialogInterface;I)V',
                'Landroid/content/DialogInterface$OnClickListener;',
                'trackDialog',
                '(Landroid/content/DialogInterface;I)V',
                1, 2,
                [Opcodes.ALOAD, Opcodes.ILOAD])
        LAMBDA_METHODS.put(onClick1.parent + onClick1.name + onClick1.desc, onClick1)

        SensorsAnalyticsMethodCell onItemClick = new SensorsAnalyticsMethodCell(
                'onItemClick',
                '(Landroid/widget/AdapterView;Landroid/view/View;IJ)V',
                'Landroid/widget/AdapterView$OnItemClickListener;',
                'trackListView',
                '(Landroid/widget/AdapterView;Landroid/view/View;I)V',
                1, 3,
                [Opcodes.ALOAD, Opcodes.ALOAD, Opcodes.ILOAD])
        LAMBDA_METHODS.put(onItemClick.parent + onItemClick.name + onItemClick.desc, onItemClick)

        SensorsAnalyticsMethodCell onGroupClick = new SensorsAnalyticsMethodCell(
                'onGroupClick',
                '(Landroid/widget/ExpandableListView;Landroid/view/View;IJ)Z',
                'Landroid/widget/ExpandableListView$OnGroupClickListener;',
                'trackExpandableListViewOnGroupClick',
                '(Landroid/widget/ExpandableListView;Landroid/view/View;I)V',
                1, 3,
                [Opcodes.ALOAD, Opcodes.ALOAD, Opcodes.ILOAD])
        LAMBDA_METHODS.put(onGroupClick.parent + onGroupClick.name + onGroupClick.desc, onGroupClick)

        SensorsAnalyticsMethodCell onChildClick = new SensorsAnalyticsMethodCell(
                'onChildClick',
                '(Landroid/widget/ExpandableListView;Landroid/view/View;IIJ)Z',
                'Landroid/widget/ExpandableListView$OnChildClickListener;',
                'trackExpandableListViewOnChildClick',
                '(Landroid/widget/ExpandableListView;Landroid/view/View;II)V',
                1, 4,
                [Opcodes.ALOAD, Opcodes.ALOAD, Opcodes.ILOAD, Opcodes.ILOAD])
        LAMBDA_METHODS.put(onChildClick.parent + onChildClick.name + onChildClick.desc, onChildClick)

        SensorsAnalyticsMethodCell onTabChanged = new SensorsAnalyticsMethodCell(
                'onTabChanged',
                '(Ljava/lang/String;)V',
                'Landroid/widget/TabHost$OnTabChangeListener;',
                'trackTabHost',
                '(Ljava/lang/String;)V',
                1, 1,
                [Opcodes.ALOAD])
        LAMBDA_METHODS.put(onTabChanged.parent + onTabChanged.name + onTabChanged.desc, onTabChanged)

        SensorsAnalyticsMethodCell onNavigationItemSelected = new SensorsAnalyticsMethodCell(
                'onNavigationItemSelected',
                '(Landroid/view/MenuItem;)Z',
                'Landroid/support/design/widget/NavigationView$OnNavigationItemSelectedListener;',
                'trackMenuItem',
                '(Landroid/view/MenuItem;)V',
                1, 1,
                [Opcodes.ALOAD])
        LAMBDA_METHODS.put(onNavigationItemSelected.parent + onNavigationItemSelected.name + onNavigationItemSelected.desc, onNavigationItemSelected)

        // Todo: 扩展
    }
}