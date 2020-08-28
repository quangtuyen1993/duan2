package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rlHeader, 1);
        sViewsWithIds.put(R.id.ivLogo, 2);
        sViewsWithIds.put(R.id.carouselView, 3);
        sViewsWithIds.put(R.id.tvTitle, 4);
        sViewsWithIds.put(R.id.rv, 5);
        sViewsWithIds.put(R.id.tvTitleTopBooks, 6);
        sViewsWithIds.put(R.id.rvTopViews, 7);
        sViewsWithIds.put(R.id.progressBar, 8);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.synnapps.carouselview.CarouselView) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ProgressBar) bindings[8]
            , (android.widget.RelativeLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[6]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.homeViewModel == variableId) {
            setHomeViewModel((com.example.bookstory.ui.main.fragment.home.home.HomeViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHomeViewModel(@Nullable com.example.bookstory.ui.main.fragment.home.home.HomeViewModel HomeViewModel) {
        this.mHomeViewModel = HomeViewModel;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): homeViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}