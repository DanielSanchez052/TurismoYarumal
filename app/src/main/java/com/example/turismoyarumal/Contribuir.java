package com.example.turismoyarumal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import static android.widget.Toast.makeText;

public class Contribuir extends AppCompatActivity {
    EditText nombreLugar, descripcionLugar, contactoLugar, direccionLugar;
    ImageView imagenLugar;
    Button guardar;
    Spinner vTipoLugar;
    FirebaseStorage storage ;
    StorageReference storageRef;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String tipoLugar;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribuir);

        nombreLugar = findViewById(R.id.nombreLugar);
        descripcionLugar = findViewById(R.id.descripcionLugar);
        contactoLugar = findViewById(R.id.contactoLugar);
        direccionLugar = findViewById(R.id.direccionLugar);
        imagenLugar = findViewById(R.id.imagenLugar);
        vTipoLugar = findViewById(R.id.tipoLugar);
        guardar = findViewById(R.id.guardarLugar);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        vTipoLugar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                tipoLugar = adapterView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio
            }
        });

        imagenLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> lugarTuristico = new HashMap<>();
                String nombre=nombreLugar.getText().toString();
                String descripcion=descripcionLugar.getText().toString();
                String contacto=contactoLugar.getText().toString();
                String direccion=direccionLugar.getText().toString();
                if(!nombre.isEmpty() && !descripcion.isEmpty() && !direccion.isEmpty() && imageUri != null){
                    lugarTuristico.put("TipoLugar",tipoLugar);
                    lugarTuristico.put("nombre",nombre);
                    lugarTuristico.put("descripcion",descripcion);
                    lugarTuristico.put("contacto",contacto);
                    lugarTuristico.put("direccion",direccion);
                    lugarTuristico.put("imagen",imageUri);
                    try {
                        uploadLugar(lugarTuristico);
                    } catch (InterruptedException e) {
                        Toast.makeText(Contribuir.this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Contribuir.this,"Debes llenar los campos nombre,direccion,descripcion y seleccionar una imagen",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case(R.id.opcion1):
                cambiarIdioma("en");
                Intent intent1 = new Intent(Contribuir.this, Contribuir.class);
                startActivity(intent1);
                break;
            case(R.id.opcion2):
                cambiarIdioma("es");
                Intent intent2 = new Intent(Contribuir.this, Contribuir.class);
                startActivity(intent2);
                break;
            case (R.id.opcion3):
                Intent intent3 = new Intent(Contribuir.this,Contribuir.class);
                startActivity(intent3);
                break;
            case(R.id.opcion4):
                Intent intent4 = new Intent(Contribuir.this,AcercaDe.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imagenLugar.setImageURI(imageUri);
            //uploadImage();
        }
    }

    private void uploadLugar(final Map<String,Object> lugarTuristico) throws InterruptedException {
        final StorageReference ref = storageRef.child("images/"+ UUID.randomUUID().toString());

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ref.putFile((Uri) lugarTuristico.get("imagen")).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Uri downloadUri = uri;
                            String download_url = uri.toString();
                            lugarTuristico.put("imagen",download_url);
                            db.collection("LugaresTuristicos")
                                    .add(lugarTuristico)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            nombreLugar.setText("");
                                            descripcionLugar.setText("");
                                            contactoLugar.setText("");
                                            direccionLugar.setText("");
                                            imagenLugar.setImageResource(R.drawable.camera);
                                            makeText(Contribuir.this,"Se guardo correctamente",Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            makeText(Contribuir.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    });
                    makeText(Contribuir.this, "Uploaded", Toast.LENGTH_LONG).show();
                }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        makeText(Contribuir.this, "Failed "+e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("UploadError",e.getMessage());
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(
                            UploadTask.TaskSnapshot taskSnapshot)
                    {
                        double progress = (100.0 * taskSnapshot.getBytesTransferred()/ taskSnapshot.getTotalByteCount());
                        progressDialog.setMessage("Uploaded "+ (int)progress + "%");
                    }
                });
    }

    public void cambiarIdioma(String lenguaje){
        Locale idioma = new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configuracionTelefono = getResources().getConfiguration();
        configuracionTelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
}