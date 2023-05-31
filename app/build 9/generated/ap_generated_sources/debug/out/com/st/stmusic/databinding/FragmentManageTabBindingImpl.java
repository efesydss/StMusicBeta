package com.st.stmusic.databinding;
import com.st.stmusic.R;
import com.st.stmusic.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentManageTabBindingImpl extends FragmentManageTabBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbarManageTab, 1);
        sViewsWithIds.put(R.id.constraintLayout4, 2);
        sViewsWithIds.put(R.id.checkBox, 3);
        sViewsWithIds.put(R.id.checkBox2, 4);
        sViewsWithIds.put(R.id.imageView9, 5);
        sViewsWithIds.put(R.id.checkBox3, 6);
        sViewsWithIds.put(R.id.checkBox4, 7);
        sViewsWithIds.put(R.id.checkBox5, 8);
        sViewsWithIds.put(R.id.checkBox6, 9);
        sViewsWithIds.put(R.id.imageView7, 10);
        sViewsWithIds.put(R.id.imageView10, 11);
        sViewsWithIds.put(R.id.imageView11, 12);
        sViewsWithIds.put(R.id.imageView12, 13);
        sViewsWithIds.put(R.id.imageView13, 14);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentManageTabBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentManageTabBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.CheckBox) bindings[3]
            , (android.widget.CheckBox) bindings[4]
            , (android.widget.CheckBox) bindings[6]
            , (android.widget.CheckBox) bindings[7]
            , (android.widget.CheckBox) bindings[8]
            , (android.widget.CheckBox) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[5]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            );
        this.constraint1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}