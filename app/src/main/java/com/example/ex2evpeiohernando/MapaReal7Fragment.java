package com.example.ex2evpeiohernando;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.IMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapaReal7Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapaReal7Fragment extends Fragment {

    // todo lo que sea getContext(es de cuando esto era un activity) poner requireActivity() (que es lo mismo) (o requireContext(), creo que da igual pero mejor usa el de requireActivity())

    MyLocationNewOverlay myLocationOverlay;
    MapView map;
    IMapController mapController;

    Button buttonMyPlace;
    Button buttonIruna;
    GeoPoint geoPoint;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MapaReal7Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapaReal7Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapaReal7Fragment newInstance(String param1, String param2) {
        MapaReal7Fragment fragment = new MapaReal7Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment_mapa_real7, container, false);


        Context ctx = requireActivity();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        Configuration.getInstance().setUserAgentValue(requireActivity().getPackageName());

        View view = inflater.inflate(R.layout.fragment_mapa_real7, container, false);

        //buttonMyPlace = view.findViewById(R.id.buttonPosMap);
        buttonIruna = view.findViewById(R.id.buttonIruMap);

        map = view.findViewById(R.id.mapview);
        System.out.println("map is this");
        System.out.println("mapp:"+map);







        ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        setupMap();

//        buttonMyPlace.setOnClickListener(v -> {
//
//            //mapController.setCenter(myLocationOverlay.getMyLocation());
//
//
//        });

        buttonIruna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geoPoint.setCoords(42.34151909489235, -7.86381655047069);
                mapController.setCenter(geoPoint);

            }
        });









        return view;
    }





//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//
//
//
////        Context ctx = requireActivity();
////        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
////        Configuration.getInstance().setUserAgentValue(getPackageName());
//
//        //setContentView(R.layout.activity_mapa_real);
//
//
//
//
//
//        // Verificar permisos de ubicación
////        while (permiso == 0) {
////            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
////                    && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
////                    != PackageManager.PERMISSION_GRANTED) { //AndroidManifest
////
////            } else {
////                setupMap();
////                permiso++;
////            }
////        }
//
//
//
//
//
//
//
//    }



    private void setupMap() {
        System.out.println("SETTTUUUUPPPPPPPPPP");
        System.out.println("mapp value:"+map);


        map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(18.0);
        //Pamplona Catedral: 42.81966767395441, -1.641474900193765



        // centro Elorrieta: 43.28397226338607, -2.9648431750235704
        //default 43.3186569, -3.0219986
        //42.34151909489235, -7.86381655047069
        geoPoint = new GeoPoint(42.34151909489235, -7.86381655047069);
        mapController.setCenter(geoPoint);


        //geoPoint.setCoords(23,14);
        //map =  findViewById(R.id.mapview);
        map.setTileSource(TileSourceFactory.MAPNIK);

// Habilitar el uso de la ubicación del dispositivo

//        GpsMyLocationProvider locationProvider = new GpsMyLocationProvider(requireActivity());
//        MyLocationNewOverlay finalMyLocationOverlay = myLocationOverlay;
//        myLocationOverlay = new MyLocationNewOverlay(locationProvider, map) {
//            @Override
//            public void onLocationChanged(Location location, IMyLocationProvider source) {
//                super.onLocationChanged(location, source);
//
//                if (finalMyLocationOverlay != null && finalMyLocationOverlay.getMyLocation() != null && geoPoint != null) {
//                    // Verificar la distancia al marcador (ajusta según tu necesidad)
//                    finalMyLocationOverlay.getMyLocation().distanceToAsDouble(geoPoint);
//                }
//            }
//        };
//
//        myLocationOverlay.enableMyLocation();
//        myLocationOverlay.enableFollowLocation();
//        map.getOverlays().add(myLocationOverlay);

        map.setUseDataConnection(true);





        //addMarker(geoPoint.getLatitude(), geoPoint.getLongitude(), "ElorrietaCentro");

//        addMarker(42.81194987644076, -1.6495190032766496, "Zitadela"); //42.81194987644076, -1.6495190032766496
//        addMarker(42.814916829082065, -1.641355989783866, "Entzierroaren Monumentua"); //42.814916829082065, -1.641355989783866
//        addMarker(42.81857099363778, -1.6442137836863322, "Iruñeako Udaletxea"); //42.81857099363778, -1.6442137836863322
//        addMarker(42.819753427639775, -1.6415000032762315, "Santa Maria Katedrala"); //42.819753427639775, -1.6415000032762315
//        addMarker(42.820062294417355, -1.6460686807420022, "Nafarroako Museoa"); //42.820062294417355, -1.6460686807420022
        addMarker(42.34151909489235, -7.86381655047069, "Parque de San Lazaro"); //42.34151909489235, -7.86381655047069 (Ourense)






        //map.setUseDataConnection(true);
    }






    public void onResume() {
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map.onResume(); //needed for compass, my location overlays, v6.0.0 and up
    }

    public void onPause(){
        super.onPause();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        map.onPause();  //needed for compass, my location overlays, v6.0.0 and up
    }


    private void addMarker(double latitude, double longitude, String title) {

        org.osmdroid.views.overlay.Marker marker = new org.osmdroid.views.overlay.Marker(map);
        marker.setPosition(new GeoPoint(latitude, longitude));
        marker.setAnchor(org.osmdroid.views.overlay.Marker.ANCHOR_CENTER, org.osmdroid.views.overlay.Marker.ANCHOR_BOTTOM);
        marker.setTitle(title);


        map.getOverlays().add(marker);
    }


    //pop-up
    private void showMessage(String message) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show();
    }




    public boolean onItemLongPress(final int index, final OverlayItem item) {
        if (item.getTitle().equals("Parque de San Lazaro")) {
            System.out.println("has clickado en parke");
        } else if (item.getTitle().equals("Museo Rialia")) {
            //((VistaMapa) getActivity()).mandar(1);
        } else if (item.getTitle().equals("Torre Salazar")) {
            //((VistaMapa) getActivity()).mandar(2);
        } else if (item.getTitle().equals("Campo de Futbol La Florida")) {
            //((VistaMapa) getActivity()).mandar(3);
        }
        return false;
    }




}