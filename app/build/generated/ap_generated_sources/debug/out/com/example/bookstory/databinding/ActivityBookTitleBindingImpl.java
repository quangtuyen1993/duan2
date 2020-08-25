package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityBookTitleBindingImpl extends ActivityBookTitleBinding implements com.example.bookstory.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.constraintLayout, 12);
        sViewsWithIds.put(R.id.toolbar_title, 13);
        sViewsWithIds.put(R.id.linearDev, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final de.hdodenhof.circleimageview.CircleImageView mboundView1;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityBookTitleBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivityBookTitleBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[14]
            , (androidx.appcompat.widget.Toolbar) bindings[13]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[10]
            );
        this.btReadBook.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (de.hdodenhof.circleimageview.CircleImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.tvAuthor.setTag(null);
        this.tvBookType.setTag(null);
        this.tvChapters.setTag(null);
        this.tvDateCreate.setTag(null);
        this.tvDateUpdate.setTag(null);
        this.tvDescription.setTag(null);
        this.tvName.setTag(null);
        this.tvState.setTag(null);
        this.tvTranslator.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.example.bookstory.generated.callback.OnClickListener(this, 1);
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
        if (BR.viewholder == variableId) {
            setViewholder((com.example.bookstory.ui.booktitle.BookTitleViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewholder(@Nullable com.example.bookstory.ui.booktitle.BookTitleViewModel Viewholder) {
        this.mViewholder = Viewholder;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewholder);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewholderBookLive((androidx.lifecycle.MutableLiveData<com.example.bookstory.vo.Book>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewholderBookLive(androidx.lifecycle.MutableLiveData<com.example.bookstory.vo.Book> ViewholderBookLive, int fieldId) {
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
        java.lang.String javaLangStringTMTTViewholderBookLiveDes = null;
        java.lang.String viewholderBookLiveDateUpdate = null;
        java.lang.String javaLangStringNhMDChViewholderBookLiveTranslators = null;
        java.lang.String javaLangStringStateViewholderBookLiveStatus = null;
        java.lang.String viewholderBookLiveBookTypeToString = null;
        java.lang.String javaLangStringThLoIViewholderBookLiveBookTypeToString = null;
        java.lang.String javaLangStringDateCreateConvertDateTimeConvertDateTimeViewholderBookLiveDateStart = null;
        java.lang.String viewholderBookLiveImgUrl = null;
        com.example.bookstory.vo.Book viewholderBookLiveGetValue = null;
        java.lang.String javaLangStringAuthorViewholderBookLiveGetAuthor = null;
        com.example.bookstory.ui.booktitle.BookTitleViewModel viewholder = mViewholder;
        java.lang.String viewholderBookLiveTranslators = null;
        java.util.List<com.example.bookstory.vo.BookType> viewholderBookLiveBookType = null;
        java.lang.String viewholderBookLiveGetAuthor = null;
        java.lang.String convertDateTimeConvertDateTimeViewholderBookLiveDateUpdate = null;
        java.lang.String viewholderBookLiveDes = null;
        java.lang.String javaLangStringChaptersViewholderBookLiveChapters = null;
        androidx.lifecycle.MutableLiveData<com.example.bookstory.vo.Book> viewholderBookLive = null;
        java.lang.String viewholderBookLiveStatus = null;
        int viewholderBookLiveChapters = 0;
        java.lang.String convertDateTimeConvertDateTimeViewholderBookLiveDateStart = null;
        java.lang.String viewholderBookLiveDateStart = null;
        java.lang.String viewholderBookLiveName = null;
        java.lang.String javaLangStringDateUpdateConvertDateTimeConvertDateTimeViewholderBookLiveDateUpdate = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewholder != null) {
                    // read viewholder.bookLive
                    viewholderBookLive = viewholder.getBookLive();
                }
                updateLiveDataRegistration(0, viewholderBookLive);


                if (viewholderBookLive != null) {
                    // read viewholder.bookLive.getValue()
                    viewholderBookLiveGetValue = viewholderBookLive.getValue();
                }


                if (viewholderBookLiveGetValue != null) {
                    // read viewholder.bookLive.getValue().dateUpdate
                    viewholderBookLiveDateUpdate = viewholderBookLiveGetValue.getDateUpdate();
                    // read viewholder.bookLive.getValue().imgUrl
                    viewholderBookLiveImgUrl = viewholderBookLiveGetValue.getImgUrl();
                    // read viewholder.bookLive.getValue().translators
                    viewholderBookLiveTranslators = viewholderBookLiveGetValue.getTranslators();
                    // read viewholder.bookLive.getValue().bookType
                    viewholderBookLiveBookType = viewholderBookLiveGetValue.getBookType();
                    // read viewholder.bookLive.getValue().getAuthor
                    viewholderBookLiveGetAuthor = viewholderBookLiveGetValue.getAuthor();
                    // read viewholder.bookLive.getValue().des
                    viewholderBookLiveDes = viewholderBookLiveGetValue.getDes();
                    // read viewholder.bookLive.getValue().status
                    viewholderBookLiveStatus = viewholderBookLiveGetValue.getStatus();
                    // read viewholder.bookLive.getValue().chapters
                    viewholderBookLiveChapters = viewholderBookLiveGetValue.getChapters();
                    // read viewholder.bookLive.getValue().dateStart
                    viewholderBookLiveDateStart = viewholderBookLiveGetValue.getDateStart();
                    // read viewholder.bookLive.getValue().name
                    viewholderBookLiveName = viewholderBookLiveGetValue.getName();
                }


                // read ConvertDateTime.convertDateTime(viewholder.bookLive.getValue().dateUpdate)
                convertDateTimeConvertDateTimeViewholderBookLiveDateUpdate = com.example.bookstory.util.ConvertDateTime.convertDateTime(viewholderBookLiveDateUpdate);
                // read ("Nhóm dịch: ") + (viewholder.bookLive.getValue().translators)
                javaLangStringNhMDChViewholderBookLiveTranslators = ("Nhóm dịch: ") + (viewholderBookLiveTranslators);
                // read ("Author: ") + (viewholder.bookLive.getValue().getAuthor)
                javaLangStringAuthorViewholderBookLiveGetAuthor = ("Author: ") + (viewholderBookLiveGetAuthor);
                // read ("Tóm tắt:") + (viewholder.bookLive.getValue().des)
                javaLangStringTMTTViewholderBookLiveDes = ("Tóm tắt:") + (viewholderBookLiveDes);
                // read ("State: ") + (viewholder.bookLive.getValue().status)
                javaLangStringStateViewholderBookLiveStatus = ("State: ") + (viewholderBookLiveStatus);
                // read ("Chapters") + (viewholder.bookLive.getValue().chapters)
                javaLangStringChaptersViewholderBookLiveChapters = ("Chapters") + (viewholderBookLiveChapters);
                // read ConvertDateTime.convertDateTime(viewholder.bookLive.getValue().dateStart)
                convertDateTimeConvertDateTimeViewholderBookLiveDateStart = com.example.bookstory.util.ConvertDateTime.convertDateTime(viewholderBookLiveDateStart);
                if (viewholderBookLiveBookType != null) {
                    // read viewholder.bookLive.getValue().bookType.toString()
                    viewholderBookLiveBookTypeToString = viewholderBookLiveBookType.toString();
                }


                // read ("Date Update") + (ConvertDateTime.convertDateTime(viewholder.bookLive.getValue().dateUpdate))
                javaLangStringDateUpdateConvertDateTimeConvertDateTimeViewholderBookLiveDateUpdate = ("Date Update") + (convertDateTimeConvertDateTimeViewholderBookLiveDateUpdate);
                // read ("Date Create") + (ConvertDateTime.convertDateTime(viewholder.bookLive.getValue().dateStart))
                javaLangStringDateCreateConvertDateTimeConvertDateTimeViewholderBookLiveDateStart = ("Date Create") + (convertDateTimeConvertDateTimeViewholderBookLiveDateStart);
                // read ("Thể loại: ") + (viewholder.bookLive.getValue().bookType.toString())
                javaLangStringThLoIViewholderBookLiveBookTypeToString = ("Thể loại: ") + (viewholderBookLiveBookTypeToString);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btReadBook.setOnClickListener(mCallback3);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.example.bookstory.util.ImgHandler.setImgUrl(this.mboundView1, viewholderBookLiveImgUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvAuthor, javaLangStringAuthorViewholderBookLiveGetAuthor);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvBookType, javaLangStringThLoIViewholderBookLiveBookTypeToString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvChapters, javaLangStringChaptersViewholderBookLiveChapters);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDateCreate, javaLangStringDateCreateConvertDateTimeConvertDateTimeViewholderBookLiveDateStart);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDateUpdate, javaLangStringDateUpdateConvertDateTimeConvertDateTimeViewholderBookLiveDateUpdate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDescription, javaLangStringTMTTViewholderBookLiveDes);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, viewholderBookLiveName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvState, javaLangStringStateViewholderBookLiveStatus);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTranslator, javaLangStringNhMDChViewholderBookLiveTranslators);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewholder.bookLive != null
        boolean viewholderBookLiveJavaLangObjectNull = false;
        // viewholder.bookLive
        androidx.lifecycle.MutableLiveData<com.example.bookstory.vo.Book> viewholderBookLive = null;
        // viewholder
        com.example.bookstory.ui.booktitle.BookTitleViewModel viewholder = mViewholder;
        // viewholder.bookLive.getValue()
        com.example.bookstory.vo.Book viewholderBookLiveGetValue = null;
        // viewholder != null
        boolean viewholderJavaLangObjectNull = false;



        viewholderJavaLangObjectNull = (viewholder) != (null);
        if (viewholderJavaLangObjectNull) {




            viewholderBookLive = viewholder.getBookLive();

            viewholderBookLiveJavaLangObjectNull = (viewholderBookLive) != (null);
            if (viewholderBookLiveJavaLangObjectNull) {


                viewholderBookLiveGetValue = viewholderBookLive.getValue();

                viewholder.onChangeScreen(viewholderBookLiveGetValue);
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewholder.bookLive
        flag 1 (0x2L): viewholder
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}