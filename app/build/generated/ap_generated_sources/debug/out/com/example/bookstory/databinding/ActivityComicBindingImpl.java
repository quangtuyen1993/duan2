package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityComicBindingImpl extends ActivityComicBinding implements com.example.bookstory.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearLayout2, 4);
        sViewsWithIds.put(R.id.rv_img, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityComicBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityComicBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[2]
            , (android.widget.Button) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.LinearLayout) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            );
        this.btNext.setTag(null);
        this.btPre.setTag(null);
        this.etName.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback5 = new com.example.bookstory.generated.callback.OnClickListener(this, 2);
        mCallback4 = new com.example.bookstory.generated.callback.OnClickListener(this, 1);
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
            setViewModel((com.example.bookstory.ui.comic.ComicViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.bookstory.ui.comic.ComicViewModel ViewModel) {
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
                return onChangeViewModelChapNumber((androidx.lifecycle.MutableLiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelChapNumber(androidx.lifecycle.MutableLiveData<java.lang.Integer> ViewModelChapNumber, int fieldId) {
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
        com.example.bookstory.ui.comic.ComicViewModel viewModel = mViewModel;
        java.lang.Integer viewModelChapNumberGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Integer> viewModelChapNumber = null;
        java.lang.String javaLangStringViewModelChapNumber = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read ViewModel.chapNumber
                    viewModelChapNumber = viewModel.getChapNumber();
                }
                updateLiveDataRegistration(0, viewModelChapNumber);


                if (viewModelChapNumber != null) {
                    // read ViewModel.chapNumber.getValue()
                    viewModelChapNumberGetValue = viewModelChapNumber.getValue();
                }


                // read ("") + (ViewModel.chapNumber.getValue())
                javaLangStringViewModelChapNumber = ("") + (viewModelChapNumberGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btNext.setOnClickListener(mCallback5);
            this.btPre.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etName, javaLangStringViewModelChapNumber);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // ViewModel
                com.example.bookstory.ui.comic.ComicViewModel viewModel = mViewModel;
                // ViewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onNext();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // ViewModel
                com.example.bookstory.ui.comic.ComicViewModel viewModel = mViewModel;
                // ViewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onPre();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ViewModel.chapNumber
        flag 1 (0x2L): ViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}