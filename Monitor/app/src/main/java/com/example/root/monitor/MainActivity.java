package com.example.root.monitor;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.example.root.monitor.R.id.lista;

public class MainActivity extends Activity {
    public ListView listview;
    public ArrayAdapter adapter;
    public List<String> ListElementsArrayList;

    String[] ListElements = new String[] {""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.lista);
        ListElementsArrayList = new ArrayList<>
                (Arrays.asList(ListElements));

        adapter = new ArrayAdapter<>
                (this, R.layout.list_item, R.id.textView, ListElementsArrayList);
        listview.setAdapter(adapter);
        socket();

    }


    public void socket() {
        final boolean status = true;
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    ServerSocket soc = new ServerSocket(10000);
                    while(status) {
                        Socket cliente = soc.accept();
                        Scanner entrada = new Scanner(cliente.getInputStream());
                        Log.d("socket", "run: ");
                        Log.d("socket", "cliente" + cliente.getInetAddress());
                        String h = entrada.nextLine();
                        String typeMensagem[] = h.split(":");
                        String Mensagem = typeMensagem[1];
                        Log.d("Log", typeMensagem[0]);
                        Integer tm;
                        tm = (Integer.parseInt(typeMensagem[0])) ;


                        if (tm == 1) {
                            Log.d("Log","Enviando mensagem do Servidor");
                            setMsg(Mensagem);
                        } else if (tm == 0){
                            removeStop(Mensagem);
                            Log.d("Log Erro", "Enviando mensagem do Celular");
                        }
                    }

                } catch (UnknownHostException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }

    public void setMsg(final String msgRecv) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ListElementsArrayList.add(msgRecv);
                TextView te = findViewById(R.id.textView);
                te.setText(msgRecv);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void removeStop(final String remove) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i <ListElementsArrayList.size(); i++) {

                    if(ListElementsArrayList.get(i).equals(remove)) {
                        Log.d("Log", remove);
                        Log.d("get i", ListElementsArrayList.get(i));
                        ListElementsArrayList.remove(i);
                    }
                }

                adapter.notifyDataSetChanged();            }
        });
    }

}
