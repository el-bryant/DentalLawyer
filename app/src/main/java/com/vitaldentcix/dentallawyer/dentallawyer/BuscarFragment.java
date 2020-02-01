package com.vitaldentcix.dentallawyer.dentallawyer;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarFragment extends Fragment {
    EditText etDniPaciente;
    Button btnBuscar;
    /*ListView listaResultado;*/

    public BuscarFragment() {
        // Required empty public constructor
    }

    /*/código para buscar datos de paciente - I
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        View V = getView();
        super.onActivityCreated(savedInstanceState);
        etDniPaciente = (EditText) V.findViewById(R.id.etDniPaciente);
        listaResultado = (ListView) V.findViewById(R.id.lvLista);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String consulta = "http://192.168.0.10/DentalLawyer/consulta/buscar.php?dni=" + etDniPaciente.getText();
                EnviarRecibirDatos(consulta);
            }
        });
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false);
    }

    public void onBuscar(View view) {

    }

    /*/código para buscar datos de paciente - II
    public void EnviarRecibirDatos(String URL) {
        Toast.makeText(getContext(), ""+URL, Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson","" + ja.length());
                        CargarDatos(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);
    }

    //código para buscar datos de paciente - III
    public void CargarDatos(JSONArray ja) {
        ArrayList<String> lista = new ArrayList<>();
        for(int i = 0; i < ja.length(); i += 4){
            try {
                lista.add(ja.getString(i) + " " + ja.getString(i + 1) + " " + ja.getString(i + 2) + " " + ja.getString(i + 3));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, lista);
        listaResultado.setAdapter(adaptador);
    }*/
}
