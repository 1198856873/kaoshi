package com.example.lenovo.h1705a_mvp2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.example.lenovo.h1705a_mvp2.overlay.DrivingRouteOverlay;
import com.example.lenovo.h1705a_mvp2.util.ToastUtil;


/**
 * Created by 齐天大圣 on 2017/12/12.
 */
public class MainActivityThree extends AppCompatActivity implements View.OnClickListener, RouteSearch.OnRouteSearchListener, GeocodeSearch.OnGeocodeSearchListener {
    MapView mMapView = null;
    AMap aMap = null;
    private EditText editText;
    private Button button;
    private MapView mapView;
    private RouteSearch routeSearch;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitythree_main);
        initData();
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
        //初始化地图控制器对象

        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        Intent intent = getIntent();
    //    String stringExtra = intent.getStringExtra("132213");

        string = editText.getText().toString();
    }

    private void initData() {
        editText = (EditText) findViewById(R.id.et_end);
        button = (Button) findViewById(R.id.btn_search);
        button.setOnClickListener(this);
        mapView = (MapView) findViewById(R.id.map);
    }

    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {
        aMap.clear();
        if (i == AMapException.CODE_AMAP_SUCCESS) {
            if (driveRouteResult != null && driveRouteResult.getPaths() != null) {
                if (driveRouteResult.getPaths().size() > 0) {
                    DriveRouteResult mDriveRouteResult = driveRouteResult;
                    final DrivePath drivePath = mDriveRouteResult.getPaths()
                            .get(0);
                    DrivingRouteOverlay drivingRouteOverlay = new DrivingRouteOverlay(
                            MainActivityThree.this, aMap, drivePath,
                            mDriveRouteResult.getStartPos(),
                            mDriveRouteResult.getTargetPos(), null);
                    drivingRouteOverlay.setNodeIconVisibility(false);//设置节点marker是否显示
                    drivingRouteOverlay.setIsColorfulline(true);//是否用颜色展示交通拥堵情况，默认true
                    drivingRouteOverlay.removeFromMap();
                    drivingRouteOverlay.addToMap();
                    drivingRouteOverlay.zoomToSpan();
                } else if (driveRouteResult != null && driveRouteResult.getPaths() == null) {
                    ToastUtil.show(MainActivityThree.this, R.string.app_name);
                }
            } else {
                ToastUtil.show(MainActivityThree.this, R.string.app_name);
            }
        } else {
            ToastUtil.showerror(this.getApplicationContext(), i);
        }
    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

    }

    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

    }

    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {

    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        GeocodeAddress geocodeAddress = geocodeResult.getGeocodeAddressList().get(0);
        //经度
        double longitude = geocodeAddress.getLatLonPoint().getLongitude();
        //纬度
        double latitude = geocodeAddress.getLatLonPoint().getLatitude();

        Log.d("MainActivity", longitude + "..." + latitude);
        //驾车路线规划
        routeSearch = new RouteSearch(MainActivityThree.this);
        routeSearch.setRouteSearchListener(MainActivityThree.this);
        // fromAndTo包含路径规划的起点和终点，drivingMode表示驾车模式
        // 第三个参数表示途经点（最多支持16个），第四个参数表示避让区域（最多支持32个），第五个参数表示避让道路
        RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(new LatLonPoint(40.1767200000, 116.16502000000), new LatLonPoint(latitude, longitude));
        RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, RouteSearch.BUS_DEFAULT, null, null, "");
        routeSearch.calculateDriveRouteAsyn(query);
    }

    @Override
    public void onClick(View view) {
        GeocodeSearch geocodeSearch = new GeocodeSearch(MainActivityThree.this);
        geocodeSearch.setOnGeocodeSearchListener(MainActivityThree.this);
        //城市编码
        GeocodeQuery query = new GeocodeQuery(editText.getText().toString(), "010");
        geocodeSearch.getFromLocationNameAsyn(query);


    }
}
