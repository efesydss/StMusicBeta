package com.st.stmusic.databinding;
import com.st.stmusic.R;
import com.st.stmusic.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentControlLockScreenBindingImpl extends FragmentControlLockScreenBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbarControlLock, 1);
        sViewsWithIds.put(R.id.rd3, 2);
        sViewsWithIds.put(R.id.rdUse, 3);
        sViewsWithIds.put(R.id.rdUseSystemDef, 4);
        sViewsWithIds.put(R.id.rd2, 5);
        sViewsWithIds.put(R.id.rdShow, 6);
        sViewsWithIds.put(R.id.rdHide, 7);
        sViewsWithIds.put(R.id.textView, 8);
        sViewsWithIds.put(R.id.textView4, 9);
        sViewsWithIds.put(R.id.textView5, 10);
        sViewsWithIds.put(R.id.rd1, 11);
        sViewsWithIds.put(R.id.rdSmall, 12);
        sViewsWithIds.put(R.id.rdMedium, 13);
        sViewsWithIds.put(R.id.rdLarge, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentControlLockScreenBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentControlLockScreenBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RadioGroup) bindings[11]
            , (android.widget.RadioGroup) bindings[5]
            , (android.widget.RadioGroup) bindings[2]
            , (android.widget.RadioButton) bindings[7]
            , (android.widget.RadioButton) bindings[14]
            , (android.widget.RadioButton) bindings[13]
            , (android.widget.RadioButton) bindings[6]
            , (android.widget.RadioButton) bindings[12]
            , (android.widget.RadioButton) bindings[3]
            , (android.widget.RadioButton) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
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