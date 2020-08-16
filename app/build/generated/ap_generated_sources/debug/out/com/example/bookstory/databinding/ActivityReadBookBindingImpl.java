package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityReadBookBindingImpl extends ActivityReadBookBinding implements com.example.bookstory.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.pr_loading, 5);
        sViewsWithIds.put(R.id.ln_control, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener tvContentandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ViewModel.chapterLiveData.getValue().content
            //         is ViewModel.chapterLiveData.getValue().setContent((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(tvContent);
            // localize variables for thread safety
            // ViewModel.chapterLiveData.getValue() != null
            boolean viewModelChapterLiveDataGetValueJavaLangObjectNull = false;
            // ViewModel.chapterLiveData.getValue().content
            java.lang.String viewModelChapterLiveDataContent = null;
            // ViewModel.chapterLiveData != null
            boolean viewModelChapterLiveDataJavaLangObjectNull = false;
            // ViewModel
            com.example.bookstory.ui.readbook.ReadBookViewModel viewModel = mViewModel;
            // ViewModel.chapterLiveData
            androidx.lifecycle.LiveData<com.example.bookstory.vo.Chapter> viewModelChapterLiveData = null;
            // ViewModel.chapterLiveData.getValue()
            com.example.bookstory.vo.Chapter viewModelChapterLiveDataGetValue = null;
            // ViewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelChapterLiveData = viewModel.chapterLiveData;

                viewModelChapterLiveDataJavaLangObjectNull = (viewModelChapterLiveData) != (null);
                if (viewModelChapterLiveDataJavaLangObjectNull) {


                    viewModelChapterLiveDataGetValue = viewModelChapterLiveData.getValue();

                    viewModelChapterLiveDataGetValueJavaLangObjectNull = (viewModelChapterLiveDataGetValue) != (null);
                    if (viewModelChapterLiveDataGetValueJavaLangObjectNull) {




                        viewModelChapterLiveDataGetValue.setContent(((java.lang.String) (callbackArg_0)));
                    }
                }
            }
        }
    };

    public ActivityReadBookBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityReadBookBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[2]
            , (android.widget.Button) bindings[1]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.ProgressBar) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            );
        this.btNext.setTag(null);
        this.btPre.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvContent.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.bookstory.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.example.bookstory.generated.callback.OnClickListener(this, 2);
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
            setViewModel((com.example.bookstory.ui.readbook.ReadBookViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.bookstory.ui.readbook.ReadBookViewModel ViewModel) {
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
                return onChangeViewModelChapterLiveData((androidx.lifecycle.LiveData<com.example.bookstory.vo.Chapter>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelChapterLiveData(androidx.lifecycle.LiveData<com.example.bookstory.vo.Chapter> ViewModelChapterLiveData, int fieldId) {
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
        com.example.bookstory.ui.readbook.ReadBookViewModel viewModel = mViewModel;
        java.lang.String viewModelChapterLiveDataContent = null;
        java.lang.String viewModelChapterLiveDataName = null;
        androidx.lifecycle.LiveData<com.example.bookstory.vo.Chapter> viewModelChapterLiveData = null;
        com.example.bookstory.vo.Chapter viewModelChapterLiveDataGetValue = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read ViewModel.chapterLiveData
                    viewModelChapterLiveData = viewModel.chapterLiveData;
                }
                updateLiveDataRegistration(0, viewModelChapterLiveData);


                if (viewModelChapterLiveData != null) {
                    // read ViewModel.chapterLiveData.getValue()
                    viewModelChapterLiveDataGetValue = viewModelChapterLiveData.getValue();
                }


                if (viewModelChapterLiveDataGetValue != null) {
                    // read ViewModel.chapterLiveData.getValue().content
                    viewModelChapterLiveDataContent = viewModelChapterLiveDataGetValue.getContent();
                    // read ViewModel.chapterLiveData.getValue().name
                    viewModelChapterLiveDataName = viewModelChapterLiveDataGetValue.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btNext.setOnClickListener(mCallback2);
            this.btPre.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.tvContent, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, tvContentandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvContent, viewModelChapterLiveDataContent);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTitle, viewModelChapterLiveDataName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // ViewModel
                com.example.bookstory.ui.readbook.ReadBookViewModel viewModel = mViewModel;
                // ViewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onPre();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // ViewModel
                com.example.bookstory.ui.readbook.ReadBookViewModel viewModel = mViewModel;
                // ViewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onNext();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ViewModel.chapterLiveData
        flag 1 (0x2L): ViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}