package com.example.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ContactListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ContactListAdapter(getSampleContactList());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private ArrayList<Contact> getSampleContactList() {
        // Populate with sample contacts
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "John Doe", "123456789", "john.doe@email.com"));
        contacts.add(new Contact(2, "Jane Smith", "987654321", "jane.smith@email.com"));
        // Add more contacts as needed
        return contacts;
    }
}


