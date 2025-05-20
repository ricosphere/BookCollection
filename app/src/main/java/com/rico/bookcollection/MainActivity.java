package com.rico.bookcollection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.rico.bookcollection.BookAdapter;
import com.rico.bookcollection.Book;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnViewBooks;
    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewBooks = findViewById(R.id.btnViewBooks);
        recyclerView = findViewById(R.id.recyclerViewBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookList = new ArrayList<>();
        adapter = new BookAdapter(this, bookList);
        recyclerView.setAdapter(adapter);

        btnViewBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadBooks();
                btnViewBooks.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void loadBooks() {
        bookList.add(new Book("They Both Die at the End", "They Both Die at the End adalah kisah tentang dua remaja, Mateo dan Rufus, yang tahu mereka akan mati hari itu. Mereka bertemu lewat aplikasi dan memutuskan menghabiskan hari terakhir bersama, membentuk ikatan yang mendalam meski waktu mereka terbatas.", R.drawable.sample_book));
        bookList.add(new Book("The First to Die at the End", "The First to Die at the End adalah prekuel dari They Both Die at the End. Ceritanya tentang Orion dan Valentino yang bertemu sehari sebelum layanan Death-Cast resmi diluncurkan. Ketika salah satu dari mereka mendapat kabar bahwa hari itu adalah hari terakhirnya, mereka memutuskan untuk menghabiskannya bersama. Novel ini mengangkat tema cinta, takdir, dan makna hidup dalam waktu yang singkat.", R.drawable.sample_book2));
        // Tambahkan sesuai kebutuhan gev
        adapter.notifyDataSetChanged();
    }
}
