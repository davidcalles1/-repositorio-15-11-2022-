package com.example.drawerbottomviewapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
//creacion e importacion de variables sobre las vistas creadas
    private lateinit var Toggle: ActionBarDrawerToggle
    private lateinit var dlVista:DrawerLayout
    private lateinit var navVista: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //traemos el objeto
        dlVista= findViewById(R.id.dlVista)
        navVista = findViewById(R.id.nav_Vista)

        Toggle= ActionBarDrawerToggle(this,dlVista,R.string.Abrir_drawer, R.string.cerrar_drawer)


        Toggle?.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navVista.setNavigationItemSelectedListener {
            when(it.itemId)
            {
             R.id.Nav_Inicio->{
                 supportFragmentManager.beginTransaction().apply {
                     replace(R.id.fcv_vista,InicioFragment())
                     commit()
                 }
             }
                R.id.Nav_camara->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fcv_vista,CamaraFragment())
                        commit()
                    }
                }
                R.id.Nav_galeria->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fcv_vista,GaleriaFragment())
                        commit()
                    }
                }
                R.id.Nav_mensaje->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fcv_vista,MensajeFragment())
                        commit()
                    }
                }
            }
            dlVista.closeDrawer(GravityCompat.START)
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(Toggle.onOptionsItemSelected(item))
        {
            return true
        }else
        {
            return super.onOptionsItemSelected(item)
        }

    }
}