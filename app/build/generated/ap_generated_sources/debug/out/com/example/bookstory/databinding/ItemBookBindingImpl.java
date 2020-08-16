package com.example.bookstory.databinding;
import com.example.bookstory.R;
import com.example.bookstory.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemBookBindingImpl extends ItemBookBinding  {

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
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final de.hdodenhof.circleimageview.CircleImageView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemBookBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemBookBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (de.hdodenhof.circleimageview.CircleImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.tvChapters.setTag(null);
        this.tvDateUpdate.setTag(null);
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
        if (BR.book == variableId) {
            setBook((com.example.bookstory.vo.Book) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBook(@Nullable com.example.bookstory.vo.Book Book) {
        this.mBook = Book;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.book);
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
        java.lang.String bookGetName = null;
        com.example.bookstory.vo.Book book = mBook;
        java.lang.String convertDateTimeConvertDateTimeBookGetDateUpdate = null;
        java.lang.String bookGetTranslators = null;
        java.lang.String bookGetImgUrl = null;
        java.lang.String bookGetDateUpdate = null;
        java.lang.String javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComicsJavaLangStringTGBookGetTranslators = null;
        java.lang.String javaLangStringCPNhTConvertDateTimeConvertDateTimeBookGetDateUpdate = null;
        java.lang.String javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComicsJavaLangStringTG = null;
        int bookGetChapters = 0;
        boolean bookGetChaptersInt0 = false;
        int bookGetChaptersInt0BookGetChaptersBookGetComics = 0;
        int bookGetComics = 0;
        java.lang.String javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComics = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (book != null) {
                    // read book.getName()
                    bookGetName = book.getName();
                    // read book.getTranslators
                    bookGetTranslators = book.getTranslators();
                    // read book.getImgUrl()
                    bookGetImgUrl = book.getImgUrl();
                    // read book.getDateUpdate()
                    bookGetDateUpdate = book.getDateUpdate();
                    // read book.getChapters
                    bookGetChapters = book.getChapters();
                }


                // read ConvertDateTime.convertDateTime(book.getDateUpdate())
                convertDateTimeConvertDateTimeBookGetDateUpdate = com.example.bookstory.util.ConvertDateTime.convertDateTime(bookGetDateUpdate);
                // read book.getChapters > 0
                bookGetChaptersInt0 = (bookGetChapters) > (0);
            if((dirtyFlags & 0x3L) != 0) {
                if(bookGetChaptersInt0) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read ("Cập nhật: ") + (ConvertDateTime.convertDateTime(book.getDateUpdate()))
                javaLangStringCPNhTConvertDateTimeConvertDateTimeBookGetDateUpdate = ("Cập nhật: ") + (convertDateTimeConvertDateTimeBookGetDateUpdate);
        }
        // batch finished

        if ((dirtyFlags & 0x4L) != 0) {

                if (book != null) {
                    // read book.getComics
                    bookGetComics = book.getComics();
                }
        }

        if ((dirtyFlags & 0x3L) != 0) {

                // read book.getChapters > 0 ? book.getChapters : book.getComics
                bookGetChaptersInt0BookGetChaptersBookGetComics = ((bookGetChaptersInt0) ? (bookGetChapters) : (bookGetComics));


                // read ("Chương: ") + (book.getChapters > 0 ? book.getChapters : book.getComics)
                javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComics = ("Chương: ") + (bookGetChaptersInt0BookGetChaptersBookGetComics);


                // read (("Chương: ") + (book.getChapters > 0 ? book.getChapters : book.getComics)) + ("-T/g: ")
                javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComicsJavaLangStringTG = (javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComics) + ("-T/g: ");


                // read ((("Chương: ") + (book.getChapters > 0 ? book.getChapters : book.getComics)) + ("-T/g: ")) + (book.getTranslators)
                javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComicsJavaLangStringTGBookGetTranslators = (javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComicsJavaLangStringTG) + (bookGetTranslators);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.bookstory.vo.History.setImageView(this.mboundView1, bookGetImgUrl, androidx.appcompat.content.res.AppCompatResources.getDrawable(mboundView1.getContext(), R.drawable.ic_library_books_black_24dp));
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvChapters, javaLangStringChNgBookGetChaptersInt0BookGetChaptersBookGetComicsJavaLangStringTGBookGetTranslators);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDateUpdate, javaLangStringCPNhTConvertDateTimeConvertDateTimeBookGetDateUpdate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, bookGetName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): book
        flag 1 (0x2L): null
        flag 2 (0x3L): book.getChapters > 0 ? book.getChapters : book.getComics
        flag 3 (0x4L): book.getChapters > 0 ? book.getChapters : book.getComics
    flag mapping end*/
    //end
}