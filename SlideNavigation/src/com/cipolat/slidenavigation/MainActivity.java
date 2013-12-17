package com.cipolat.slidenavigation;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {
	    private String[] titulos;
	    private DrawerLayout NavDrawerLayout;
	    private ListView NavList;
        private ArrayList<Item_objct> NavItms;
        private TypedArray NavIcons;	
	    NavigationAdapter NavAdapter;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);		
			//Drawer Layout
			NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			//Lista
	        NavList = (ListView) findViewById(R.id.lista);
	        //Declaramos el header el caul sera el layout de header.xml
	        View header = getLayoutInflater().inflate(R.layout.header, null);
	        //Establecemos header
	        NavList.addHeaderView(header);
			//Tomamos listado  de imgs desde drawable
	        NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);			
			//Tomamos listado  de titulos desde el string-array de los recursos @string/nav_options
	        titulos = getResources().getStringArray(R.array.nav_options);
	        //Listado de titulos de barra de navegacion
	        NavItms = new ArrayList<Item_objct>();
	        //Agregamos objetos Item_objct al array
	        //Perfil	      
	        NavItms.add(new Item_objct(titulos[0], NavIcons.getResourceId(0, -1)));
	        //Favoritos
	        NavItms.add(new Item_objct(titulos[1], NavIcons.getResourceId(1, -1)));
	        //Eventos
	        NavItms.add(new Item_objct(titulos[2], NavIcons.getResourceId(2, -1)));
	        //Lugares
	        NavItms.add(new Item_objct(titulos[3], NavIcons.getResourceId(3, -1)));
	        //Etiquetas
	        NavItms.add(new Item_objct(titulos[4], NavIcons.getResourceId(4, -1)));
	        //Configuracion
	        NavItms.add(new Item_objct(titulos[5], NavIcons.getResourceId(5, -1)));
	        //Share
	        NavItms.add(new Item_objct(titulos[6], NavIcons.getResourceId(6, -1)));	      
	        //Declaramos y seteamos nuestrp adaptador al cual le pasamos el array con los titulos	       
	        NavAdapter= new NavigationAdapter(this,NavItms);
	        NavList.setAdapter(NavAdapter);	
	        //Siempre vamos a mostrar el mismo titulo
	       	              
	}

}
