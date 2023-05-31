package com.st.stmusic.databinding;
import com.st.stmusic.R;
import com.st.stmusic.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPlayerBindingImpl extends ActivityPlayerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbarPLayer, 1);
        sViewsWithIds.put(R.id.txtSongNameBig, 2);
        sViewsWithIds.put(R.id.txtArtistName, 3);
        sViewsWithIds.put(R.id.txtGecen, 4);
        sViewsWithIds.put(R.id.txtKalan, 5);
        sViewsWithIds.put(R.id.imgBig, 6);
        sViewsWithIds.put(R.id.imgAddFavoritesButton, 7);
        sViewsWithIds.put(R.id.seekBar, 8);
        sViewsWithIds.put(R.id.imgShuffleButton, 9);
        sViewsWithIds.put(R.id.btnTriple, 10);
        sViewsWithIds.put(R.id.imgPlayPause, 11);
        sViewsWithIds.put(R.id.btnNext, 12);
        sViewsWithIds.put(R.id.btnPrevious, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPlayerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityPlayerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.SeekBar) bindings[8]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
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
        if (BR.PlayerActivityAccessObject == variableId) {
            setPlayerActivityAccessObject((com.st.stmusic.PlayerActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPlayerActivityAccessObject(@Nullable com.st.stmusic.PlayerActivity PlayerActivityAccessObject) {
        this.mPlayerActivityAccessObject = PlayerActivityAccessObject;
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
        flag 0 (0x1L): PlayerActivityAccessObject
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}