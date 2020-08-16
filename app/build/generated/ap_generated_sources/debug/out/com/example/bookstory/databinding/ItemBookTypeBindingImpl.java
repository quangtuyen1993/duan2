package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemBookTypeBindingImpl extends ItemBookTypeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemBookTypeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ItemBookTypeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.bookType == variableId) {
            setBookType((com.example.bookstory.vo.BookType) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBookType(@Nullable com.example.bookstory.vo.BookType BookType) {
        this.mBookType = BookType;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.bookType);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        java.lang.String bookTypeName = null;
        com.example.bookstory.vo.BookType bookType = mBookType;

        if ((dirtyFlags & 0x3L) != 0) {



                if (bookType != null) {
                    // read bookType.name
                    bookTypeName = bookType.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, bookTypeName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): bookType
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}