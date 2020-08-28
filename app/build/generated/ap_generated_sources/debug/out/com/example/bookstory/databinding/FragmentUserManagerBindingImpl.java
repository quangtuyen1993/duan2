package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentUserManagerBindingImpl extends FragmentUserManagerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvEnjoy, 3);
        sViewsWithIds.put(R.id.tvInfo, 4);
        sViewsWithIds.put(R.id.bt_signOut, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentUserManagerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FragmentUserManagerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvEmail.setTag(null);
        this.tvName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.viewmodel == variableId) {
            setViewmodel((com.example.bookstory.ui.main.fragment.user.usermanager.UserManagerViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.example.bookstory.ui.main.fragment.user.usermanager.UserManagerViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodelGetFullName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewmodelGetEmail((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelGetFullName(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelGetFullName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelGetEmail(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelGetEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        java.lang.String viewmodelGetEmailGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelGetFullName = null;
        java.lang.String viewmodelGetFullNameGetValue = null;
        java.lang.String javaLangStringNameViewmodelGetFullName = null;
        java.lang.String javaLangStringEmailViewmodelGetEmail = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelGetEmail = null;
        com.example.bookstory.ui.main.fragment.user.usermanager.UserManagerViewModel viewmodel = mViewmodel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.getFullName
                        viewmodelGetFullName = viewmodel.getFullName();
                    }
                    updateLiveDataRegistration(0, viewmodelGetFullName);


                    if (viewmodelGetFullName != null) {
                        // read viewmodel.getFullName.getValue()
                        viewmodelGetFullNameGetValue = viewmodelGetFullName.getValue();
                    }


                    // read ("Name:") + (viewmodel.getFullName.getValue())
                    javaLangStringNameViewmodelGetFullName = ("Name:") + (viewmodelGetFullNameGetValue);
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.getEmail
                        viewmodelGetEmail = viewmodel.getEmail();
                    }
                    updateLiveDataRegistration(1, viewmodelGetEmail);


                    if (viewmodelGetEmail != null) {
                        // read viewmodel.getEmail.getValue()
                        viewmodelGetEmailGetValue = viewmodelGetEmail.getValue();
                    }


                    // read ("Email: ") + (viewmodel.getEmail.getValue())
                    javaLangStringEmailViewmodelGetEmail = ("Email: ") + (viewmodelGetEmailGetValue);
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvEmail, javaLangStringEmailViewmodelGetEmail);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, javaLangStringNameViewmodelGetFullName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewmodel.getFullName
        flag 1 (0x2L): viewmodel.getEmail
        flag 2 (0x3L): viewmodel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}