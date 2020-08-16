package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentBookTitleBindingImpl extends FragmentBookTitleBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.bt_gotoChapter, 10);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final android.widget.TextView mboundView8;
    @NonNull
    private final android.widget.TextView mboundView9;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentBookTitleBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentBookTitleBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[10]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.ViewModel == variableId) {
            setViewModel((com.example.bookstory.ui.main.fragment.home.title.BookTitleViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.bookstory.ui.main.fragment.home.title.BookTitleViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelBookLiveData((androidx.lifecycle.MutableLiveData<com.example.bookstory.vo.Book>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelBookLiveData(androidx.lifecycle.MutableLiveData<com.example.bookstory.vo.Book> ViewModelBookLiveData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String javaLangStringChapterViewModelBookLiveDataGetChapters = null;
        java.lang.String viewModelBookLiveDataGetImgUrl = null;
        java.util.List<com.example.bookstory.vo.BookType> viewModelBookLiveDataGetBookType = null;
        com.example.bookstory.ui.main.fragment.home.title.BookTitleViewModel viewModel = mViewModel;
        java.lang.String viewModelBookLiveDataGetDateUpdate = null;
        java.lang.String convertDateTimeConvertDateTimeViewModelBookLiveDataGetDateUpdate = null;
        java.lang.String javaLangStringDesctiptionViewModelBookLiveDataGetDes = null;
        java.lang.String javaLangStringTraslatorViewModelBookLiveDataGetTranslators = null;
        java.lang.String viewModelBookLiveDataGetDes = null;
        int viewModelBookLiveDataGetChapters = 0;
        com.example.bookstory.vo.Book viewModelBookLiveDataGetValue = null;
        java.lang.String viewModelBookLiveDataGetTranslators = null;
        java.lang.String javaLangStringCagerotyViewModelBookLiveDataGetBookTypeToString = null;
        java.lang.String viewModelBookLiveDataGetBookTypeToString = null;
        java.lang.String javaLangStringDateCreatedConvertDateTimeConvertDateTimeViewModelBookLiveDataGetDateStart = null;
        java.lang.String convertDateTimeConvertDateTimeViewModelBookLiveDataGetDateStart = null;
        java.lang.String viewModelBookLiveDataGetAuthor = null;
        java.lang.String viewModelBookLiveDataGetDateStart = null;
        androidx.lifecycle.MutableLiveData<com.example.bookstory.vo.Book> viewModelBookLiveData = null;
        java.lang.String viewModelBookLiveDataGetName = null;
        java.lang.String javaLangStringDateUpdateConvertDateTimeConvertDateTimeViewModelBookLiveDataGetDateUpdate = null;
        java.lang.String javaLangStringAuthorViewModelBookLiveDataGetAuthor = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read ViewModel.bookLiveData
                    viewModelBookLiveData = viewModel.bookLiveData;
                }
                updateLiveDataRegistration(0, viewModelBookLiveData);


                if (viewModelBookLiveData != null) {
                    // read ViewModel.bookLiveData.getValue()
                    viewModelBookLiveDataGetValue = viewModelBookLiveData.getValue();
                }


                if (viewModelBookLiveDataGetValue != null) {
                    // read ViewModel.bookLiveData.getValue().getImgUrl()
                    viewModelBookLiveDataGetImgUrl = viewModelBookLiveDataGetValue.getImgUrl();
                    // read ViewModel.bookLiveData.getValue().getBookType()
                    viewModelBookLiveDataGetBookType = viewModelBookLiveDataGetValue.getBookType();
                    // read ViewModel.bookLiveData.getValue().getDateUpdate()
                    viewModelBookLiveDataGetDateUpdate = viewModelBookLiveDataGetValue.getDateUpdate();
                    // read ViewModel.bookLiveData.getValue().getDes()
                    viewModelBookLiveDataGetDes = viewModelBookLiveDataGetValue.getDes();
                    // read ViewModel.bookLiveData.getValue().getChapters()
                    viewModelBookLiveDataGetChapters = viewModelBookLiveDataGetValue.getChapters();
                    // read ViewModel.bookLiveData.getValue().getTranslators()
                    viewModelBookLiveDataGetTranslators = viewModelBookLiveDataGetValue.getTranslators();
                    // read ViewModel.bookLiveData.getValue().getAuthor()
                    viewModelBookLiveDataGetAuthor = viewModelBookLiveDataGetValue.getAuthor();
                    // read ViewModel.bookLiveData.getValue().getDateStart()
                    viewModelBookLiveDataGetDateStart = viewModelBookLiveDataGetValue.getDateStart();
                    // read ViewModel.bookLiveData.getValue().getName()
                    viewModelBookLiveDataGetName = viewModelBookLiveDataGetValue.getName();
                }


                if (viewModelBookLiveDataGetBookType != null) {
                    // read ViewModel.bookLiveData.getValue().getBookType().toString()
                    viewModelBookLiveDataGetBookTypeToString = viewModelBookLiveDataGetBookType.toString();
                }
                // read ConvertDateTime.convertDateTime(ViewModel.bookLiveData.getValue().getDateUpdate())
                convertDateTimeConvertDateTimeViewModelBookLiveDataGetDateUpdate = com.example.bookstory.util.ConvertDateTime.convertDateTime(viewModelBookLiveDataGetDateUpdate);
                // read ("Desctiption: ") + (ViewModel.bookLiveData.getValue().getDes())
                javaLangStringDesctiptionViewModelBookLiveDataGetDes = ("Desctiption: ") + (viewModelBookLiveDataGetDes);
                // read ("Chapter:") + (ViewModel.bookLiveData.getValue().getChapters())
                javaLangStringChapterViewModelBookLiveDataGetChapters = ("Chapter:") + (viewModelBookLiveDataGetChapters);
                // read ("Traslator: ") + (ViewModel.bookLiveData.getValue().getTranslators())
                javaLangStringTraslatorViewModelBookLiveDataGetTranslators = ("Traslator: ") + (viewModelBookLiveDataGetTranslators);
                // read ("Author:") + (ViewModel.bookLiveData.getValue().getAuthor())
                javaLangStringAuthorViewModelBookLiveDataGetAuthor = ("Author:") + (viewModelBookLiveDataGetAuthor);
                // read ConvertDateTime.convertDateTime(ViewModel.bookLiveData.getValue().getDateStart())
                convertDateTimeConvertDateTimeViewModelBookLiveDataGetDateStart = com.example.bookstory.util.ConvertDateTime.convertDateTime(viewModelBookLiveDataGetDateStart);


                // read ("Cageroty: ") + (ViewModel.bookLiveData.getValue().getBookType().toString())
                javaLangStringCagerotyViewModelBookLiveDataGetBookTypeToString = ("Cageroty: ") + (viewModelBookLiveDataGetBookTypeToString);
                // read ("DateUpdate: ") + (ConvertDateTime.convertDateTime(ViewModel.bookLiveData.getValue().getDateUpdate()))
                javaLangStringDateUpdateConvertDateTimeConvertDateTimeViewModelBookLiveDataGetDateUpdate = ("DateUpdate: ") + (convertDateTimeConvertDateTimeViewModelBookLiveDataGetDateUpdate);
                // read ("DateCreated: ") + (ConvertDateTime.convertDateTime(ViewModel.bookLiveData.getValue().getDateStart()))
                javaLangStringDateCreatedConvertDateTimeConvertDateTimeViewModelBookLiveDataGetDateStart = ("DateCreated: ") + (convertDateTimeConvertDateTimeViewModelBookLiveDataGetDateStart);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.example.bookstory.util.ImgHandler.setImgUrl(this.mboundView1, viewModelBookLiveDataGetImgUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, viewModelBookLiveDataGetName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, javaLangStringAuthorViewModelBookLiveDataGetAuthor);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, javaLangStringChapterViewModelBookLiveDataGetChapters);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, javaLangStringCagerotyViewModelBookLiveDataGetBookTypeToString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, javaLangStringDateCreatedConvertDateTimeConvertDateTimeViewModelBookLiveDataGetDateStart);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, javaLangStringDateUpdateConvertDateTimeConvertDateTimeViewModelBookLiveDataGetDateUpdate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, javaLangStringTraslatorViewModelBookLiveDataGetTranslators);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, javaLangStringDesctiptionViewModelBookLiveDataGetDes);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ViewModel.bookLiveData
        flag 1 (0x2L): ViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}