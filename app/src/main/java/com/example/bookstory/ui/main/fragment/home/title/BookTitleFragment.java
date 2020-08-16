package com.example.bookstory.ui.main.fragment.home.title;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.bookstory.R;
import com.example.bookstory.databinding.FragmentBookTitleBinding;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.vo.Book;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookTitleFragment extends BaseFragment {
    private Book book;

    @Inject
    ViewModelProvider.Factory factory;
    private BookTitleViewModel viewModel;

    public BookTitleFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        book = getArguments().getParcelable("book");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBookTitleBinding binding = FragmentBookTitleBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity(), factory).get(BookTitleViewModel.class);
        viewModel.setBook(book);
        Log.e("Book", book.toString());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.executePendingBindings();
        binding.btGotoChapter.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable("book", book);
            Navigation.findNavController(v).navigate(R.id.action_bookTitleFragment_to_readBookFragment, bundle);
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    protected String setTitle() {
        return book.getName();
    }
}
