package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRegisterBindingImpl extends FragmentRegisterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.pr_loading, 5);
        sViewsWithIds.put(R.id.bt_control, 6);
        sViewsWithIds.put(R.id.bt_register, 7);
        sViewsWithIds.put(R.id.bt_login, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etEmailandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ViewModel.email.getValue()
            //         is ViewModel.email.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etEmail);
            // localize variables for thread safety
            // ViewModel.email
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelEmail = null;
            // ViewModel.email.getValue()
            java.lang.String viewModelEmailGetValue = null;
            // ViewModel.email != null
            boolean viewModelEmailJavaLangObjectNull = false;
            // ViewModel
            com.example.bookstory.ui.main.fragment.user.register.RegisterViewModel viewModel = mViewModel;
            // ViewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelEmail = viewModel.email;

                viewModelEmailJavaLangObjectNull = (viewModelEmail) != (null);
                if (viewModelEmailJavaLangObjectNull) {




                    viewModelEmail.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etNameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ViewModel.name.getValue()
            //         is ViewModel.name.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etName);
            // localize variables for thread safety
            // ViewModel.name
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelName = null;
            // ViewModel.name.getValue()
            java.lang.String viewModelNameGetValue = null;
            // ViewModel
            com.example.bookstory.ui.main.fragment.user.register.RegisterViewModel viewModel = mViewModel;
            // ViewModel.name != null
            boolean viewModelNameJavaLangObjectNull = false;
            // ViewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelName = viewModel.name;

                viewModelNameJavaLangObjectNull = (viewModelName) != (null);
                if (viewModelNameJavaLangObjectNull) {




                    viewModelName.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etPassandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ViewModel.password.getValue()
            //         is ViewModel.password.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etPass);
            // localize variables for thread safety
            // ViewModel.password != null
            boolean viewModelPasswordJavaLangObjectNull = false;
            // ViewModel.password
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPassword = null;
            // ViewModel
            com.example.bookstory.ui.main.fragment.user.register.RegisterViewModel viewModel = mViewModel;
            // ViewModel.password.getValue()
            java.lang.String viewModelPasswordGetValue = null;
            // ViewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelPassword = viewModel.password;

                viewModelPasswordJavaLangObjectNull = (viewModelPassword) != (null);
                if (viewModelPasswordJavaLangObjectNull) {




                    viewModelPassword.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener textViewandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ViewModel.error.getValue()
            //         is ViewModel.error.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textView);
            // localize variables for thread safety
            // ViewModel.error
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelError = null;
            // ViewModel.error != null
            boolean viewModelErrorJavaLangObjectNull = false;
            // ViewModel
            com.example.bookstory.ui.main.fragment.user.register.RegisterViewModel viewModel = mViewModel;
            // ViewModel.error.getValue()
            java.lang.String viewModelErrorGetValue = null;
            // ViewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelError = viewModel.error;

                viewModelErrorJavaLangObjectNull = (viewModelError) != (null);
                if (viewModelErrorJavaLangObjectNull) {




                    viewModelError.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentRegisterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentRegisterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.Button) bindings[8]
            , (android.widget.Button) bindings[7]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[2]
            , (android.widget.ProgressBar) bindings[5]
            , (android.widget.TextView) bindings[4]
            );
        this.etEmail.setTag(null);
        this.etName.setTag(null);
        this.etPass.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
            setViewModel((com.example.bookstory.ui.main.fragment.user.register.RegisterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.bookstory.ui.main.fragment.user.register.RegisterViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelEmail((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelError((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelEmail(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelError(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelName(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelPassword(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelEmail = null;
        com.example.bookstory.ui.main.fragment.user.register.RegisterViewModel viewModel = mViewModel;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelError = null;
        java.lang.String viewModelNameGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelName = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPassword = null;
        java.lang.String viewModelEmailGetValue = null;
        java.lang.String viewModelPasswordGetValue = null;
        java.lang.String viewModelErrorGetValue = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.email
                        viewModelEmail = viewModel.email;
                    }
                    updateLiveDataRegistration(0, viewModelEmail);


                    if (viewModelEmail != null) {
                        // read ViewModel.email.getValue()
                        viewModelEmailGetValue = viewModelEmail.getValue();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.error
                        viewModelError = viewModel.error;
                    }
                    updateLiveDataRegistration(1, viewModelError);


                    if (viewModelError != null) {
                        // read ViewModel.error.getValue()
                        viewModelErrorGetValue = viewModelError.getValue();
                    }
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.name
                        viewModelName = viewModel.name;
                    }
                    updateLiveDataRegistration(2, viewModelName);


                    if (viewModelName != null) {
                        // read ViewModel.name.getValue()
                        viewModelNameGetValue = viewModelName.getValue();
                    }
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.password
                        viewModelPassword = viewModel.password;
                    }
                    updateLiveDataRegistration(3, viewModelPassword);


                    if (viewModelPassword != null) {
                        // read ViewModel.password.getValue()
                        viewModelPasswordGetValue = viewModelPassword.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etEmail, viewModelEmailGetValue);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etEmail, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etEmailandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etName, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etNameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etPass, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etPassandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textView, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textViewandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etName, viewModelNameGetValue);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etPass, viewModelPasswordGetValue);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView, viewModelErrorGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ViewModel.email
        flag 1 (0x2L): ViewModel.error
        flag 2 (0x3L): ViewModel.name
        flag 3 (0x4L): ViewModel.password
        flag 4 (0x5L): ViewModel
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}