package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemBookHistoryBindingImpl extends ItemBookHistoryBinding  {

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
    @NonNull
    private final de.hdodenhof.circleimageview.CircleImageView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemBookHistoryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemBookHistoryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (de.hdodenhof.circleimageview.CircleImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.tvChapters.setTag(null);
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
        if (BR.history == variableId) {
            setHistory((com.example.bookstory.vo.History) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHistory(@Nullable com.example.bookstory.vo.History History) {
        this.mHistory = History;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.history);
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
        int historyChapterState = 0;
        java.lang.String historyBookGetImgUrl = null;
        com.example.bookstory.vo.History history = mHistory;
        java.lang.String javaLangStringChuongDangDocHistoryChapterState = null;
        com.example.bookstory.vo.Book historyBook = null;
        java.lang.String historyBookGetName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (history != null) {
                    // read history.chapterState
                    historyChapterState = history.getChapterState();
                    // read history.book
                    historyBook = history.getBook();
                }


                // read ("Chuong dang doc: ") + (history.chapterState)
                javaLangStringChuongDangDocHistoryChapterState = ("Chuong dang doc: ") + (historyChapterState);
                if (historyBook != null) {
                    // read history.book.getImgUrl()
                    historyBookGetImgUrl = historyBook.getImgUrl();
                    // read history.book.getName()
                    historyBookGetName = historyBook.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.bookstory.vo.History.setImageView(this.mboundView1, historyBookGetImgUrl, androidx.appcompat.content.res.AppCompatResources.getDrawable(mboundView1.getContext(), R.drawable.ic_library_books_black_24dp));
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvChapters, javaLangStringChuongDangDocHistoryChapterState);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, historyBookGetName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): history
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}