package autenticacaousuario.app.com.autenticaousurio;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseAuth.signOut();


        firebaseAuth.signInWithEmailAndPassword("email@email.com", "Senha123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("Login ", "Sucesso ao conectar");
                }
                else {
                    Log.i("Login ", "Falha ao conectar");
                }
            }
        });


        if (firebaseAuth.getCurrentUser() != null){
            Log.i("Sessao", "usuário logado "+);
        }
        else {
            Log.i("Sessao", "usuário não logado");
        }

/*        firebaseAuth.createUserWithEmailAndPassword("email@email.com", "Senha123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Log.i("Create User ", "Sucesso ao cadastrar usuário");
                }
                else {
                    Log.i("Create User ", "Falha no cadasdtro do usuário");
                }

            }
        });*/
    }
}
