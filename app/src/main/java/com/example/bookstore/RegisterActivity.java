package com.example.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    //button and text
    EditText ho;
    EditText ten;
    EditText address;
    EditText username;
    EditText password;
    EditText confirm_password;
    RadioGroup groupType;
    RadioButton typeUser;
    Button btn;
    //firebase
    private static final String TAG = "Cloud Firestore";
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> user = new HashMap<String, Object>();


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);
        ho = (EditText) findViewById(R.id.firstname);
        ten = (EditText) findViewById(R.id.lastname);
        address = (EditText) findViewById(R.id.address);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.login_password);
        confirm_password = (EditText) findViewById(R.id.re_password);
        groupType = (RadioGroup) findViewById(R.id.group_type);
        btn = (Button) findViewById(R.id.signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get button group
                int selectedGroup = groupType.getCheckedRadioButtonId();
                typeUser = findViewById(selectedGroup);
                //
                String str_ho = ho.getText().toString();
                String str_ten = ten.getText().toString();
                String str_address = address.getText().toString();
                String str_username = username.getText().toString();
                String str_password = password.getText().toString();
                String str_confirm_password = confirm_password.getText().toString();
                String str_typeUser = typeUser.getText().toString();
                //check data
//                boolean duplicateUsername = true;
//                db.collection("users")
//                        .get()
//                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                            public boolean temp;
//                            @Override
//                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                if (task.isSuccessful()) {
//                                    for (QueryDocumentSnapshot document : task.getResult()) {
//                                        if(str_username.equals(document.getId().toString())){
//                                            temp = true;
//                                            break;
//                                        }
//                                        Log.d(TAG, document.getId() + " => " + document.getData());
//                                    }
//
//                                } else {
//                                    Log.w(TAG, "Error getting documents.", task.getException());
//                                }
//                            }
//                            duplicateUsername = temp;
//                        });

                if(TextUtils.isEmpty(str_ho) || TextUtils.isEmpty(str_ten)
                        || TextUtils.isEmpty(str_address) || TextUtils.isEmpty(str_username)
                        || TextUtils.isEmpty(str_password) || TextUtils.isEmpty(str_confirm_password)){
                    Toast.makeText(getApplicationContext(), "Bạn cần phải điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else if(!str_password.equals(str_confirm_password)){
                    Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                }
                else {
                    System.out.println(str_ho);
                    System.out.println(str_ten);
                    System.out.println(str_address);
                    System.out.println(str_username);
                    System.out.println(str_password);
                    System.out.println(str_confirm_password);
                    System.out.println(str_typeUser);

                    //write on firebase
                    user.put("firstname", str_ho);
                    user.put("lastname", str_ten);
                    user.put("address", str_address);
                    user.put("username", str_username);
                    user.put("password", str_password);
                    user.put("role", str_typeUser);

                    db.collection("users")
                            .document(str_username)
                            .set(user)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
