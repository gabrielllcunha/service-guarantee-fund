package br.com.unipar.serviceguaranteefund;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.text.NumberFormat;
public class Begin extends AppCompatActivity {

    public EditText cpf;
    public EditText birthDate;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);
        cpf = findViewById(R.id.cpf);
        birthDate = findViewById(R.id.birthDate);
    }

    public String confirm (View view) {
        String errorMessage = ("Acesso Negado.");
        User user = new User();
        user.getCpf(cpf.getText().toString());
        user.getBirthDate(birthDate.getText().toString()));
        if (user.getAge(user.getBirthDate()) < 18 ) {
            return errorMessage;
        } else {
            proceed(view, user);
        }
    }

    public void proceed (View view, User user) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(3);
        Intent intent = new Intent(this,Begin.class);
        Bundle SS = new Bundle();
        SS.putString("1º Pagamento:", user.getPayment(user.getBirthDate()));
        SS.putString("2º Pagamento:", user.getPayment(user.getBirthDate()));
        SS.putString("3º Pagamento:", user.getPayment(user.getBirthDate()));
        intent.putExtras(SS);
        startActivity(intent);
    }
}
