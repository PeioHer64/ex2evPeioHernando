package com.example.ex2evpeiohernando;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class InfoFragment1 extends Fragment {

    // Constructor predeterminado del Fragment
    public InfoFragment1() {
        // Constructor vacío requerido para Fragment
    }

    // Método llamado cuando el Fragment se está creando
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el diseño del fragmento desde el archivo XML correspondiente
        // R.layout.fragment_info1 se refiere al archivo XML fragment_info1.xml en la carpeta res/layout
        // El segundo parámetro (container) es el ViewGroup principal en el que se insertará la vista inflada.
        // El tercer parámetro (false) indica si la vista inflada debe adjuntarse al grupo raíz inmediatamente.
        // En este caso, es false porque el grupo raíz se adjuntará más adelante en el ciclo de vida del fragmento.





        return inflater.inflate(R.layout.fragment_info1, container, false);







    }
}
