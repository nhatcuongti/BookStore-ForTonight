package com.example.bookstore.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstore.MainBuyerHomepageActivity;
import com.example.bookstore.models.ProductModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManageLogCart  {
    private static String pathFile = "cart.txt";

    public static void writeListProductToFile(ArrayList<ProductModel> listProduct, Context context){

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(context.openFileOutput(pathFile, Context.MODE_PRIVATE));
//            oos = new ObjectOutputStream(fos);

            oos.writeObject(listProduct);

            Toast.makeText(context, "Write to file " + context.getFilesDir() + "/" + pathFile, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeProductToFile(ProductModel product, Context context){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(context.openFileOutput(pathFile, Context.MODE_PRIVATE));
//            oos = new ObjectOutputStream(fos);

            ArrayList<ProductModel> listProduct = getListProductFromFile(context);
            if (listProduct == null)
                listProduct = new ArrayList<>();
            listProduct.add(product);

            oos.writeObject(listProduct);

            Toast.makeText(context, "Write to file " + context.getFilesDir() + "/" + pathFile, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList<ProductModel> getListProductFromFile(Context context){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<ProductModel> listProduct = null;
        Log.d("context1", "Context " + context);
        try {
            ois = new ObjectInputStream(context.openFileInput(pathFile));
//            ois = new ObjectInputStream(fis);
            listProduct = (ArrayList<ProductModel>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return  listProduct;
    }
}
