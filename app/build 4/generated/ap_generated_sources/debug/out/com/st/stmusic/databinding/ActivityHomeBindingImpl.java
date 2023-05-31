package com.st.stmusic.databinding;
import com.st.stmusic.R;
import com.st.stmusic.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityHomeBindingImpl extends ActivityHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tabLayout, 1);
        sViewsWithIds.put(R.id.toolbarPlaylist2, 2);
        sViewsWithIds.put(R.id.homeVp, 3);
        sViewsWithIds.put(R.id.constraintLayout2, 4);
        sViewsWithIds.put(R.id.button2, 5);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.viewpager2.widget.ViewPager2) bindings[3]
            , (androidx.constraintlayout.motion.widget.MotionLayout) bindings[0]
            , (com.google.android.material.tabs.TabLayout) bindings[1]
            , (androidx.appcompat.widget.Toolbar) bindings[2]
            );
        this.motionLayout.setTag(null);
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
        if (BR.ActivityAccessObject == variableId) {
            setActivityAccessObject((com.st.stmusic.PlayerActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivityAccessObject(@Nullable com.st.stmusic.PlayerActivity ActivityAccessObject) {
        this.mActivityAccessObject = ActivityAccessObject;
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
        flag 0 (0x1L): ActivityAccessObject
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}