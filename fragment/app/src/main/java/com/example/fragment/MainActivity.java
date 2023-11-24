package com.example.fragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ContactListFragment.OnContactSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            loadContactListFragment();
        }
    }

    @Override
    public void onContactSelected(Contact contact) {
        loadContactDetailFragment(contact);
    }

    private void loadContactListFragment() {
        ContactListFragment contactListFragment = new ContactListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, contactListFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void loadContactDetailFragment(Contact contact) {
        ContactDetailFragment contactDetailFragment = ContactDetailFragment.newInstance(contact);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, contactDetailFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
